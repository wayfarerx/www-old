import Dependencies._

val generateSite = taskKey[Int]("Generates the website.")

val serveSite = taskKey[Int]("Serves the website.")

lazy val common = Seq(
  organization := "net.wayfarerx.www",
  scalaVersion := "2.12.8",
  version := "0.1.0",
  resolvers += wayfarerxRepository,
  libraryDependencies += ScalaTest % Test
)

lazy val root = (project in file(".")).
  settings(
  ).aggregate(api, code, drinks, games, thoughts, site)

lazy val api = (project in file("api")).
  settings(
    common,
    name := "www-api",
    libraryDependencies ++= Seq(
      OversiteApi,
      OversiteUi
    )
  )

lazy val code = (project in file("code")).
  settings(
    common,
    name := "www-code"
  ).dependsOn(api)

lazy val drinks = (project in file("drinks")).
  settings(
    common,
    name := "www-drinks"
  ).dependsOn(api)

lazy val games = (project in file("games")).
  settings(
    common,
    name := "www-games"
  ).dependsOn(api)

lazy val thoughts = (project in file("thoughts")).
  settings(
    common,
    name := "www-thoughts"
  ).dependsOn(api)

lazy val site = (project in file("site")).
  settings(
    common,
    name := "www-site",
    libraryDependencies ++= Seq(
      OversiteGenerator,
      OversiteServer
    ),
    mainClass in (Compile, run) := Some("net.wayfarerx.oversite.generator.Main")
  ).dependsOn(code, drinks, games, thoughts)
