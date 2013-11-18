package net.randata

trait Business { self: Randata =>
  def nextCompany = {
    def nextPrefix   = nextElement(Data.Company.PrefixList)
    def nextBusiness = nextElement(Data.Company.BusinessList)
    def nextSuffix   = nextElement(Data.Company.SuffixList)

    nextBoolean match {
      case true  => nextPrefix + nextBusiness
      case false => nextBusiness + nextSuffix
    }
  }
}
