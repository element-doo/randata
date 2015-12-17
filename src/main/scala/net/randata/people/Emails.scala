package net.randata
package people

trait Emails { self: Randata =>
  def nextDomain = nextElement(Data.EmailDomains)

  def nextEmail(firstName: String, lastName: String) = {
    val f = firstName.toLowerCase
    val l = lastName.toLowerCase
    val name =
      nextInt(1, 5) match {
        case 1 => f(0) + l     // flast
        case 2 => f + l(0)     // firstl
        case 3 => f + "." + l  // first.last
        case 4 => l + "." + f  // last.fist
      }
    s"$name@$nextDomain"
  }

  def nextEmail(nick: String): String = s"$nick@$nextDomain"
}
