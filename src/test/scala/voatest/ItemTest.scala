package voatest

import org.scalatest.{Matchers, FlatSpec}

class ItemTest extends FlatSpec with Matchers {
  "Item" should "convert the string 'apple' to Apple" in {
    Item.unapply("apple") shouldBe Some(Apple)
  }

  it should "convert the string 'Apple' to Apple" in {
    Item.unapply("Apple") shouldBe Some(Apple)
  }

  it should "convert the string 'orange' to Orange" in {
    Item.unapply("orange") shouldBe Some(Orange)
  }

  it should "convert the string 'Orange' to Orange" in {
    Item.unapply("Orange") shouldBe Some(Orange)
  }

}
