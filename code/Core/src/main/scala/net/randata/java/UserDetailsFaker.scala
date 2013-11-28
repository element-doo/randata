package net.randata
package java

import scala.util.Random

class UserDetailsFaker(seed: Long) extends Randata(seed) with People {
  def this() = this(Random.nextLong)
}
