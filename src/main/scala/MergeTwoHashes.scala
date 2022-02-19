object MergeTwoHashes extends App {
  def merge(m1: Map[String, Int], m2: Map[Int, Boolean]): Map[String, Boolean] = {
    if(m2.isEmpty) return Map.empty[String, Boolean]

    m1.foldLeft(Map.empty[String, Boolean]) {
      case (m3, (k, v)) =>
        if(m2.contains(v)) m3 + (k -> m2(v)) else m3 }
  }

  println(merge(Map("a" -> 1, "b" -> 2, "c" -> 3), Map(1 -> false, 2 -> true)))
  println(merge(Map(), Map(1 -> false, 2 -> true)))
  println(merge(Map("a" -> 1, "b" -> 2, "c" -> 3), Map()))
}
