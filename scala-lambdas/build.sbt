ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "scala-lambdas",
    idePackagePrefix := Some("asana.test"),
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-lambda-java-core" % "1.2.3",
      "com.amazonaws" % "aws-lambda-java-events" % "3.13.0",
      "com.softwaremill.sttp.client3" %% "zio" % "3.9.7",
      "dev.zio" %% "zio-http" % "3.0.0-RC9",
      "com.github.ghostdogpr" %% "caliban-client" % "2.8.1",
    ),
  ).enablePlugins(CalibanPlugin)
