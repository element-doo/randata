package net.randata

import scala.util.Random

class Randata(seed: Long) {
  def this() = this(Random.nextLong)
  val r = new Random(seed)

  // [min, max>
  def nextInt(min: Int, max: Int) =
    r.nextInt(max-min) + min

  def nextBoolean =
    r.nextBoolean

  def nextDigit =
    nextInt(48, 58).toChar

  def nextElement[T](list: Seq[T]) = {
    val index = nextInt(0, list.size)
    list(index)
  }




}
