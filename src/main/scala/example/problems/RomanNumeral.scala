package example.problems

class RomanNumeral(numeral: String) {

  /**
   * Map single roman numerals to integers
   * @param num
   * @return
   */
  private def romanToInt(num: String): Int = num match {
    case "I" => 1
    case "V" => 5
    case "X" => 10
    case "L" => 50
    case "C" => 100
    case "D" => 500
    case "M" => 1000
    case _ => throw new Exception("Unknown roman numeral")
  }

  /**
   * Resolve substractions and generate a new list
   * @param nums
   * @return
   */
  def groupUp(nums: Array[String]): List[Int] = nums.length match {
    case 0 => Nil
    case 1 => romanToInt(nums.head) :: Nil
    case _ => {
      val curr = romanToInt(nums.head)
      val newNums = nums.tail
      val next = romanToInt(newNums.head)
      if (curr < next) next - curr :: groupUp(newNums.tail)
      else curr :: groupUp(newNums)
    }
  }

  /**
   * Convert roman numeral to integer
   * @return
   */
  def toInt: Int = groupUp(numeral.split("")).sum
}
