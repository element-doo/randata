package net.randata
package places

trait Regions { self: Randata =>
  def nextCountry = nextElement(Data.Countries)
  def nextCity = nextElement(Data.Cities)
}
