package asana.test

import slick.jdbc.MySQLProfile.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

case class SimpleUserViewedPost(viewedByUser: String, postId: Long)

case class Topic(name: String, description: String)

object DBQueries {

  def getTopicsForTopUserViewedPosts(db: Database, username: String): Future[Seq[Tables.TopicsRow]] = {
    val top3UserViewedPostsQuery = Tables.UserViewedPosts
      .filter(_.viewedByUser === username)
      .sortBy(_.id.desc)
      .take(3)

    val query = for {
      userViewedPost <- top3UserViewedPostsQuery
      jointTopicPost <- Tables.JointTopicPosts if userViewedPost.postId === jointTopicPost.postId
      topic <- Tables.Topics if jointTopicPost.topicName === topic.name
    } yield topic

    db.run(query.result)
  }

  def insertUserViewedPostWithTopics(db: Database, username: String, post: PostView): Future[Unit] = {
    val topicsRows = post.topics.map { topic =>
      Tables.TopicsRow(name = topic.name, description = Some(topic.description))
    }

    val simpleUserViewedPost = SimpleUserViewedPost(username, post.id.toLong)

    val insertUserViewedPostAction = (Tables.UserViewedPosts.map(u => (u.viewedByUser, u.postId))
      += (simpleUserViewedPost.viewedByUser, simpleUserViewedPost.postId)).map(_ => simpleUserViewedPost.postId)

    val checkAndInsertTopicsAction = DBIO.sequence {
      topicsRows.map { topicRow =>
        Tables.Topics.filter(_.name === topicRow.name).result.headOption.flatMap {
          case None => Tables.Topics += topicRow
          case Some(_) => DBIO.successful(0)
        }
      }
    }

    val insertJointTopicPostsAction = (postId: Long) => {
      val jointTopicPosts = topicsRows.map { topicRow =>
        Tables.JointTopicPostsRow(0, postId, topicRow.name)
      }
      Tables.JointTopicPosts ++= jointTopicPosts
    }

    val transactionAction = for {
      postId <- insertUserViewedPostAction
      _ <- checkAndInsertTopicsAction
      _ <- insertJointTopicPostsAction(postId)
    } yield ()

    db.run(transactionAction.transactionally)
  }
}
