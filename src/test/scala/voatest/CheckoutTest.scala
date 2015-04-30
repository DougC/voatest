package voatest

import org.scalatest.{Matchers, FlatSpec}

class CheckoutTest extends FlatSpec with Matchers {
  "Checkout" should "total [ Apple, Apple, Orange, Apple ] to £1.45" in {
    Checkout.total(Seq(Apple, Apple, Orange, Apple)) shouldBe 145
  }

  it should "total [ Apple, Apple, Orange, Apple, Orange, Orange ] to £1.70" in {
    Checkout.total(Seq(Apple, Apple, Orange, Apple, Orange, Orange)) shouldBe 170
  }

  it should "successfully parse the sequence of strings [ Apple, Apple, Orange, Apple ]" in {
    val ss = Array("Apple", "Apple", "Orange", "Apple")

    Checkout.parseItems(ss) shouldBe Some(List(Apple, Orange, Apple, Apple))
  }

  it should "format 60 pence as £0.60" in {
    Checkout.formatResult(60) shouldBe "£0.60"
  }

  it should "format 205 pence as £2.05" in {
    Checkout.formatResult(205) shouldBe "£2.05"
  }

  it should "format 1234567890 pence as £12345678.90" in {
    Checkout.formatResult(1234567890) shouldBe "£12345678.90"
  }

  "twoForOne" should "convert 2 to 1" in {
    Checkout.twoForOne(2) shouldBe 1
  }

  it should "leave 1 as 1" in {
    Checkout.twoForOne(1) shouldBe 1
  }

  it should "convert 3 to 2" in {
    Checkout.twoForOne(3) shouldBe 2
  }

  "threeForTwo" should "convert 3 to 2" in {
    Checkout.threeForTwo(3) shouldBe 2
  }

  it should "convert 4 to 3" in {
    Checkout.threeForTwo(4) shouldBe 3
  }

  it should "convert 5 to 4" in {
    Checkout.threeForTwo(5) shouldBe 4
  }

  it should "convert 6 to 4" in {
    Checkout.threeForTwo(6) shouldBe 4
  }

  it should "leave 1 as 1" in {
    Checkout.threeForTwo(1) shouldBe 1
  }
}
