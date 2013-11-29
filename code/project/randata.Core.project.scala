package randata

import sbt._
import Keys._

object Core extends Build with Default with Dependencies {
  lazy val core = (
    scalaProject("Core")
    inject(
      scalax,
      scalaTime
    )
  )
  
  lazy val java = (
    scalaProject("Java")
    inject(
      Core.core,
      Extensions.other,
      Extensions.people,
      Extensions.places
    )
  )
}
