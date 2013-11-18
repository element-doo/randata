package net.randata

object Test {

  def main(args: Array[String]): Unit = {
    val d = new Randata() with People
    (1 to 100) foreach { e => println(d.nextPhone) }
  }

}
