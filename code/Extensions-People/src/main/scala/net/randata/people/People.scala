package net.randata
package people

import strings.Strings

trait People extends Names with Email with Strings { self: Randata =>
  def nextCountry = nextElement(Data.Countries)

  def nextStreet = {
    val street = nextElement(Data.StreetNames)
    val suffix = nextElement(Data.StreetSuffxes)
    s"$street $suffix"
  }

  def nextZip = nextDigit.repeat(5)

  def nextCity = nextElement(Data.Cities)

  def nextPhone = {
    val firstGroup  = (1 to 3).map(e => nextDigit).mkString
    val secondGroup = (1 to 4).map(e => nextDigit).mkString
    s"555 $firstGroup-$secondGroup"
  }
}
