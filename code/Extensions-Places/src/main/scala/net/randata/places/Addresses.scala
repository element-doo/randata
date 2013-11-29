package net.randata
package places

trait Addresses { self: Randata =>
  def nextStreet = {
    val street = nextElement(Data.StreetNames)
    val suffix = nextElement(Data.StreetSuffxes)
    s"$street $suffix"
  }

  def nextZip = nextDigit.repeat(5)
}
