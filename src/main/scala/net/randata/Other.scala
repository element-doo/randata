package net.randata

trait Other { self: Randata =>
  def nextNoun   = nextElement(Data.NountList)
}
