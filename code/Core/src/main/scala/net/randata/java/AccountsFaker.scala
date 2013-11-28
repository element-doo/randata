package net.randata
package java

import scala.util.Random

class AccountsFaker(seed: Long) extends Randata(seed) with Financial {
  def this() = this(Random.nextLong)
}
