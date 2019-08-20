package example.problems

import org.scalatest.{FlatSpecLike, Matchers}

class RomanNumeralSpec extends FlatSpecLike with Matchers {

  it should "convert roman numerals to integers" in {
    val numerals = List("I", "III", "V", "VII", "IX", "LXXXVIII", "XCVI").map(n => new RomanNumeral(n))
    val expected = List(1, 3, 5, 7, 9, 88, 96)

    numerals.map(_.toInt) shouldBe expected
  }

}
