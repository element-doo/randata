package net.randata
package other

trait Business { self: Randata =>
  def nextCompany = {
    def nextPrefix   = nextElement(Data.CompanyPrefixes)
    def nextBusiness = nextElement(Data.CompanyNames)
    def nextSuffix   = nextElement(Data.CompanySuffixes)

    nextBoolean match {
      case true  => nextPrefix + nextBusiness
      case false => nextBusiness + nextSuffix
    }
  }
}
