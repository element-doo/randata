package net.randata

trait Animals extends Colors { self: Randata =>
  def nextAnimal = nextElement(Data.AnimalList)
  def nextColoredAnimal = nextColor + " " + nextAnimal
}
