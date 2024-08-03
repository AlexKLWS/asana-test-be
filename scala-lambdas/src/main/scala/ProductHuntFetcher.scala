package asana.test

import asana.test.ProductHuntClient._
import caliban.client.{CalibanClientError, SelectionBuilder}
import sttp.capabilities.WebSockets
import sttp.capabilities.zio.ZioStreams
import sttp.client3._
import sttp.client3.httpclient.zio.HttpClientZioBackend
import zio.Console.printLine
import zio._

object ProductHuntFetcher extends ZIOAppDefault {

  private case class PostView(id: String, name: String, tagline: String, description: Option[String], createdAt: DateTime, thumbnailUrl: Option[String])

  def run: ZIO[Any with ZIOAppArgs with Scope, Throwable, (RuntimeFlags, List[PostView])] = {
    val post: SelectionBuilder[Post, PostView] =
      (Post.id ~ Post.name ~ Post.tagline ~ Post.description ~ Post.createdAt ~ Post.thumbnail(Media.url()))
        .mapN(PostView)

    val query = Query.posts(last = Some(20)) {
      PostConnection.totalCount ~
        PostConnection.edges {
          PostEdge.node {
            post
          }
        }
    }

    val uri = uri"https://api.deutschebahn.com/free1bahnql/v1/graphql"

    ZIO
      .serviceWithZIO[SttpBackend[Task, ZioStreams with WebSockets]](query.toRequest(uri, useVariables = true).send(_))
      .map(_.body)
      .absolve
      .tap(res => printLine(s"Result: $res"))
  }
}
