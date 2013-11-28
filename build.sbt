organization := "randata.net"

name := "randata"

version := "0.0.0-SNAPSHOT"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := (scalaSource in Test).value :: Nil


// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.0.RC3" % "test"
, "junit" % "junit" % "4.11" % "test"
, "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.2"
, "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2"
, "com.github.nscala-time" %% "nscala-time" % "0.6.0"
)

// ### COMPILE SETTINGS ### //

crossScalaVersions := Seq("2.10.3")

scalaVersion := crossScalaVersions.value.head

scalacOptions := Seq(
  "-unchecked"
, "-deprecation"
, "-optimise"
, "-encoding", "UTF-8"
, "-Xcheckinit"
, "-Yclosure-elim"
, "-Ydead-code"
, "-Yinline"
, "-Xmax-classfile-name", "72"
, "-Yrepl-sync"
, "-Xlint"
, "-Xverify"
, "-Ywarn-all"
, "-feature"
, "-language:postfixOps"
, "-language:implicitConversions"
, "-language:existentials"
)

javaHome := sys.env.get("JDK16_HOME").map(file(_))

javacOptions := Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-Xlint:unchecked"
, "-source", "1.6"
, "-target", "1.6"
)


// ### ECLIPSE ### //

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

// ### PUBLISHING ### //

credentials += Credentials(Path.userHome / ".config" / "randata" / "nexus.config")
  
publishArtifact in (Compile, packageDoc) := false

publishTo <<= (version) { version => Some(
  if (version endsWith "SNAPSHOT")
    "Element Snapshots" at "http://repo.element.hr/nexus/content/repositories/snapshots/"
  else
    "Element Releases"  at "http://repo.element.hr/nexus/content/repositories/releases/")
}
