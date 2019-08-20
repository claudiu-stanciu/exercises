package example.recursive

import org.scalatest.{FlatSpec, Matchers}

class StacksSpec extends FlatSpec with Matchers {
  it should "reverse a stack" in {
    val s = collection.mutable.Stack[Int](1, 2, 3, 4)
    val expected = collection.mutable.Stack[Int](4, 3, 2, 1)
    Stacks.reverseT(s) shouldBe expected
  }

}
