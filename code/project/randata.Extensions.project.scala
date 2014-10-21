package randata

import sbt._
import Keys._

object Extensions extends Build with Default with Dependencies {
  lazy val other = (
    scalaProject("Extensions-Other")
    inject(
      Core.core
    )
  )

  lazy val people = (
    scalaProject("Extensions-People")
    inject(
      Core.core
    )
  )

  lazy val places = (
    scalaProject("Extensions-Places")
    inject(
      Core.core
    )
  )
}
