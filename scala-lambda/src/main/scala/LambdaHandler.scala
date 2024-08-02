import java.util.{ Map => JavaMap }

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.RequestHandler


class LambdaHandler extends RequestHandler[JavaMap[String, String], String]:
  override def handleRequest(event: JavaMap[String, String], context: Context): String =
    val logger = context.getLogger

    logger.log("EVENT TYPE: " + event.getClass)

    "Hello from Scala!"
  
