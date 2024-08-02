ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "scala-lambda",
    javacOptions ++= Seq("-source", "11", "-target", "11"),
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-lambda-java-core" % "1.2.3",
      "com.amazonaws" % "aws-lambda-java-events" % "3.13.0",
      "org.scalameta" %% "munit" % "1.0.0" % Test,
    ),
  )