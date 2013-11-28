package net.randata
package strings

trait Strings { self: Randata =>
  class Generator(val chars: Set[Char]) extends Function0[Char] {
    override def apply = nextElement(chars)
    def repeat(count: Int) = (1 to count).map(e => apply()).mkString
    def |(other: Generator) = new Generator(chars ++ other.chars)
  }

  def RG(from: Int, to: Int) = new RangeGenerator(from, to)
  class RangeGenerator(from: Int, to: Int) extends Generator((from to to).map(_.toChar).toSet)

  def DG(values: Int*) = new DiscreteGenerator(values: _*)
  class DiscreteGenerator(values: Int*) extends Generator(values.map(_.toChar).toSet)

  val nextDigit     = new RangeGenerator(48,  58)
  val nextUppercase = new RangeGenerator(65,  91)
  val nextLowercase = new RangeGenerator(97, 123)
  val nextOtherChar = RG(33, 48) | RG(58, 65) | RG(91, 97) | RG(123, 127)
}
