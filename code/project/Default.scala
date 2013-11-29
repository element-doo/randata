package randata

import sbt._
import Keys._

trait Default extends Resolvers with Publishing {
  import com.typesafe.sbteclipse.plugin.EclipsePlugin.{ settings => eclipseSettings, _ }
  import net.virtualvoid.sbt.graph.Plugin._

  lazy val scalaSettings =
    Defaults.defaultSettings ++
    eclipseSettings ++
    graphSettings ++ 
    publishingSettings ++ Seq(
      javacOptions := Seq(
        "-deprecation"
      , "-encoding", "UTF-8"
      , "-Xlint:unchecked"
      , "-source", "1.6"
      , "-target", "1.6"
      )

    , crossScalaVersions := Seq("2.10.3")
    , scalaVersion := crossScalaVersions.value.head
    , scalacOptions := Seq(
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

    , unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil
    , unmanagedSourceDirectories in Test := (scalaSource in Test).value :: Nil
    
    , publishArtifact in (Compile, packageDoc) := false

    , EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
    , EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)
    )

  protected def scalaProject(id: String) = Project(
    id
  , file(id)
  , settings = scalaSettings ++ Seq(
      version := libraryVersion
    , name := "Randata-" + id
    , organization := "net.randata"
    )
  )

//  ---------------------------------------------------------------------------

  implicit def pimpMyProjectHost(project: Project) =
    new PimpedProjectHost(project)

  case class PimpedProjectHost(project: Project) {
    def inject(children: ProjectReferencePlus*): Project = {
      children.toList match {
        case Nil =>
          project

        case head :: tail =>
          PimpedProjectHost(head attachTo project).inject(tail: _*)
      }
    }
  }

  sealed trait ProjectReferencePlus {
    def attachTo(attachment: Project): Project
  }

  implicit def pimpMyProject(attachment: Project): ProjectReferencePlus =
    new PimpedProject(attachment)

  case class PimpedProject(attachment: Project) extends ProjectReferencePlus {
    def attachTo(original: Project) = original dependsOn attachment
  }

  implicit def pimpMyProjectRef(attachment: ProjectRef): ProjectReferencePlus =
    new PimpedProjectRef(attachment)

  case class PimpedProjectRef(attachment: ProjectRef) extends ProjectReferencePlus {
    def attachTo(original: Project) = original dependsOn attachment
  }

  implicit def pimpMyModuleID(attachment: ModuleID): ProjectReferencePlus =
    new PimpedModuleID(attachment)

  case class PimpedModuleID(attachment: ModuleID) extends ProjectReferencePlus {
    def attachTo(original: Project) = original settings(
      libraryDependencies += attachment
    )
  }

  implicit def pimpMyModuleIDSeq(attachments: Seq[ModuleID]): ProjectReferencePlus =
    new PimpedModuleIDSeq(attachments)

  case class PimpedModuleIDSeq(attachments: Seq[ModuleID]) extends ProjectReferencePlus {
    def attachTo(original: Project) = original settings(
      libraryDependencies ++= attachments
    )
  }
}
