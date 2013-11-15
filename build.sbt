organization := "randata.net"

name := "randata"

version := "0.0.0"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := (scalaSource in Test).value :: Nil


// ### DEPENDENCIES ### //

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.0.RC3" % "test"
, "junit" % "junit" % "4.11" % "test"
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
