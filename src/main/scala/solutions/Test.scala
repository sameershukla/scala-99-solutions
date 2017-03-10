package solutions

import scala.annotation.tailrec

object Test extends App {

  def slice[A](from: Int, to: Int, list:List[A])= {
     println(list.splitAt(from)._2.splitAt(to - from)._1)
  }
  
  slice(3,7,List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))

}