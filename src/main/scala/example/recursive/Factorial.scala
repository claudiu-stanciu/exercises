package example.recursive

import scala.annotation.tailrec

object Factorial {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  @tailrec
  def factorialTail(n: Int, f: Int = 1): Int = {
    if (n <= 1) f
    else factorialTail(n - 1, n * f)
  }
}
