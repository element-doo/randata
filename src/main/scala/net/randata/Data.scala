package net.randata

import scalax.io._

object Data {
  private def load(name: String): IndexedSeq[String] = {
    val in = Resource.fromClasspath(s"$name.txt")
    in.lines().toIndexedSeq
  }

  val AccountDescriptions = load("account-descriptions")
  val Animals             = load("animals")
  val Cities              = load("cities")
  val Colors              = load("colors")
  val CompanyNames        = load("company-names")
  val CompanyPrefixes     = load("company-prefixes")
  val CompanySuffixes     = load("company-suffixes")
  val Countries           = load("countries")
  val Currencies          = load("currencies")
  val EmailDomains        = load("email-domains")
  val NamesFemale         = load("names-female")
  val NamesLast           = load("names-last")
  val NamesMale           = load("names-male")
  val Other               = load("other")
  val StreetNames         = load("street-names")
  val StreetSuffxes       = load("street-suffixes")
}
