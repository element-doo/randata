package net.randata

import scala.util.Random
import org.joda.time.DateTime

class Randata(seed: Long) {
  def this() = this(Random.nextLong)
  val r = new Random(seed)

  // [min, max>
  def nextInt(min: Int, max: Int) = r.nextInt(max-min) + min
  def nextLong(min: Long, max: Long) = math.abs(r.nextLong) % (max - min) + min
  def nextDouble(min: Long, max: Long) =  r.nextDouble * (max-min) + min
  def nextBigDecimal(min: Long, max: Long) = new _root_.java.math.BigDecimal(nextDouble(min, max))
  def nextBoolean = r.nextBoolean

  def nextElement[T](list: Iterable[T]) = {
    val index = nextInt(0, list.size)
    list.toSeq(index)
  }

  def nextDate(from: DateTime, to: DateTime) = {
    val fromEpoch = from.getMillis
    val toEpoch   = to.getMillis
    val targetEpoch = nextLong(fromEpoch, toEpoch)

    new DateTime(targetEpoch)
  }
}
