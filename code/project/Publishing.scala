package randata

import sbt._
import Keys._

trait Repositories {
  val ElementNexus            = "Element Nexus"             at "http://maven.element.hr/nexus/content/groups/public/"
  val ElementPrivateReleases  = "Element Private Releases"  at "http://maven.element.hr/nexus/content/repositories/releases-private/"
  val ElementPrivateSnapshots = "Element Private Snapshots" at "http://maven.element.hr/nexus/content/repositories/snapshots-private/"
}

//  ---------------------------------------------------------------------------

trait Resolvers extends Repositories {
  val resolverSettings = Seq(
    resolvers := Seq(
      ElementNexus
    , ElementPrivateReleases
    , ElementPrivateSnapshots
    ),
    externalResolvers <<= resolvers map { r =>
      Resolver.withDefaultResolvers(r, mavenCentral = false)
    }
  )
}

//  ---------------------------------------------------------------------------

trait Publishing extends Repositories {
  val publishingSettings = Seq(
    publishTo <<= (version) { version => Some(
        if (version endsWith "SNAPSHOT") ElementPrivateSnapshots else ElementPrivateReleases
      )}
  , credentials += Credentials(configPath / "nexus.config")
  , publishArtifact in (Compile, packageDoc) := false
  )
}
