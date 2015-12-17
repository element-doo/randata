package net.randata

import other._
import scala.util.Random

class RndOther(seed: Long) extends Randata(seed)
    with Animals
    with Business
    with Financial
    with Other {
  def this() = this(Random.nextLong)
}
