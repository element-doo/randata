lazy val root = Project("randata", file("."))

organization := "net.randata"
name := "randata"
version := "0.1.0"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.1"
, "org.joda" % "joda-convert" % "1.2"
)

crossScalaVersions := Seq("2.11.7", "2.10.6")
scalaVersion := crossScalaVersions.value.head

scalacOptions ++= Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-feature"
, "-language:_"
, "-unchecked"
, "-Xlint"
, "-Yclosure-elim"
, "-Ydead-code"
, "-Ywarn-adapted-args"
, "-Ywarn-dead-code"
, "-Ywarn-inaccessible"
, "-Ywarn-nullary-override"
, "-Ywarn-nullary-unit"
, "-Ywarn-numeric-widen"
)

publishTo := Some("Element Releases"  at "http://repo.element.hr/nexus/content/repositories/releases/")
credentials ++= {
  val creds = Path.userHome / ".config" / "randata" / "nexus.config"
  if (creds.exists) Some(Credentials(creds)) else None
}.toSeq
