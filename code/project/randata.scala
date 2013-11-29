import sbt._
import scala.io.Source

package object randata {
  val libraryVersion = "0.0.2-SNAPSHOT"

  private val log = ConsoleLogger()

  val configPath = Path.userHome / ".config" / ("randata")
  log.info("Config path: " + configPath)
}
