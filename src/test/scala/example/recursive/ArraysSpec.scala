package example.recursive

import org.scalatest.{FlatSpec, Matchers}

class ArraysSpec extends FlatSpec with Matchers {

  it should "find the min" in {
    val a = List(2, 5, 2, 3, 1)
    Arrays.min(a) shouldBe 1
  }

  it should "find missing number 3" in {
    val a = List(0, 1, 2, 4, 5)
    Arrays.missingNo(a) shouldBe 3
  }
  it should "find missing number 6" in {
    val a = List(0, 1, 2, 3, 4, 5)
    Arrays.missingNo(a) shouldBe 6
  }

  it should "find index of number k in array" in {
    val a = List(0, 2, 1, 3, 6, 5)
    Arrays.binSearch(a, 2) shouldBe 2
    Arrays.binSearch(a, 7) shouldBe -1
  }

  it should "find max sub array" in {
    val a = List(2, -4, 1, 9, -6, 7, -3)
    Arrays.maxSubArr(a) shouldBe 11
  }
}
