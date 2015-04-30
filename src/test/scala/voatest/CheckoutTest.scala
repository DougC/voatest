package voatest

import org.scalatest.{Matchers, FlatSpec}

class CheckoutTest extends FlatSpec with Matchers {
  "Checkout" should "total [ Apple, Apple, Orange, Apple ] to £2.05" in {
    Checkout.total(Seq(Apple, Apple, Orange, Apple)) shouldBe 205
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
}
