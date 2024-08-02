import caliban.client.CalibanClientError.DecodingError
import caliban.client.FieldBuilder._
import caliban.client._
import caliban.client.__Value._

object ProductHuntClient {

  type DateTime = String

  sealed trait CollectionsOrder extends scala.Product with scala.Serializable {
    def value: String
  }
  object CollectionsOrder {
    case object FEATURED_AT extends CollectionsOrder {
      val value: String = "FEATURED_AT"
    }
    case object FOLLOWERS_COUNT extends CollectionsOrder {
      val value: String = "FOLLOWERS_COUNT"
    }
    case object NEWEST extends CollectionsOrder { val value: String = "NEWEST" }

    implicit val decoder: ScalarDecoder[CollectionsOrder] = {
      case __StringValue("FEATURED_AT") => Right(CollectionsOrder.FEATURED_AT)
      case __StringValue("FOLLOWERS_COUNT") =>
        Right(CollectionsOrder.FOLLOWERS_COUNT)
      case __StringValue("NEWEST") => Right(CollectionsOrder.NEWEST)
      case other =>
        Left(DecodingError(s"Can't build CollectionsOrder from input $other"))
    }
    implicit val encoder: ArgEncoder[CollectionsOrder] = {
      case CollectionsOrder.FEATURED_AT     => __EnumValue("FEATURED_AT")
      case CollectionsOrder.FOLLOWERS_COUNT => __EnumValue("FOLLOWERS_COUNT")
      case CollectionsOrder.NEWEST          => __EnumValue("NEWEST")
    }

    val values: scala.collection.immutable.Vector[CollectionsOrder] =
      scala.collection.immutable.Vector(FEATURED_AT, FOLLOWERS_COUNT, NEWEST)
  }

  sealed trait CommentsOrder extends scala.Product with scala.Serializable {
    def value: String
  }
  object CommentsOrder {
    case object NEWEST extends CommentsOrder { val value: String = "NEWEST" }
    case object VOTES_COUNT extends CommentsOrder {
      val value: String = "VOTES_COUNT"
    }

    implicit val decoder: ScalarDecoder[CommentsOrder] = {
      case __StringValue("NEWEST")      => Right(CommentsOrder.NEWEST)
      case __StringValue("VOTES_COUNT") => Right(CommentsOrder.VOTES_COUNT)
      case other =>
        Left(DecodingError(s"Can't build CommentsOrder from input $other"))
    }
    implicit val encoder: ArgEncoder[CommentsOrder] = {
      case CommentsOrder.NEWEST      => __EnumValue("NEWEST")
      case CommentsOrder.VOTES_COUNT => __EnumValue("VOTES_COUNT")
    }

    val values: scala.collection.immutable.Vector[CommentsOrder] =
      scala.collection.immutable.Vector(NEWEST, VOTES_COUNT)
  }

  sealed trait GoalsOrder extends scala.Product with scala.Serializable {
    def value: String
  }
  object GoalsOrder {
    case object COMPLETED_AT extends GoalsOrder {
      val value: String = "COMPLETED_AT"
    }
    case object DUE_AT extends GoalsOrder { val value: String = "DUE_AT" }
    case object NEWEST extends GoalsOrder { val value: String = "NEWEST" }

    implicit val decoder: ScalarDecoder[GoalsOrder] = {
      case __StringValue("COMPLETED_AT") => Right(GoalsOrder.COMPLETED_AT)
      case __StringValue("DUE_AT")       => Right(GoalsOrder.DUE_AT)
      case __StringValue("NEWEST")       => Right(GoalsOrder.NEWEST)
      case other =>
        Left(DecodingError(s"Can't build GoalsOrder from input $other"))
    }
    implicit val encoder: ArgEncoder[GoalsOrder] = {
      case GoalsOrder.COMPLETED_AT => __EnumValue("COMPLETED_AT")
      case GoalsOrder.DUE_AT       => __EnumValue("DUE_AT")
      case GoalsOrder.NEWEST       => __EnumValue("NEWEST")
    }

    val values: scala.collection.immutable.Vector[GoalsOrder] =
      scala.collection.immutable.Vector(COMPLETED_AT, DUE_AT, NEWEST)
  }

  sealed trait MakerGroupsOrder extends scala.Product with scala.Serializable {
    def value: String
  }
  object MakerGroupsOrder {
    case object GOALS_COUNT extends MakerGroupsOrder {
      val value: String = "GOALS_COUNT"
    }
    case object LAST_ACTIVE extends MakerGroupsOrder {
      val value: String = "LAST_ACTIVE"
    }
    case object MEMBERS_COUNT extends MakerGroupsOrder {
      val value: String = "MEMBERS_COUNT"
    }
    case object NEWEST extends MakerGroupsOrder { val value: String = "NEWEST" }

    implicit val decoder: ScalarDecoder[MakerGroupsOrder] = {
      case __StringValue("GOALS_COUNT") => Right(MakerGroupsOrder.GOALS_COUNT)
      case __StringValue("LAST_ACTIVE") => Right(MakerGroupsOrder.LAST_ACTIVE)
      case __StringValue("MEMBERS_COUNT") =>
        Right(MakerGroupsOrder.MEMBERS_COUNT)
      case __StringValue("NEWEST") => Right(MakerGroupsOrder.NEWEST)
      case other =>
        Left(DecodingError(s"Can't build MakerGroupsOrder from input $other"))
    }
    implicit val encoder: ArgEncoder[MakerGroupsOrder] = {
      case MakerGroupsOrder.GOALS_COUNT   => __EnumValue("GOALS_COUNT")
      case MakerGroupsOrder.LAST_ACTIVE   => __EnumValue("LAST_ACTIVE")
      case MakerGroupsOrder.MEMBERS_COUNT => __EnumValue("MEMBERS_COUNT")
      case MakerGroupsOrder.NEWEST        => __EnumValue("NEWEST")
    }

    val values: scala.collection.immutable.Vector[MakerGroupsOrder] =
      scala.collection.immutable.Vector(
        GOALS_COUNT,
        LAST_ACTIVE,
        MEMBERS_COUNT,
        NEWEST
      )
  }

  sealed trait PostsOrder extends scala.Product with scala.Serializable {
    def value: String
  }
  object PostsOrder {
    case object FEATURED_AT extends PostsOrder {
      val value: String = "FEATURED_AT"
    }
    case object NEWEST extends PostsOrder { val value: String = "NEWEST" }
    case object RANKING extends PostsOrder { val value: String = "RANKING" }
    case object VOTES extends PostsOrder { val value: String = "VOTES" }

