package example.recursive

import org.scalatest.{FlatSpec, Matchers}

class FactorialSpec extends FlatSpec with Matchers {

  it should "compute factorial for 3 and return 6" in {
    Factorial.factorial(3) shouldBe 6
  }

  it should "compute tail factorial for 3 and return 6" in {
    Factorial.factorialTail(3) shouldBe 6
  }

}
