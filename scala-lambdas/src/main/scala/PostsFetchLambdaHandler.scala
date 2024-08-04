package asana.test

import ProductHuntClient._

import caliban.client.SelectionBuilder
import sttp.client3._
import sttp.client3.asynchttpclient.zio.{AsyncHttpClientZioBackend, send}
import com.amazonaws.services.lambda.runtime.events.{APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse}
import com.amazonaws.services.lambda.runtime.Context
import zio._
import com.amazonaws.services.lambda.runtime.RequestHandler
import io.circe._
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}


class PostsFetchLambdaHandler extends RequestHandler[APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse] {

  private case class TopicView(name: String, description: String)

  private case class PostView(id: String, name: String, tagline: String, description: Option[String], createdAt: DateTime, thumbnailUrl: Option[String], topics: List[TopicView])

  private def fetchPosts(): ZIO[Any, Throwable, (Int, List[PostView])] = {
    val topic: SelectionBuilder[Topic, TopicView] = (Topic.name ~ Topic.description).mapN(TopicView)

    val post: SelectionBuilder[Post, PostView] =
      (Post.id ~ Post.name ~ Post.tagline ~ Post.description ~ Post.createdAt ~ Post.thumbnail(Media.url()) ~ Post.topics() {
        TopicConnection.edges {
          TopicEdge.node {
            topic
          }
        }
      }).mapN(PostView)

    val query = Query.posts(last = Some(14)) {
      PostConnection.totalCount ~
        PostConnection.edges {
          PostEdge.node {
            post
          }
        }
    }

    val uri = uri"https://api.producthunt.com/v2/api/graphql"

    val token = sys.env("PRODUCT_HUNT_ACCESS_TOKEN")
    val request = query.toRequest(uri).auth.bearer(token)

    send(request)
      .map(_.body)
      .absolve
      .tap(res => ZIO.debug(s"Result: $res"))
      .provideSomeLayer(AsyncHttpClientZioBackend.layer())
  }

  private def fetchPostsWrapped(recommendedTopicNames: Seq[String]) = {
    val runtime = Runtime.default

    Unsafe.unsafe { implicit unsafe =>
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
            val (forYouPosts, remainingPosts) = posts.partition(post => post.topics.exists(topic => recommendedTopicNames.contains(topic.name)))
            val responseJson = Json.obj(
              "totalCount" -> Json.fromInt(totalCount),
              "forYou" -> Json.fromValues(forYouPosts.map(_.asJson)),
              "posts" -> Json.fromValues(remainingPosts.map(_.asJson))
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
  }

  override def handleRequest(event: APIGatewayV2HTTPEvent, context: Context): APIGatewayV2HTTPResponse = {
    val logger = context.getLogger
    logger.log("EVENT TYPE: " + event.getClass)

    if (!event.getHeaders.containsKey("username")) {
      return APIGatewayV2HTTPResponse.builder()
        .withStatusCode(500)
        .withBody("Missing Username!")
        .build()
    }

    val username = event.getHeaders.get("username")

    val resultFuture: Future[APIGatewayV2HTTPResponse] = DBQueries.getTopicsForTopUserViewedPosts(DBConnection.db, username).map { topics =>
      val topicNames = topics.map(t => t.name)
      fetchPostsWrapped(topicNames)
    }

    val timeout = 40.seconds.asScala

    val result: Try[APIGatewayV2HTTPResponse] = Try(Await.result(resultFuture, timeout))

    result match {
      case Success(response) => response
      case Failure(exception) =>
        logger.log(s"Error occurred: ${exception.getMessage}")
        APIGatewayV2HTTPResponse.builder()
          .withStatusCode(500)
          .withBody("Internal Server Error")
          .build()
    }
  }
}
