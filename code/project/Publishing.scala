package randata

import sbt._
import Keys._

trait Repositories {
  val ElementNexus     = "Element Nexus"             at "http://maven.element.hr/nexus/content/groups/public/"
  val ElementReleases  = "Element Releases"  at "http://repo.element.hr/nexus/content/repositories/releases/"
  val ElementSnapshots = "Element Snapshots" at "http://repo.element.hr/nexus/content/repositories/snapshots/"
}

//  ---------------------------------------------------------------------------

trait Resolvers extends Repositories {
  val resolverSettings = Seq(
    resolvers := Seq(
      ElementNexus
    , ElementReleases
    , ElementSnapshots
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
        if (version endsWith "SNAPSHOT") ElementSnapshots else ElementReleases
      )}
  , credentials += Credentials(configPath / "nexus.config")
  , publishArtifact in (Compile, packageDoc) := false
  )
}
