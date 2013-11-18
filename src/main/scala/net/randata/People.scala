package net.randata

trait People extends Names with Email { self: Randata =>
  def nextAddress = {
    val street = nextElement(Data.StreetNames)
    val suffix = nextElement(Data.StreetSuffxes)
    val number = nextInt(1, 500)
    s"$street $suffix $number"
  }

  def nextPhone = {
    val firstGroup  = (1 to 3).map(e => nextDigit).mkString
    val secondGroup = (1 to 4).map(e => nextDigit).mkString
    s"555 $firstGroup-$secondGroup"
  }
}
