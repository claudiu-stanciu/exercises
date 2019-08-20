package example.recursive

import scala.annotation.tailrec

object Arrays {

  def min[T](a: List[T])(implicit ev: T => Ordered[T]): T = {
    @tailrec
    def minH[T](a: List[T], min: T)(implicit ev: T => Ordered[T]): T = {
      if (a.isEmpty) min
      else {
        val minmin = if (min > a.head) a.head else min
        minH(a.tail, minmin)
      }
    }

    minH(a.tail, a.head)
  }

  def missingNo(a: List[Int]): Int = {
    def missH(x: List[Int], left: Int = 0, right: Int = a.length - 1): Int = {
      if (left > right) left
      else {
        val mid = left + (right - left) / 2
        if (x(mid) == mid) missH(x, mid + 1, right)
        else missH(x, left, mid - 1)
      }
    }

    missH(a)
  }

  /**
   * return index of item k if found, else -1
   *
   * @param a
   * @param k
   * @return
   */
  def binSearch(a: List[Int], k: Int): Int = {
    val as = a.sorted
    var left = 0
    var right = as.length - 1
    var mid = 0
    while (left <= right) {
      mid = Math.floor((left + right) / 2).toInt
      if (as(mid) < k)
        left = mid + 1
      else if (as(mid) > k)
        right = mid - 1
      else return mid
    }
    return -1
  }

  /**
   * find max sum of subarrays
   *
   * @param a
   * @return
   */
  def maxSubArr(a: List[Int]): Int = {
    def maxSubH(a: List[Int], left: Int = 0, right: Int = a.length - 1): Int = {
      if (left == right) left
      else {
        val mid = (left + right) / 2
        var tmp = 0
        var sLeft = 0
        for (i <- mid to left by -1) {
          tmp += a(i)
          if (tmp > sLeft)
            sLeft = tmp
        }
        tmp = 0
        var sRight = 0
        for (i <- (mid + 1) until right) {
          tmp += a(i)
          if (tmp > sRight)
            sRight = tmp
        }

        val maxLR = Math.max(maxSubH(a, left, mid), maxSubH(a, mid + 1, right))

        Math.max(maxLR, sLeft + sRight)

      }
    }

    maxSubH(a)
  }
}
