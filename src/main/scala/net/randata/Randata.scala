package net.randata

import scala.util.Random
import org.joda.time.DateTime

class Randata(seed: Long) extends Strings with Numerics {
  def this() = this(Random.nextLong)
  val r = new Random(seed)

  def nextElement[T](list: Iterable[T]) = {
    val index = nextInt(0, list.size)
    list.toSeq(index)
  }

  def nextDate(from: DateTime, to: DateTime) = {
    val fromEpoch   = from.getMillis
    val toEpoch     = to.getMillis
    val targetEpoch = nextLong(fromEpoch, toEpoch)

    new DateTime(targetEpoch)
  }
}
