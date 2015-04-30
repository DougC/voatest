package voatest

object Checkout {
  def total(items: Seq[Item]): Int = {
    val itemCounts = items.groupBy(identity).map { case (k, v) => (k, v.length) }

    val totals = itemCounts.map { case (item, count) =>
      item match {
        case Apple => item.price * twoForOne(count)
        case Orange => item.price * threeForTwo(count)
      }
    }

    totals.sum
  }

  def twoForOne(i: Int): Int = i / 2 + i % 2

  def threeForTwo(i: Int): Int = (i / 3) * 2 + i % 3

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