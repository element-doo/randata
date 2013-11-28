package randata

import sbt._
import Keys._

object Extensions extends Build with Default with Dependencies {
  lazy val other = (
    scalaProject("Extensions-Other")
    inject(
      Core.root,
      Extensions.strings
    )
  )
  
  lazy val people = (
    scalaProject("Extensions-People")
    inject(
      Core.root,
      Extensions.strings
    )
  )
  
  lazy val places = (
    scalaProject("Extensions-Places")
    inject(
      Core.root
    )
  )
  
  lazy val strings = (
    scalaProject("Extensions-Strings")
    inject(
      Core.root
    )
  )
}
