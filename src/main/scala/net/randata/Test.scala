package net.randata

object Test {
  def main(args: Array[String]): Unit = {
    new D().dodoro
  }

  class D extends Randata with People {
    def dodoro() {
      println(nextDigit.repeat(10))
    }
  }

}
