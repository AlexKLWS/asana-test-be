package asana.test

import ProductHuntClient.DateTime

case class PostView(id: String, name: String, tagline: String, description: Option[String], createdAt: DateTime, thumbnailUrl: Option[String], topics: List[TopicView])
