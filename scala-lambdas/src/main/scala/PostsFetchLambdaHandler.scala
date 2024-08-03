package asana.test

import asana.test.ProductHuntClient._
import caliban.client.SelectionBuilder
import sttp.client3._
import sttp.client3.asynchttpclient.zio.{AsyncHttpClientZioBackend, send}
import com.amazonaws.services.lambda.runtime.events.{APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse}
import com.amazonaws.services.lambda.runtime.Context
import zio._
import com.amazonaws.services.lambda.runtime.RequestHandler
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax.EncoderOps


class PostsFetchLambdaHandler extends RequestHandler[APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse] {

  private case class PostView(id: String, name: String, tagline: String, description: Option[String], createdAt: DateTime, thumbnailUrl: Option[String])

  private def fetchPosts(): ZIO[Any, Throwable, (Int, List[PostView])] = {
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

    val uri = uri"https://api.producthunt.com/v2/api/graphql"

    val request = query.toRequest(uri)

    request.auth.bearer("tokennn")

    send(query.toRequest(uri))
      .map(_.body)
      .absolve
      .tap(res => ZIO.debug(s"Result: $res"))
      .provideSomeLayer(AsyncHttpClientZioBackend.layer())
  }


  override def handleRequest(event: APIGatewayV2HTTPEvent, context: Context): APIGatewayV2HTTPResponse = {
    val logger = context.getLogger
    logger.log("EVENT TYPE: " + event.getClass)

    val runtime = Runtime.default

    val result = Unsafe.unsafe { implicit unsafe =>
      runtime.unsafe.run(
        fetchPosts().foldZIO(
          err => ZIO.succeed(
            APIGatewayV2HTTPResponse.builder()
              .withStatusCode(500)
              .withBody(s"""{"error": "Failed to fetch posts: ${err.getMessage}"}""")
              .build()
          ),
          postsData => {
            val (totalCount, posts) = postsData
            val responseJson = Json.obj(
              "totalCount" -> Json.fromInt(totalCount),
              "posts" -> Json.fromValues(posts.map(_.asJson))
            )
            ZIO.succeed(
              APIGatewayV2HTTPResponse.builder()
                .withStatusCode(200)
                .withBody(responseJson.noSpaces)
                .build()
            )
          }
        )
      ).getOrThrowFiberFailure()
    }

    result
  }
}
