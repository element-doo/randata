package net.randata

import scala.util.Random

class Randata(seed: Long) {
  def this() = this(Random.nextLong)
  val r = new Random(seed)

  // [min, max>
  def nextInt(min: Int, max: Int) =
    r.nextInt(max-min) + min

  def nextBoolean =
    r.nextBoolean

  def nextElement[T](list: Seq[T]) = {
    val index = nextInt(0, list.size)
    list(index)
  }

  def nextAnimal = nextElement(Data.AnimalList)
  def nextColor  = nextElement(Data.ColorList)
  def nextNoun   = nextElement(Data.NountList)

  def nextColoredAnimal = nextColor + " " + nextAnimal

  def nextCompany = {
    def nextPrefix   = nextElement(Data.Company.PrefixList)
    def nextBusiness = nextElement(Data.Company.BusinessList)
    def nextSuffix   = nextElement(Data.Company.SuffixList)

    nextBoolean match {
      case true  => nextPrefix + nextBusiness
      case false => nextBusiness + nextSuffix
    }
  }

  def nextFirstName = nextElement(Data.Name.FirstList)
  def nextLastName  = nextElement(Data.Name.LastList)
  def nextFullName = nextFirstName + " " + nextLastName
}
