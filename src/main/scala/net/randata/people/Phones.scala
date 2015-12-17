package net.randata
package people

trait Phones { self: Randata =>
  def nextPhone = {
    val firstGroup  = (1 to 3).map(e => nextDigit()).mkString
    val secondGroup = (1 to 4).map(e => nextDigit()).mkString
    s"555 $firstGroup-$secondGroup"
  }
}
