package net.randata

trait Other { self: Randata =>
  def nextColor = nextElement(Data.Colors)
  def nextOther = nextElement(Data.Other)
}
