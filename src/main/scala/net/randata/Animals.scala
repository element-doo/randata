package net.randata

trait Animals extends Other { self: Randata =>
  def nextAnimal = nextElement(Data.Animals)
  def nextColoredAnimal = nextColor + " " + nextAnimal
}