    implicit val decoder: ScalarDecoder[PostsOrder] = {
      case __StringValue("FEATURED_AT") => Right(PostsOrder.FEATURED_AT)
      case __StringValue("NEWEST")      => Right(PostsOrder.NEWEST)
      case __StringValue("RANKING")     => Right(PostsOrder.RANKING)
      case __StringValue("VOTES")       => Right(PostsOrder.VOTES)
      case other =>
        Left(DecodingError(s"Can't build PostsOrder from input $other"))
    }
    implicit val encoder: ArgEncoder[PostsOrder] = {
      case PostsOrder.FEATURED_AT => __EnumValue("FEATURED_AT")
      case PostsOrder.NEWEST      => __EnumValue("NEWEST")
      case PostsOrder.RANKING     => __EnumValue("RANKING")
      case PostsOrder.VOTES       => __EnumValue("VOTES")
    }

    val values: scala.collection.immutable.Vector[PostsOrder] =
      scala.collection.immutable.Vector(FEATURED_AT, NEWEST, RANKING, VOTES)
  }

  sealed trait TopicsOrder extends scala.Product with scala.Serializable {
    def value: String
  }
  object TopicsOrder {
    case object FOLLOWERS_COUNT extends TopicsOrder {
      val value: String = "FOLLOWERS_COUNT"
    }
    case object NEWEST extends TopicsOrder { val value: String = "NEWEST" }

    implicit val decoder: ScalarDecoder[TopicsOrder] = {
      case __StringValue("FOLLOWERS_COUNT") =>
        Right(TopicsOrder.FOLLOWERS_COUNT)
      case __StringValue("NEWEST") => Right(TopicsOrder.NEWEST)
      case other =>
        Left(DecodingError(s"Can't build TopicsOrder from input $other"))
    }
    implicit val encoder: ArgEncoder[TopicsOrder] = {
      case TopicsOrder.FOLLOWERS_COUNT => __EnumValue("FOLLOWERS_COUNT")
      case TopicsOrder.NEWEST          => __EnumValue("NEWEST")
    }

    val values: scala.collection.immutable.Vector[TopicsOrder] =
      scala.collection.immutable.Vector(FOLLOWERS_COUNT, NEWEST)
  }

  type TopicableInterface
  object TopicableInterface {

