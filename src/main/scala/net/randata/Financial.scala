package net.randata

trait Financial { self: Randata =>
  def nextCurrency = nextElement(Data.Currencies)
  
  def nextAccountDescription = nextElement(Data.AccountDescriptions)
  def nextAccountNumber = nextDigit.repeat(7) + "-" + nextDigit.repeat(10)
  def nextAccountIban = nextULetter.repeat(2) + nextDigit.repeat(20)
}
