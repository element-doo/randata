package net.randata

trait Numerics { self: Randata =>
  // [min, max>
  def nextInt(min: Int, max: Int) = r.nextInt(max-min) + min
  def nextLong(min: Long, max: Long) = math.abs(r.nextLong) % (max - min) + min
  def nextDouble(min: Long, max: Long) =  r.nextDouble * (max-min) + min
  def nextBigDecimal(min: Long, max: Long) = new _root_.java.math.BigDecimal(nextDouble(min, max))
  def nextBoolean = r.nextBoolean
}
