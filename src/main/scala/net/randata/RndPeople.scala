package net.randata

import people._
import scala.util.Random

class RndPeople(seed: Long) extends Randata(seed)
    with Emails
    with Names
    with Phones {
  def this() = this(Random.nextLong)
}
