package asana.test
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile: slick.jdbc.JdbcProfile = slick.jdbc.MySQLProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for
  // tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = JointTopicPosts.schema ++ Topics.schema ++ UserViewedPosts.schema

  /** Entity class storing rows of table JointTopicPosts
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param postId Database column post_id SqlType(INT UNSIGNED)
   *  @param topicName Database column topic_name SqlType(VARCHAR), Length(64,true) */
  case class JointTopicPostsRow(id: Int, postId: Long, topicName: String)
  /** GetResult implicit for fetching JointTopicPostsRow objects using plain SQL queries */
  implicit def GetResultJointTopicPostsRow(implicit e0: GR[Int], e1: GR[Long], e2: GR[String]): GR[JointTopicPostsRow] = GR{
    prs => import prs._
    (JointTopicPostsRow.apply _).tupled((<<[Int], <<[Long], <<[String]))
  }
  /** Table description of table joint_topic_posts. Objects of this class serve as prototypes for rows in queries. */
  class JointTopicPosts(_tableTag: Tag) extends profile.api.Table[JointTopicPostsRow](_tableTag, Some("asana_test"), "joint_topic_posts") {
    def * = ((id, postId, topicName)).mapTo[JointTopicPostsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(postId), Rep.Some(topicName))).shaped.<>({r=>import r._; _1.map(_=> (JointTopicPostsRow.apply _).tupled((_1.get, _2.get, _3.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column post_id SqlType(INT UNSIGNED) */
    val postId: Rep[Long] = column[Long]("post_id")
    /** Database column topic_name SqlType(VARCHAR), Length(64,true) */
    val topicName: Rep[String] = column[String]("topic_name", O.Length(64,varying=true))
  }
  /** Collection-like TableQuery object for table JointTopicPosts */
  lazy val JointTopicPosts = new TableQuery(tag => new JointTopicPosts(tag))

  /** Entity class storing rows of table Topics
   *  @param name Database column name SqlType(VARCHAR), PrimaryKey, Length(64,true)
   *  @param description Database column description SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
  case class TopicsRow(name: String, description: Option[String] = None)
  /** GetResult implicit for fetching TopicsRow objects using plain SQL queries */
  implicit def GetResultTopicsRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[TopicsRow] = GR{
    prs => import prs._
    (TopicsRow.apply _).tupled((<<[String], <<?[String]))
  }
  /** Table description of table topics. Objects of this class serve as prototypes for rows in queries. */
  class Topics(_tableTag: Tag) extends profile.api.Table[TopicsRow](_tableTag, Some("asana_test"), "topics") {
    def * = ((name, description)).mapTo[TopicsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(name), description)).shaped.<>({r=>import r._; _1.map(_=> (TopicsRow.apply _).tupled((_1.get, _2)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), PrimaryKey, Length(64,true) */
    val name: Rep[String] = column[String]("name", O.PrimaryKey, O.Length(64,varying=true))
    /** Database column description SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(16777215,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Topics */
  lazy val Topics = new TableQuery(tag => new Topics(tag))

  /** Entity class storing rows of table UserViewedPosts
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param viewedByUser Database column viewed_by_user SqlType(VARCHAR), Length(45,true)
   *  @param postId Database column post_id SqlType(INT UNSIGNED) */
  case class UserViewedPostsRow(id: Int, viewedByUser: String, postId: Long)
  /** GetResult implicit for fetching UserViewedPostsRow objects using plain SQL queries */
  implicit def GetResultUserViewedPostsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Long]): GR[UserViewedPostsRow] = GR{
    prs => import prs._
    (UserViewedPostsRow.apply _).tupled((<<[Int], <<[String], <<[Long]))
  }
  /** Table description of table user_viewed_posts. Objects of this class serve as prototypes for rows in queries. */
  class UserViewedPosts(_tableTag: Tag) extends profile.api.Table[UserViewedPostsRow](_tableTag, Some("asana_test"), "user_viewed_posts") {
    def * = ((id, viewedByUser, postId)).mapTo[UserViewedPostsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(viewedByUser), Rep.Some(postId))).shaped.<>({r=>import r._; _1.map(_=> (UserViewedPostsRow.apply _).tupled((_1.get, _2.get, _3.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column viewed_by_user SqlType(VARCHAR), Length(45,true) */
    val viewedByUser: Rep[String] = column[String]("viewed_by_user", O.Length(45,varying=true))
    /** Database column post_id SqlType(INT UNSIGNED) */
    val postId: Rep[Long] = column[Long]("post_id")
  }
  /** Collection-like TableQuery object for table UserViewedPosts */
  lazy val UserViewedPosts = new TableQuery(tag => new UserViewedPosts(tag))
}
