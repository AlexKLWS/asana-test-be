package asana.test

import com.amazonaws.services.lambda.runtime.events.{APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse}
import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success, Try}
import io.circe._
import io.circe.parser._
import io.circe.generic.semiauto._

class PostViewLambdaHandler extends RequestHandler[APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse] {
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

    val body = event.getBody
    logger.log("EVENT BODY: " + event.getBody)

    implicit val topicViewDecoder: Decoder[TopicView] = deriveDecoder[TopicView]
    implicit val postViewDecoder: Decoder[PostView] = deriveDecoder[PostView]

    val parsedInput: Either[Error, PostView] = decode[PostView](body)

    val post = parsedInput.fold(error => {
      logger.log(s"Error occurred: ${error.getMessage}")
      return APIGatewayV2HTTPResponse.builder()
        .withStatusCode(500)
        .withBody("Error parsing body!")
        .build()
    },
      post => post)

    val timeout = 40.seconds

    val resultFuture = DBQueries.insertUserViewedPostWithTopics(DBConnection.db, username, post)

    val result = Try(Await.result(resultFuture, timeout))

    result match {
      case Success(response) => APIGatewayV2HTTPResponse.builder()
        .withStatusCode(200)
        .build()
      case Failure(exception) =>
        logger.log(s"Error occurred: ${exception.getMessage}")
        APIGatewayV2HTTPResponse.builder()
          .withStatusCode(500)
          .withBody("Internal Server Error")
          .build()
    }
  }
}
