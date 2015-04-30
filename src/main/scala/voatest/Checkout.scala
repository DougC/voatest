package voatest

trait Item {
  // price in pence
  def price: Int
}

object Item {
  def unapply(s: String): Option[Item] = {
    s.toLowerCase match {
      case "apple" => Some(Apple)
      case "orange" => Some(Orange)
      case _ => None
    }
  }
}

case object Apple extends Item {
  override def price: Int = 60
}

case object Orange extends Item {
  override def price: Int = 25
}

object Checkout {
  def total(items: Seq[Item]): Int = items.map(_.price).sum

  def main(args: Array[String]) {
    parseItems(args) match {
      case Some(items) => println(formatResult(total(items)))
      case None => println("Did not recognise one or more items")
    }
  }

  def formatResult(i: Int) = {
    val t: Double = i / 100.0
    f"£$t%2.2f"
  }

  // Note: items are reversed in order
  def parseItems(ss: Seq[String]): Option[List[Item]] = {
    ss.foldLeft(Option(List[Item]())) { case (lo, s) =>
      (lo, s) match {
        case (Some(l), Item(i)) => Some(i +: l)
        case _ => None
      }
    }
  }
}