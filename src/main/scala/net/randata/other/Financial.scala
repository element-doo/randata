package net.randata
package other

trait Financial extends Strings { self: Randata =>
  def nextCurrency = nextElement(Data.Currencies)

  def nextAccountDescription = nextElement(Data.AccountDescriptions)
  def nextAccountNumber = nextDigit.repeat(7) + "-" + nextDigit.repeat(10)
  def nextAccountIban = nextUppercase.repeat(2) + nextDigit.repeat(20)
}
