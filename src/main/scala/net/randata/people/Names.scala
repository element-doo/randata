package net.randata
package people

trait Names { self: Randata =>
  def nextMaleFirstName   = nextElement(Data.NamesMale)
  def nextFemaleFirstName = nextElement(Data.NamesFemale)
  def nextFirstName =
    nextBoolean match {
      case true => nextMaleFirstName
      case false => nextFemaleFirstName
    }

  def nextFullName       = s"$nextFirstName $nextLastName"
  def nextMaleFullName   = s"$nextMaleFirstName $nextLastName"
  def nextFemaleFullName = s"$nextFemaleFirstName $nextLastName"

  def nextLastName = nextElement(Data.NamesLast)
}
