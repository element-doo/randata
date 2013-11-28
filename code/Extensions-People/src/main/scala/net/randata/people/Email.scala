package net.randata
package people

trait Email { self: Randata =>
  def nextEmail(firstName: String, lastName: String): String = {
    val f = firstName.toLowerCase
    val l = lastName.toLowerCase
    val name =
      nextInt(1, 5) match {
        case 1 => f(0) + l     // flast
        case 2 => f + l(0)     // firstl
        case 3 => f + "." + l  // first.last
        case 4 => l + "." + f  // last.fist
    }
    val domain = nextElement(Data.EmailDomains)
    s"$name@$domain"
  }
}
