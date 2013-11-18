package net.randata

trait People { self: Randata =>
  def nextFirstName = nextElement(Data.Name.FirstList)
  def nextLastName  = nextElement(Data.Name.LastList)
  def nextFullName = nextFirstName + " " + nextLastName
}
