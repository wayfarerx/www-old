import Dependencies._

lazy val common = Seq(
  organization := "net.wayfarerx",
  scalaVersion := "2.12.1",
  version := "0.1.0-SNAPSHOT"
)

lazy val site = (project in file("site")).
  settings(
    common,
    name := "www-site",
    libraryDependencies += scalaTest % Test
  )
