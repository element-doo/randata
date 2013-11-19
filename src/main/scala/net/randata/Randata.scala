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
  def nextBigDecimal(min: Long, max: Long) = new java.math.BigDecimal(nextDouble(min, max))
  def nextBoolean = r.nextBoolean

  class Generator(fl: Set[() => Char]) extends Function0[Char] {
    def this(f: => Char) = this(Set(f _))
    override def apply = nextElement(fl).apply()
    def repeat(count: Int) = (1 to count).map(e => apply()).mkString
    def |(other: Generator) = new Generator(fl + other)
  }

  val nextDigit   = new Generator(nextInt(48, 58).toChar)
  val nextLLetter = new Generator(nextInt(97, 123).toChar)
  def nextULetter = new Generator(nextInt(65, 91).toChar)

  def nextElement[T](list: Iterable[T]) = {
    val index = nextInt(0, list.size)
    list.toSeq(index)
  }

  def nextDate(from: DateTime, to: DateTime) {
    val fromEpoch = from.getMillis
    val toEpoch   = to.getMillis
    val targetEpoch = nextLong(fromEpoch, toEpoch)

    new DateTime(targetEpoch)
  }




}
