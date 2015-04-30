package voatest

sealed trait Item {
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