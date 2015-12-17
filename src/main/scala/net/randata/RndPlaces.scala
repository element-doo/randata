package net.randata

import places._
import scala.util.Random

class RndPlaces(seed: Long) extends Randata(seed)
    with Addresses
    with Regions {
  def this() = this(Random.nextLong)
}
