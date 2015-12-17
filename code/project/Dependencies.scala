package randata

import sbt._
import Keys._

trait Dependencies  {
  val scalax = "com.github.scala-incubator.io"   %% "scala-io-file" % "0.4.3"    // For scala 2.10
  //val scalax = "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1"  // For scala 2.11
  val scalaTime = "com.github.nscala-time"       %% "nscala-time"   % "2.2.0"
}
