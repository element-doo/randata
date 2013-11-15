package net.randata

import scala.util.Random

class Randata(seed: Long) {
  def this() = this(Random.nextLong)
  val r = new Random(seed)

  // [min, max>
  def getInt(min: Int, max: Int) =
    r.nextInt(max-min) + min

  def getBoolean =
    r.nextBoolean

  def getElement[T](list: Seq[T]) = {
    val index = getInt(0, list.size)
    list(index)
  }

  def getAnimal = getElement(Data.AnimalList)
  def getColor  = getElement(Data.ColorList)
  def getNoun   = getElement(Data.NountList)

  def getColoredAnimal = getColor + " " + getAnimal

  def getCompany = {
    def getPrefix   = getElement(Data.Company.PrefixList)
    def getBusiness = getElement(Data.Company.BusinessList)
    def getSuffix   = getElement(Data.Company.SuffixList)

    getBoolean match {
      case true  => getPrefix + getBusiness
      case false => getBusiness + getSuffix
    }
  }

  def getFirstName = getElement(Data.Name.FirstList)
  def getLastName  = getElement(Data.Name.LastList)
  def getFullName = getFirstName + " " + getLastName
}
