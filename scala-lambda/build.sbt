ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "scala-lambda",
    javacOptions ++= Seq("-source", "11", "-target", "11"),
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-lambda-java-core" % "1.2.3",
      "com.amazonaws" % "aws-lambda-java-events" % "3.13.0",
      "dev.zio" %% "zio" % "2.1.6",
      "com.github.ghostdogpr" %% "caliban-client" % "2.8.1",
      "org.scalameta" %% "munit" % "1.0.0" % Test,
    ),
  ).enablePlugins(CalibanPlugin)