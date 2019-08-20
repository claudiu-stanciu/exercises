package example.recursive

import scala.annotation.tailrec
import scala.collection.mutable._

object Stacks {

  def reverseT(s: Stack[Int]): Stack[Int] = {
    @tailrec
    def reverseH(s: Stack[Int], r: Stack[Int]): Stack[Int] = {
      if (s.isEmpty) r
      else {
        r.push(s.pop)
        reverseH(s, r)
      }
    }

    reverseH(s, Stack[Int]())
  }


}
