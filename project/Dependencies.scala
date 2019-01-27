import sbt._

object Dependencies {

  def wayfarerxRepository = Resolver.url("WayfarerX Repository",
    url("https://software.wayfarerx.net/releases/"))(Resolver.ivyStylePatterns)

  lazy val OversiteVersion = "0.6.0"
  lazy val OversiteApi = "net.wayfarerx.oversite" %% "oversite-api" % OversiteVersion
  lazy val OversiteUi = "net.wayfarerx.oversite" %% "oversite-ui" % OversiteVersion
  lazy val OversiteGenerator = "net.wayfarerx.oversite" %% "oversite-generator" % OversiteVersion
  lazy val OversiteServer = "net.wayfarerx.oversite" %% "oversite-server" % OversiteVersion

  lazy val ScalaTest = "org.scalatest" %% "scalatest" % "3.0.1"

}