    /** ID of the object.
      */
    def id: SelectionBuilder[TopicableInterface, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Look up topics that are associated with the object.
      */
    def topics[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[TopicConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[TopicableInterface, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "topics",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )
  }

  type VotableInterface
  object VotableInterface {

    /** ID of the object
      */
    def id: SelectionBuilder[VotableInterface, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Whether the Viewer has voted for the object or not.
      */
    def isVoted: SelectionBuilder[VotableInterface, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isVoted", Scalar())
    def votes[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        createdAfter: scala.Option[DateTime] = None,
        createdBefore: scala.Option[DateTime] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[VoteConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[DateTime]],
        encoder3: ArgEncoder[scala.Option[DateTime]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[VotableInterface, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "votes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("createdAfter", createdAfter, "DateTime")(encoder2),
          Argument("createdBefore", createdBefore, "DateTime")(encoder3),
          Argument("first", first, "Int")(encoder4),
          Argument("last", last, "Int")(encoder5)
        )
      )

    /** Number of votes that the object has currently.
      */
    def votesCount: SelectionBuilder[VotableInterface, Int] =
      _root_.caliban.client.SelectionBuilder.Field("votesCount", Scalar())
  }

  type Collection
  object Collection {

    /** Cover image for the collection.
      */
    def coverImage(
        height: scala.Option[Int] = None,
        width: scala.Option[Int] = None
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Collection, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "coverImage",
        OptionOf(Scalar()),
        arguments = List(
          Argument("height", height, "Int")(encoder0),
          Argument("width", width, "Int")(encoder1)
        )
      )

    /** Identifies the date and time when collection was created.
      */
    def createdAt: SelectionBuilder[Collection, DateTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdAt", Scalar())

    /** Description of the collection in plain text.
      */
    def description: SelectionBuilder[Collection, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))

    /** Identifies the date and time when collection was featured.
      */
    def featuredAt: SelectionBuilder[Collection, scala.Option[DateTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("featuredAt", OptionOf(Scalar()))

    /** Number of users following the collection.
      */
    def followersCount: SelectionBuilder[Collection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("followersCount", Scalar())

    /** ID of the collection.
      */
    def id: SelectionBuilder[Collection, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Whether the viewer is following the collection or not.
      */
    def isFollowing: SelectionBuilder[Collection, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isFollowing", Scalar())

    /** Name of the collection.
      */
    def name: SelectionBuilder[Collection, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())

    /** Lookup posts which are part of the collection.
      */
    def posts[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[PostConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Collection, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "posts",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** Tagline of the collection.
      */
    def tagline: SelectionBuilder[Collection, String] =
      _root_.caliban.client.SelectionBuilder.Field("tagline", Scalar())

    /** Look up topics that are associated with the object.
      */
    def topics[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[TopicConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Collection, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "topics",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** Public URL of the goal.
      */
    def url: SelectionBuilder[Collection, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())

    /** User who created the collection.
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Collection, A] =
      _root_.caliban.client.SelectionBuilder.Field("user", Obj(innerSelection))

    /** ID of User who created the collection.
      */
    def userId: SelectionBuilder[Collection, String] =
      _root_.caliban.client.SelectionBuilder.Field("userId", Scalar())
  }

  type CollectionConnection
  object CollectionConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[CollectionEdge, A]
    ): SelectionBuilder[CollectionConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[CollectionConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[CollectionConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type CollectionEdge
  object CollectionEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[CollectionEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Collection, A]
    ): SelectionBuilder[CollectionEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type Comment
  object Comment {

    /** Body of the comment.
      */
    def body: SelectionBuilder[Comment, String] =
      _root_.caliban.client.SelectionBuilder.Field("body", Scalar())

    /** Identifies the date and time when comment was created.
      */
    def createdAt: SelectionBuilder[Comment, DateTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdAt", Scalar())

    /** ID of the comment.
      */
    def id: SelectionBuilder[Comment, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Whether the Viewer has voted for the object or not.
      */
    def isVoted: SelectionBuilder[Comment, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isVoted", Scalar())

    /** Comment on which this comment was posted(null in case of top level
      * comments).
      */
    def parent[A](
        innerSelection: SelectionBuilder[Comment, A]
    ): SelectionBuilder[Comment, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("parent", OptionOf(Obj(innerSelection)))

    /** ID of Comment on which this comment was posted(null in case of top level
      * comments).
      */
    def parentId: SelectionBuilder[Comment, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("parentId", OptionOf(Scalar()))

    /** Lookup comments that were posted on the comment itself.
      */
    def replies[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[CommentsOrder] = None
    )(innerSelection: SelectionBuilder[CommentConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[CommentsOrder]]
    ): SelectionBuilder[Comment, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "replies",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("last", last, "Int")(encoder3),
          Argument("order", order, "CommentsOrder")(encoder4)
        )
      )

    /** Public URL of the comment.
      */
    def url: SelectionBuilder[Comment, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())

    /** User who posted the comment.
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Comment, A] =
      _root_.caliban.client.SelectionBuilder.Field("user", Obj(innerSelection))

    /** ID of User who posted the comment.
      */
    def userId: SelectionBuilder[Comment, String] =
      _root_.caliban.client.SelectionBuilder.Field("userId", Scalar())
    def votes[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        createdAfter: scala.Option[DateTime] = None,
        createdBefore: scala.Option[DateTime] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[VoteConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[DateTime]],
        encoder3: ArgEncoder[scala.Option[DateTime]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Comment, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "votes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("createdAfter", createdAfter, "DateTime")(encoder2),
          Argument("createdBefore", createdBefore, "DateTime")(encoder3),
          Argument("first", first, "Int")(encoder4),
          Argument("last", last, "Int")(encoder5)
        )
      )

    /** Number of votes that the object has currently.
      */
    def votesCount: SelectionBuilder[Comment, Int] =
      _root_.caliban.client.SelectionBuilder.Field("votesCount", Scalar())
  }

  type CommentConnection
  object CommentConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[CommentEdge, A]
    ): SelectionBuilder[CommentConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[CommentConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[CommentConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type CommentEdge
  object CommentEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[CommentEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Comment, A]
    ): SelectionBuilder[CommentEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type Error
  object Error {

    /** Field for which the error occurred.
      */
    def field: SelectionBuilder[Error, String] =
      _root_.caliban.client.SelectionBuilder.Field("field", Scalar())

    /** Error message.
      */
    def message: SelectionBuilder[Error, String] =
      _root_.caliban.client.SelectionBuilder.Field("message", Scalar())
  }

  type Goal
  object Goal {

    /** Number of cheers on the Goal.
      */
    def cheerCount: SelectionBuilder[Goal, Int] =
      _root_.caliban.client.SelectionBuilder.Field("cheerCount", Scalar())

    /** Identifies the date and time when goal was marked as completed.
      */
    def completedAt: SelectionBuilder[Goal, scala.Option[DateTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("completedAt", OptionOf(Scalar()))

    /** Identifies the date and time when goal was created.
      */
    def createdAt: SelectionBuilder[Goal, DateTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdAt", Scalar())

    /** Whether the goal is user's current goal or not.
      */
    def current: SelectionBuilder[Goal, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("current", Scalar())

    /** Identifies the date and time until the goal is user's current goal.
      */
    def currentUntil: SelectionBuilder[Goal, scala.Option[DateTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("currentUntil", OptionOf(Scalar()))

    /** Identifies the date and time when goal is due.
      */
    def dueAt: SelectionBuilder[Goal, scala.Option[DateTime]] =
      _root_.caliban.client.SelectionBuilder.Field("dueAt", OptionOf(Scalar()))

    /** Total time spent in focus mode in seconds, starts at 0
      */
    def focusedDuration: SelectionBuilder[Goal, Int] =
      _root_.caliban.client.SelectionBuilder.Field("focusedDuration", Scalar())

    /** Maker group to which the goal belongs to.
      */
    def group[A](
        innerSelection: SelectionBuilder[MakerGroup, A]
    ): SelectionBuilder[Goal, A] =
      _root_.caliban.client.SelectionBuilder.Field("group", Obj(innerSelection))

    /** ID of Maker group to which the goal belongs to.
      */
    def groupId: SelectionBuilder[Goal, String] =
      _root_.caliban.client.SelectionBuilder.Field("groupId", Scalar())

    /** ID of the goal.
      */
    def id: SelectionBuilder[Goal, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Whether the Viewer has cheered the goal or not.
      */
    def isCheered: SelectionBuilder[Goal, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isCheered", Scalar())

    /** Maker project to which the goal belongs to.
      */
    def project[A](
        innerSelection: SelectionBuilder[MakerProject, A]
    ): SelectionBuilder[Goal, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("project", OptionOf(Obj(innerSelection)))

    /** ID of Maker project to which the goal belongs to.
      */
    def projectId: SelectionBuilder[Goal, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("projectId", OptionOf(Scalar()))

    /** Title of the goal in plain text
      */
    def title: SelectionBuilder[Goal, String] =
      _root_.caliban.client.SelectionBuilder.Field("title", Scalar())

    /** Public URL of the goal.
      */
    def url: SelectionBuilder[Goal, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())

    /** User who created the goal.
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Goal, A] =
      _root_.caliban.client.SelectionBuilder.Field("user", Obj(innerSelection))

    /** ID of User who created the goal.
      */
    def userId: SelectionBuilder[Goal, String] =
      _root_.caliban.client.SelectionBuilder.Field("userId", Scalar())
  }

  type GoalCheerPayload
  object GoalCheerPayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[GoalCheerPayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[GoalCheerPayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[Goal, A]
    ): SelectionBuilder[GoalCheerPayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type GoalCheerUndoPayload
  object GoalCheerUndoPayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[GoalCheerUndoPayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[GoalCheerUndoPayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[Goal, A]
    ): SelectionBuilder[GoalCheerUndoPayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type GoalConnection
  object GoalConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[GoalEdge, A]
    ): SelectionBuilder[GoalConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[GoalConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[GoalConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type GoalCreatePayload
  object GoalCreatePayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[GoalCreatePayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[GoalCreatePayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[Goal, A]
    ): SelectionBuilder[GoalCreatePayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type GoalEdge
  object GoalEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[GoalEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Goal, A]
    ): SelectionBuilder[GoalEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type GoalMarkAsCompletePayload
  object GoalMarkAsCompletePayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[GoalMarkAsCompletePayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[GoalMarkAsCompletePayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[Goal, A]
    ): SelectionBuilder[GoalMarkAsCompletePayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type GoalMarkAsIncompletePayload
  object GoalMarkAsIncompletePayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[GoalMarkAsIncompletePayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[GoalMarkAsIncompletePayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[Goal, A]
    ): SelectionBuilder[GoalMarkAsIncompletePayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type GoalUpdatePayload
  object GoalUpdatePayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[GoalUpdatePayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[GoalUpdatePayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[Goal, A]
    ): SelectionBuilder[GoalUpdatePayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type MakerGroup
  object MakerGroup {

    /** Description of the MakerGroup.
      */
    def description: SelectionBuilder[MakerGroup, String] =
      _root_.caliban.client.SelectionBuilder.Field("description", Scalar())

    /** Number of goals that have been created in the MakerGroup.
      */
    def goalsCount: SelectionBuilder[MakerGroup, Int] =
      _root_.caliban.client.SelectionBuilder.Field("goalsCount", Scalar())

    /** ID of the MakerGroup.
      */
    def id: SelectionBuilder[MakerGroup, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Whether Viewer is member of the MakerGroup or not.
      */
    def isMember: SelectionBuilder[MakerGroup, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isMember", Scalar())

    /** Number of users who are part of the MakerGroup.
      */
    def membersCount: SelectionBuilder[MakerGroup, Int] =
      _root_.caliban.client.SelectionBuilder.Field("membersCount", Scalar())

    /** Name of the MakerGroup.
      */
    def name: SelectionBuilder[MakerGroup, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())

    /** Tagline of the MakerGroup.
      */
    def tagline: SelectionBuilder[MakerGroup, String] =
      _root_.caliban.client.SelectionBuilder.Field("tagline", Scalar())

    /** URL of the MakerGroup.
      */
    def url: SelectionBuilder[MakerGroup, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())
  }

  type MakerGroupConnection
  object MakerGroupConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[MakerGroupEdge, A]
    ): SelectionBuilder[MakerGroupConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[MakerGroupConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[MakerGroupConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type MakerGroupEdge
  object MakerGroupEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[MakerGroupEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[MakerGroup, A]
    ): SelectionBuilder[MakerGroupEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type MakerProject
  object MakerProject {

    /** ID of the MakerProject.
      */
    def id: SelectionBuilder[MakerProject, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Image of the MakerProject.
      */
    def image(
        height: scala.Option[Int] = None,
        width: scala.Option[Int] = None
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[MakerProject, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "image",
        OptionOf(Scalar()),
        arguments = List(
          Argument("height", height, "Int")(encoder0),
          Argument("width", width, "Int")(encoder1)
        )
      )

    /** Whether the MakerProject owner is looking for other makers or not.
      */
    def lookingForOtherMakers: SelectionBuilder[MakerProject, Boolean] =
      _root_.caliban.client.SelectionBuilder
        .Field("lookingForOtherMakers", Scalar())

    /** ID of the MakerProject.
      */
    def name: SelectionBuilder[MakerProject, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())

    /** Tagline of the MakerProject.
      */
    def tagline: SelectionBuilder[MakerProject, String] =
      _root_.caliban.client.SelectionBuilder.Field("tagline", Scalar())

    /** URL of the MakerProject.
      */
    def url: SelectionBuilder[MakerProject, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())
  }

  type MakerProjectConnection
  object MakerProjectConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[MakerProjectEdge, A]
    ): SelectionBuilder[MakerProjectConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[MakerProjectConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[MakerProjectConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type MakerProjectEdge
  object MakerProjectEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[MakerProjectEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[MakerProject, A]
    ): SelectionBuilder[MakerProjectEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type Media
  object Media {

    /** Type of media object.
      */
    def `type`: SelectionBuilder[Media, String] =
      _root_.caliban.client.SelectionBuilder.Field("type", Scalar())

    /** Public URL for the media object. Incase of videos this URL represents
      * thumbnail generated from video.
      */
    def url(height: scala.Option[Int] = None, width: scala.Option[Int] = None)(
        implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Media, String] =
      _root_.caliban.client.SelectionBuilder.Field(
        "url",
        Scalar(),
        arguments = List(
          Argument("height", height, "Int")(encoder0),
          Argument("width", width, "Int")(encoder1)
        )
      )

    /** Video URL of the media object.
      */
    def videoUrl: SelectionBuilder[Media, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("videoUrl", OptionOf(Scalar()))
  }

  type PageInfo
  object PageInfo {

    /** When paginating forwards, the cursor to continue.
      */
    def endCursor: SelectionBuilder[PageInfo, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("endCursor", OptionOf(Scalar()))

    /** When paginating forwards, are there more items?
      */
    def hasNextPage: SelectionBuilder[PageInfo, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("hasNextPage", Scalar())

    /** When paginating backwards, are there more items?
      */
    def hasPreviousPage: SelectionBuilder[PageInfo, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("hasPreviousPage", Scalar())

    /** When paginating backwards, the cursor to continue.
      */
    def startCursor: SelectionBuilder[PageInfo, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("startCursor", OptionOf(Scalar()))
  }

  type Post
  object Post {

    /** Lookup collections which the Post is part of.
      */
    def collections[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[CollectionConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Post, A] = _root_.caliban.client.SelectionBuilder.Field(
      "collections",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** Lookup comments on the Post.
      */
    def comments[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[CommentsOrder] = None
    )(innerSelection: SelectionBuilder[CommentConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[CommentsOrder]]
    ): SelectionBuilder[Post, A] = _root_.caliban.client.SelectionBuilder.Field(
      "comments",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3),
        Argument("order", order, "CommentsOrder")(encoder4)
      )
    )

    /** Number of comments made on the Post.
      */
    def commentsCount: SelectionBuilder[Post, Int] =
      _root_.caliban.client.SelectionBuilder.Field("commentsCount", Scalar())

    /** Identifies the date and time when the Post was created.
      */
    def createdAt: SelectionBuilder[Post, DateTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdAt", Scalar())

    /** Description of the Post in plain text.
      */
    def description: SelectionBuilder[Post, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("description", OptionOf(Scalar()))

    /** Identifies the date and time when the Post was featured.
      */
    def featuredAt: SelectionBuilder[Post, scala.Option[DateTime]] =
      _root_.caliban.client.SelectionBuilder
        .Field("featuredAt", OptionOf(Scalar()))

    /** ID of the Post.
      */
    def id: SelectionBuilder[Post, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Whether the viewer has added the Post to one of their collections.
      */
    def isCollected: SelectionBuilder[Post, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isCollected", Scalar())

    /** Whether the Viewer has voted for the object or not.
      */
    def isVoted: SelectionBuilder[Post, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isVoted", Scalar())

    /** Users who are marked as makers of the Post.
      */
    def makers[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Post, List[A]] = _root_.caliban.client.SelectionBuilder
      .Field("makers", ListOf(Obj(innerSelection)))

    /** Media items for the Post.
      */
    def media[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[Post, List[A]] = _root_.caliban.client.SelectionBuilder
      .Field("media", ListOf(Obj(innerSelection)))

    /** Name of the Post.
      */
    def name: SelectionBuilder[Post, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())

    /** Aggregate review rating for the Post.
      */
    def reviewsRating: SelectionBuilder[Post, Double] =
      _root_.caliban.client.SelectionBuilder.Field("reviewsRating", Scalar())

    /** URL friendly slug of the Post.
      */
    def slug: SelectionBuilder[Post, String] =
      _root_.caliban.client.SelectionBuilder.Field("slug", Scalar())

    /** Tagline of the Post.
      */
    def tagline: SelectionBuilder[Post, String] =
      _root_.caliban.client.SelectionBuilder.Field("tagline", Scalar())

    /** Thumbnail media object of the Post.
      */
    def thumbnail[A](
        innerSelection: SelectionBuilder[Media, A]
    ): SelectionBuilder[Post, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("thumbnail", OptionOf(Obj(innerSelection)))

    /** Look up topics that are associated with the object.
      */
    def topics[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[TopicConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Post, A] = _root_.caliban.client.SelectionBuilder.Field(
      "topics",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** URL of the Post on Product Hunt.
      */
    def url: SelectionBuilder[Post, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())

    /** User who created the Post.
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Post, A] =
      _root_.caliban.client.SelectionBuilder.Field("user", Obj(innerSelection))

    /** ID of User who created the Post.
      */
    def userId: SelectionBuilder[Post, String] =
      _root_.caliban.client.SelectionBuilder.Field("userId", Scalar())
    def votes[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        createdAfter: scala.Option[DateTime] = None,
        createdBefore: scala.Option[DateTime] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[VoteConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[DateTime]],
        encoder3: ArgEncoder[scala.Option[DateTime]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Post, A] = _root_.caliban.client.SelectionBuilder.Field(
      "votes",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("createdAfter", createdAfter, "DateTime")(encoder2),
        Argument("createdBefore", createdBefore, "DateTime")(encoder3),
        Argument("first", first, "Int")(encoder4),
        Argument("last", last, "Int")(encoder5)
      )
    )

    /** Number of votes that the object has currently.
      */
    def votesCount: SelectionBuilder[Post, Int] =
      _root_.caliban.client.SelectionBuilder.Field("votesCount", Scalar())

    /** URL that redirects to the Post's website.
      */
    def website: SelectionBuilder[Post, String] =
      _root_.caliban.client.SelectionBuilder.Field("website", Scalar())
  }

  type PostConnection
  object PostConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PostEdge, A]
    ): SelectionBuilder[PostConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PostConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[PostConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type PostEdge
  object PostEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[PostEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Post, A]
    ): SelectionBuilder[PostEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type Topic
  object Topic {

    /** Identifies the date and time when topic was created.
      */
    def createdAt: SelectionBuilder[Topic, DateTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdAt", Scalar())

    /** Description of the topic.
      */
    def description: SelectionBuilder[Topic, String] =
      _root_.caliban.client.SelectionBuilder.Field("description", Scalar())

    /** Number of users who are following the topic.
      */
    def followersCount: SelectionBuilder[Topic, Int] =
      _root_.caliban.client.SelectionBuilder.Field("followersCount", Scalar())

    /** ID of the topic.
      */
    def id: SelectionBuilder[Topic, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Image of the topic.
      */
    def image(
        height: scala.Option[Int] = None,
        width: scala.Option[Int] = None
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Topic, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "image",
        OptionOf(Scalar()),
        arguments = List(
          Argument("height", height, "Int")(encoder0),
          Argument("width", width, "Int")(encoder1)
        )
      )

    /** Whether the viewer is following the topic or not.
      */
    def isFollowing: SelectionBuilder[Topic, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isFollowing", Scalar())

    /** Name of the topic.
      */
    def name: SelectionBuilder[Topic, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())

    /** Number of posts that are part of the topic.
      */
    def postsCount: SelectionBuilder[Topic, Int] =
      _root_.caliban.client.SelectionBuilder.Field("postsCount", Scalar())

    /** URL friendly slug of the topic.
      */
    def slug: SelectionBuilder[Topic, String] =
      _root_.caliban.client.SelectionBuilder.Field("slug", Scalar())

    /** Public URL of the topic.
      */
    def url: SelectionBuilder[Topic, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())
  }

  type TopicConnection
  object TopicConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[TopicEdge, A]
    ): SelectionBuilder[TopicConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[TopicConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[TopicConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type TopicEdge
  object TopicEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[TopicEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Topic, A]
    ): SelectionBuilder[TopicEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type User
  object User {

    /** Cover image of the user.
      */
    def coverImage(
        height: scala.Option[Int] = None,
        width: scala.Option[Int] = None
    )(implicit
        encoder0: ArgEncoder[scala.Option[Int]],
        encoder1: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "coverImage",
        OptionOf(Scalar()),
        arguments = List(
          Argument("height", height, "Int")(encoder0),
          Argument("width", width, "Int")(encoder1)
        )
      )

    /** Identifies the date and time when user was created.
      */
    def createdAt: SelectionBuilder[User, DateTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdAt", Scalar())

    /** Look up collections that the user is following.
      */
    def followedCollections[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[CollectionConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, A] = _root_.caliban.client.SelectionBuilder.Field(
      "followedCollections",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** Look up other users who are following the user.
      */
    def followers[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[UserConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, A] = _root_.caliban.client.SelectionBuilder.Field(
      "followers",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** Look up other users who are being followed by the user.
      */
    def following[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[UserConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, A] = _root_.caliban.client.SelectionBuilder.Field(
      "following",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** Headline text of the user.
      */
    def headline: SelectionBuilder[User, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("headline", OptionOf(Scalar()))

    /** ID of the user.
      */
    def id: SelectionBuilder[User, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** Whether the viewer is following the user or not.
      */
    def isFollowing: SelectionBuilder[User, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isFollowing", Scalar())

    /** Whether the user is an accepted maker or not.
      */
    def isMaker: SelectionBuilder[User, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isMaker", Scalar())

    /** Whether the user is same as the viewer of the API.
      */
    def isViewer: SelectionBuilder[User, Boolean] =
      _root_.caliban.client.SelectionBuilder.Field("isViewer", Scalar())

    /** Look up posts that the user has made.
      */
    def madePosts[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[PostConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, A] = _root_.caliban.client.SelectionBuilder.Field(
      "madePosts",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** Name of the user.
      */
    def name: SelectionBuilder[User, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())

    /** Profile image of the user.
      */
    def profileImage(size: scala.Option[Int] = None)(implicit
        encoder0: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder.Field(
        "profileImage",
        OptionOf(Scalar()),
        arguments = List(Argument("size", size, "Int")(encoder0))
      )

    /** Look up posts that the user has submitted.
      */
    def submittedPosts[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[PostConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, A] = _root_.caliban.client.SelectionBuilder.Field(
      "submittedPosts",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** Twitter username of the user.
      */
    def twitterUsername: SelectionBuilder[User, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("twitterUsername", OptionOf(Scalar()))

    /** Public URL of the user's profile
      */
    def url: SelectionBuilder[User, String] =
      _root_.caliban.client.SelectionBuilder.Field("url", Scalar())

    /** Username of the user.
      */
    def username: SelectionBuilder[User, String] =
      _root_.caliban.client.SelectionBuilder.Field("username", Scalar())

    /** Look up posts that the user has voted for.
      */
    def votedPosts[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[PostConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[User, A] = _root_.caliban.client.SelectionBuilder.Field(
      "votedPosts",
      Obj(innerSelection),
      arguments = List(
        Argument("after", after, "String")(encoder0),
        Argument("before", before, "String")(encoder1),
        Argument("first", first, "Int")(encoder2),
        Argument("last", last, "Int")(encoder3)
      )
    )

    /** URL for the user's website
      */
    def websiteUrl: SelectionBuilder[User, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("websiteUrl", OptionOf(Scalar()))
  }

  type UserConnection
  object UserConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[UserEdge, A]
    ): SelectionBuilder[UserConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[UserConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[UserConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type UserEdge
  object UserEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[UserEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[UserEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  type UserFollowPayload
  object UserFollowPayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[UserFollowPayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[UserFollowPayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[UserFollowPayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type UserFollowUndoPayload
  object UserFollowUndoPayload {

    /** A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[UserFollowUndoPayload, scala.Option[String]] =
      _root_.caliban.client.SelectionBuilder
        .Field("clientMutationId", OptionOf(Scalar()))
    def errors[A](
        innerSelection: SelectionBuilder[Error, A]
    ): SelectionBuilder[UserFollowUndoPayload, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("errors", ListOf(Obj(innerSelection)))
    def node[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[UserFollowUndoPayload, scala.Option[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("node", OptionOf(Obj(innerSelection)))
  }

  type Viewer
  object Viewer {

    /** Look up goals of the viewer.
      */
    def goals[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        current: scala.Option[Boolean] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[GoalsOrder] = None
    )(innerSelection: SelectionBuilder[GoalConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Boolean]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[GoalsOrder]]
    ): SelectionBuilder[Viewer, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goals",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("current", current, "Boolean")(encoder2),
          Argument("first", first, "Int")(encoder3),
          Argument("last", last, "Int")(encoder4),
          Argument("order", order, "GoalsOrder")(encoder5)
        )
      )

    /** Look up maker groups the viewer is accepted member of.
      */
    def makerGroups[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[MakerGroupsOrder] = None
    )(innerSelection: SelectionBuilder[MakerGroupConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[MakerGroupsOrder]]
    ): SelectionBuilder[Viewer, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "makerGroups",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("last", last, "Int")(encoder3),
          Argument("order", order, "MakerGroupsOrder")(encoder4)
        )
      )

    /** Look up maker projects the viewer is a maintainer(either created or
      * maintained by) of.
      */
    def makerProjects[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None
    )(innerSelection: SelectionBuilder[MakerProjectConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]]
    ): SelectionBuilder[Viewer, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "makerProjects",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("last", last, "Int")(encoder3)
        )
      )

    /** User who is the viewer of the API.
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Viewer, A] =
      _root_.caliban.client.SelectionBuilder.Field("user", Obj(innerSelection))
  }

  type Vote
  object Vote {

    /** Identifies the date and time when Vote was created.
      */
    def createdAt: SelectionBuilder[Vote, DateTime] =
      _root_.caliban.client.SelectionBuilder.Field("createdAt", Scalar())

    /** ID of the Vote.
      */
    def id: SelectionBuilder[Vote, String] =
      _root_.caliban.client.SelectionBuilder.Field("id", Scalar())

    /** User who created the Vote.
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Vote, A] =
      _root_.caliban.client.SelectionBuilder.Field("user", Obj(innerSelection))

    /** ID of User who created the Vote.
      */
    def userId: SelectionBuilder[Vote, String] =
      _root_.caliban.client.SelectionBuilder.Field("userId", Scalar())
  }

  type VoteConnection
  object VoteConnection {

    /** A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[VoteEdge, A]
    ): SelectionBuilder[VoteConnection, List[A]] =
      _root_.caliban.client.SelectionBuilder
        .Field("edges", ListOf(Obj(innerSelection)))

    /** Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[VoteConnection, A] =
      _root_.caliban.client.SelectionBuilder
        .Field("pageInfo", Obj(innerSelection))

    /** Total number of objects returned from this query
      */
    def totalCount: SelectionBuilder[VoteConnection, Int] =
      _root_.caliban.client.SelectionBuilder.Field("totalCount", Scalar())
  }

  type VoteEdge
  object VoteEdge {

    /** A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[VoteEdge, String] =
      _root_.caliban.client.SelectionBuilder.Field("cursor", Scalar())

    /** The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Vote, A]
    ): SelectionBuilder[VoteEdge, A] =
      _root_.caliban.client.SelectionBuilder.Field("node", Obj(innerSelection))
  }

  final case class GoalCheerInput(
      clientMutationId: scala.Option[String] = None,
      goalId: String
  )
  object GoalCheerInput {
    implicit val encoder: ArgEncoder[GoalCheerInput] =
      new ArgEncoder[GoalCheerInput] {
        override def encode(value: GoalCheerInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "goalId" -> implicitly[ArgEncoder[String]].encode(value.goalId)
            )
          )
      }
  }
  final case class GoalCheerUndoInput(
      clientMutationId: scala.Option[String] = None,
      goalId: String
  )
  object GoalCheerUndoInput {
    implicit val encoder: ArgEncoder[GoalCheerUndoInput] =
      new ArgEncoder[GoalCheerUndoInput] {
        override def encode(value: GoalCheerUndoInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "goalId" -> implicitly[ArgEncoder[String]].encode(value.goalId)
            )
          )
      }
  }
  final case class GoalCreateInput(
      clientMutationId: scala.Option[String] = None,
      dueAt: scala.Option[DateTime] = None,
      groupId: scala.Option[String] = None,
      projectId: scala.Option[String] = None,
      title: String
  )
  object GoalCreateInput {
    implicit val encoder: ArgEncoder[GoalCreateInput] =
      new ArgEncoder[GoalCreateInput] {
        override def encode(value: GoalCreateInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "dueAt" -> value.dueAt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTime]].encode(value)
              ),
              "groupId" -> value.groupId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "projectId" -> value.projectId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "title" -> implicitly[ArgEncoder[String]].encode(value.title)
            )
          )
      }
  }
  final case class GoalMarkAsCompleteInput(
      clientMutationId: scala.Option[String] = None,
      goalId: String
  )
  object GoalMarkAsCompleteInput {
    implicit val encoder: ArgEncoder[GoalMarkAsCompleteInput] =
      new ArgEncoder[GoalMarkAsCompleteInput] {
        override def encode(value: GoalMarkAsCompleteInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "goalId" -> implicitly[ArgEncoder[String]].encode(value.goalId)
            )
          )
      }
  }
  final case class GoalMarkAsIncompleteInput(
      clientMutationId: scala.Option[String] = None,
      goalId: String
  )
  object GoalMarkAsIncompleteInput {
    implicit val encoder: ArgEncoder[GoalMarkAsIncompleteInput] =
      new ArgEncoder[GoalMarkAsIncompleteInput] {
        override def encode(value: GoalMarkAsIncompleteInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "goalId" -> implicitly[ArgEncoder[String]].encode(value.goalId)
            )
          )
      }
  }
  final case class GoalUpdateInput(
      clientMutationId: scala.Option[String] = None,
      dueAt: scala.Option[DateTime] = None,
      goalId: String,
      groupId: scala.Option[String] = None,
      projectId: scala.Option[String] = None,
      title: scala.Option[String] = None
  )
  object GoalUpdateInput {
    implicit val encoder: ArgEncoder[GoalUpdateInput] =
      new ArgEncoder[GoalUpdateInput] {
        override def encode(value: GoalUpdateInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "dueAt" -> value.dueAt.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[DateTime]].encode(value)
              ),
              "goalId" -> implicitly[ArgEncoder[String]].encode(value.goalId),
              "groupId" -> value.groupId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "projectId" -> value.projectId.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "title" -> value.title.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class UserFollowInput(
      clientMutationId: scala.Option[String] = None,
      userId: String
  )
  object UserFollowInput {
    implicit val encoder: ArgEncoder[UserFollowInput] =
      new ArgEncoder[UserFollowInput] {
        override def encode(value: UserFollowInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "userId" -> implicitly[ArgEncoder[String]].encode(value.userId)
            )
          )
      }
  }
  final case class UserFollowUndoInput(
      clientMutationId: scala.Option[String] = None,
      userId: String
  )
  object UserFollowUndoInput {
    implicit val encoder: ArgEncoder[UserFollowUndoInput] =
      new ArgEncoder[UserFollowUndoInput] {
        override def encode(value: UserFollowUndoInput): __Value =
          __ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                __NullValue: __Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "userId" -> implicitly[ArgEncoder[String]].encode(value.userId)
            )
          )
      }
  }
  type Query = _root_.caliban.client.Operations.RootQuery
  object Query {

    /** Look up a Collection(only published).
      */
    def collection[A](
        id: scala.Option[String] = None,
        slug: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[Collection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "collection",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("id", id, "ID")(encoder0),
        Argument("slug", slug, "String")(encoder1)
      )
    )

    /** Look up Collections by various parameters.
      */
    def collections[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        featured: scala.Option[Boolean] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[CollectionsOrder] = None,
        postId: scala.Option[String] = None,
        userId: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[CollectionConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Boolean]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[CollectionsOrder]],
        encoder6: ArgEncoder[scala.Option[String]],
        encoder7: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "collections",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("featured", featured, "Boolean")(encoder2),
          Argument("first", first, "Int")(encoder3),
          Argument("last", last, "Int")(encoder4),
          Argument("order", order, "CollectionsOrder")(encoder5),
          Argument("postId", postId, "ID")(encoder6),
          Argument("userId", userId, "ID")(encoder7)
        )
      )

    /** Look up a Comment.
      */
    def comment[A](id: String)(
        innerSelection: SelectionBuilder[Comment, A]
    )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "comment",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "ID!")(encoder0))
    )

    /** Look up a Goal.
      */
    def goal[A](id: String)(
        innerSelection: SelectionBuilder[Goal, A]
    )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "goal",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "ID!")(encoder0))
    )

    /** Look up Goals by various parameters.
      */
    def goals[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        completed: scala.Option[Boolean] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        makerGroupId: scala.Option[String] = None,
        makerProjectId: scala.Option[String] = None,
        order: scala.Option[GoalsOrder] = None,
        userId: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[GoalConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Boolean]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[String]],
        encoder6: ArgEncoder[scala.Option[String]],
        encoder7: ArgEncoder[scala.Option[GoalsOrder]],
        encoder8: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goals",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("completed", completed, "Boolean")(encoder2),
          Argument("first", first, "Int")(encoder3),
          Argument("last", last, "Int")(encoder4),
          Argument("makerGroupId", makerGroupId, "ID")(encoder5),
          Argument("makerProjectId", makerProjectId, "ID")(encoder6),
          Argument("order", order, "GoalsOrder")(encoder7),
          Argument("userId", userId, "ID")(encoder8)
        )
      )

    /** Look up a MakerGroup.
      */
    def makerGroup[A](id: String)(
        innerSelection: SelectionBuilder[MakerGroup, A]
    )(implicit encoder0: ArgEncoder[String]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "makerGroup",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("id", id, "ID!")(encoder0))
    )

    /** Look up MakerGroups by various parameters.
      */
    def makerGroups[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[MakerGroupsOrder] = None,
        userId: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[MakerGroupConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[MakerGroupsOrder]],
        encoder5: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "makerGroups",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("last", last, "Int")(encoder3),
          Argument("order", order, "MakerGroupsOrder")(encoder4),
          Argument("userId", userId, "ID")(encoder5)
        )
      )

    /** Look up a Post.
      */
    def post[A](
        id: scala.Option[String] = None,
        slug: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[Post, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "post",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("id", id, "ID")(encoder0),
        Argument("slug", slug, "String")(encoder1)
      )
    )

    /** Look up Posts by various parameters.
      */
    def posts[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        featured: scala.Option[Boolean] = None,
        first: scala.Option[Int] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[PostsOrder] = None,
        postedAfter: scala.Option[DateTime] = None,
        postedBefore: scala.Option[DateTime] = None,
        topic: scala.Option[String] = None,
        twitterUrl: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[PostConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Boolean]],
        encoder3: ArgEncoder[scala.Option[Int]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[PostsOrder]],
        encoder6: ArgEncoder[scala.Option[DateTime]],
        encoder7: ArgEncoder[scala.Option[DateTime]],
        encoder8: ArgEncoder[scala.Option[String]],
        encoder9: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "posts",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("featured", featured, "Boolean")(encoder2),
          Argument("first", first, "Int")(encoder3),
          Argument("last", last, "Int")(encoder4),
          Argument("order", order, "PostsOrder")(encoder5),
          Argument("postedAfter", postedAfter, "DateTime")(encoder6),
          Argument("postedBefore", postedBefore, "DateTime")(encoder7),
          Argument("topic", topic, "String")(encoder8),
          Argument("twitterUrl", twitterUrl, "String")(encoder9)
        )
      )

    /** Look up a Topic.
      */
    def topic[A](
        id: scala.Option[String] = None,
        slug: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[Topic, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "topic",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("id", id, "ID")(encoder0),
        Argument("slug", slug, "String")(encoder1)
      )
    )

    /** Look up Topics by various parameters.
      */
    def topics[A](
        after: scala.Option[String] = None,
        before: scala.Option[String] = None,
        first: scala.Option[Int] = None,
        followedByUserId: scala.Option[String] = None,
        last: scala.Option[Int] = None,
        order: scala.Option[TopicsOrder] = None,
        query: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[TopicConnection, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]],
        encoder2: ArgEncoder[scala.Option[Int]],
        encoder3: ArgEncoder[scala.Option[String]],
        encoder4: ArgEncoder[scala.Option[Int]],
        encoder5: ArgEncoder[scala.Option[TopicsOrder]],
        encoder6: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "topics",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after, "String")(encoder0),
          Argument("before", before, "String")(encoder1),
          Argument("first", first, "Int")(encoder2),
          Argument("followedByUserId", followedByUserId, "ID")(encoder3),
          Argument("last", last, "Int")(encoder4),
          Argument("order", order, "TopicsOrder")(encoder5),
          Argument("query", query, "String")(encoder6)
        )
      )

    /** Look up a User.
      */
    def user[A](
        id: scala.Option[String] = None,
        username: scala.Option[String] = None
    )(innerSelection: SelectionBuilder[User, A])(implicit
        encoder0: ArgEncoder[scala.Option[String]],
        encoder1: ArgEncoder[scala.Option[String]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "user",
      OptionOf(Obj(innerSelection)),
      arguments = List(
        Argument("id", id, "ID")(encoder0),
        Argument("username", username, "String")(encoder1)
      )
    )

    /** Top level scope for currently authenticated user. Includes `goals`,
      * `makerGroups`, `makerProjects` & `user` fields.
      */
    def viewer[A](
        innerSelection: SelectionBuilder[Viewer, A]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder
      .Field("viewer", OptionOf(Obj(innerSelection)))
  }

  type Mutation = _root_.caliban.client.Operations.RootMutation
  object Mutation {

    /** Cheer a Goal as Viewer. Returns the cheered Goal
      */
    def goalCheer[A](
        input: GoalCheerInput
    )(innerSelection: SelectionBuilder[GoalCheerPayload, A])(implicit
        encoder0: ArgEncoder[GoalCheerInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goalCheer",
        Obj(innerSelection),
        arguments = List(Argument("input", input, "GoalCheerInput!")(encoder0))
      )

    /** Cheer a Goal as Viewer. Returns the cheered Goal
      */
    def goalCheerUndo[A](
        input: GoalCheerUndoInput
    )(innerSelection: SelectionBuilder[GoalCheerUndoPayload, A])(implicit
        encoder0: ArgEncoder[GoalCheerUndoInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goalCheerUndo",
        Obj(innerSelection),
        arguments =
          List(Argument("input", input, "GoalCheerUndoInput!")(encoder0))
      )

    /** Create a Goal for Viewer. Returns the created Goal.
      */
    def goalCreate[A](
        input: GoalCreateInput
    )(innerSelection: SelectionBuilder[GoalCreatePayload, A])(implicit
        encoder0: ArgEncoder[GoalCreateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goalCreate",
        Obj(innerSelection),
        arguments = List(Argument("input", input, "GoalCreateInput!")(encoder0))
      )

    /** Marks a Goal as complete. Returns the updated Goal
      */
    def goalMarkAsComplete[A](
        input: GoalMarkAsCompleteInput
    )(innerSelection: SelectionBuilder[GoalMarkAsCompletePayload, A])(implicit
        encoder0: ArgEncoder[GoalMarkAsCompleteInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goalMarkAsComplete",
        Obj(innerSelection),
        arguments =
          List(Argument("input", input, "GoalMarkAsCompleteInput!")(encoder0))
      )

    /** Marks a Goal as incomplete. Returns the updated Goal.
      */
    def goalMarkAsIncomplete[A](
        input: GoalMarkAsIncompleteInput
    )(innerSelection: SelectionBuilder[GoalMarkAsIncompletePayload, A])(implicit
        encoder0: ArgEncoder[GoalMarkAsIncompleteInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goalMarkAsIncomplete",
        Obj(innerSelection),
        arguments =
          List(Argument("input", input, "GoalMarkAsIncompleteInput!")(encoder0))
      )

    /** Update a Goal's `due_at`, `title`, `project` or `group` fields. Returns
      * the updated Goal.
      */
    def goalUpdate[A](
        input: GoalUpdateInput
    )(innerSelection: SelectionBuilder[GoalUpdatePayload, A])(implicit
        encoder0: ArgEncoder[GoalUpdateInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "goalUpdate",
        Obj(innerSelection),
        arguments = List(Argument("input", input, "GoalUpdateInput!")(encoder0))
      )

    /** Follow a User as Viewer. Returns the followed User.
      */
    def userFollow[A](
        input: UserFollowInput
    )(innerSelection: SelectionBuilder[UserFollowPayload, A])(implicit
        encoder0: ArgEncoder[UserFollowInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "userFollow",
        Obj(innerSelection),
        arguments = List(Argument("input", input, "UserFollowInput!")(encoder0))
      )

    /** Stop following a User as Viewer. Returns the un-followed User.
      */
    def userFollowUndo[A](
        input: UserFollowUndoInput
    )(innerSelection: SelectionBuilder[UserFollowUndoPayload, A])(implicit
        encoder0: ArgEncoder[UserFollowUndoInput]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "userFollowUndo",
        Obj(innerSelection),
        arguments =
          List(Argument("input", input, "UserFollowUndoInput!")(encoder0))
      )
  }

}
