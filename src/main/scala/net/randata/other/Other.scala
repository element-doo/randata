package net.randata
package other

trait Other { self: Randata =>
  def nextColor = nextElement(Data.Colors)
  def nextOther = nextElement(Data.Other)
}
