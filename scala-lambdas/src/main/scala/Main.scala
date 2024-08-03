package asana.test

import asana.test.Client._
import caliban.client.{CalibanClientError, SelectionBuilder}
import sttp.capabilities.WebSockets
import sttp.capabilities.zio.ZioStreams
import sttp.client3._
import sttp.client3.httpclient.zio.HttpClientZioBackend
import zio.Console.printLine
import zio._

object Main extends ZIOAppDefault {

  sealed trait Role

  object Role {
    case class Captain(shipName: String) extends Role

    case class Pilot(shipName: String) extends Role

    case class Engineer(shipName: String) extends Role

    case class Mechanic(shipName: String) extends Role
  }

  case class CharacterView(name: String, nickname: List[String], origin: Origin)

  def run = {
    val character: SelectionBuilder[Character, CharacterView] =
      (Character.name ~ Character.nicknames ~ Character.origin)
        .mapN(CharacterView)

    val query =
      Queries.characters(None) {
        character
      } ~
        Queries.character("Amos Burton") {
          character
        } ~
        Queries.character("Naomi Nagata") {
          character
        } ~
        Queries.character("Alex Kamal") {
          character
        }
    val mutation = Mutations.deleteCharacter("James Holden")

    def sendRequest[T](
                        req: Request[Either[CalibanClientError, T], Any]
                      ): RIO[SttpBackend[Task, ZioStreams with WebSockets], T] =
      ZIO
        .serviceWithZIO[SttpBackend[Task, ZioStreams with WebSockets]](req.send(_))
        .map(_.body)
        .absolve
        .tap(res => printLine(s"Result: $res"))

    val uri = uri"http://localhost:8088/api/graphql"
    val call1 = sendRequest(mutation.toRequest(uri))
    val call2 = sendRequest(query.toRequest(uri, useVariables = true))

    (call1 *> call2).provideLayer(HttpClientZioBackend.layer())
  }
}