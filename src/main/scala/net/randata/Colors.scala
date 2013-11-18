package net.randata

trait Colors { self: Randata =>
  def nextColor  = nextElement(Data.ColorList)
}
