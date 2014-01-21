package net.randata
package other

trait Descriptions extends Other { self: Randata =>
  def nextDescription = nextElement(Data.Descriptions)
}
