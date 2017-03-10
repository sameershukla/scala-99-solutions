package solutions

import scala.annotation.tailrec

class Solutions99 {

  //Ex 01
  def last[A](list: List[A]): A = list.last

  //Ex 02
  def penultimate[A](list: List[A]): A = list.init.last

  //Ex 03
  def findKth[A](n: Int, list: List[A]): Option[A] = n match {
    case x if (x > list.length || x < 0) => None
    case _                               => val splitted = list.splitAt(n); Some(splitted._2.head)
  }

  //Ex 05
  def reverse[A](list: List[A]): List[A] = list.foldLeft(List[A]())((x, y) => y :: x)

  //Ex 06
  def palindrome[A](list: List[A]): Boolean = if (list == list.reverse) true else false

  //Ex 07
  def flatten[A](list: List[Any]): List[Any] = {
    //FlatMap is also a PartialFunction so it is equivalent to collect in this case :) and then you can flatten 
    val l = list collect {
      case x: List[_] => flatten(x)
      case y          => List(y)
    }
    l.flatten
  }

  //Ex 08
  def compress[A](list: List[A]): List[A] = {
    val l = list.foldLeft(List[A]())((x, y) => if (x.isEmpty || x.head != y) y :: x else x).reverse
    println(l)
    l
  }

  //Ex 09, Time complexity O(N), tried to optimize it by making a tail-recursive call, but no quick solution ready as of now.
  def pack[A](ls: List[A]): List[List[A]] = {
    @tailrec
    def helper(ls: List[A], nl: List[A], mixList: List[List[A]]): List[List[A]] = ls match {
      case x if (x.isEmpty)                           => mixList
      case x if (x.tail.isEmpty)                      => mixList :+ (x.head :: nl)
      case y if (!y.isEmpty && y.head == y.tail.head) => helper(ls.tail, y.head :: nl, mixList)
      case y if (!y.isEmpty && y.head != y.tail.head) => helper(ls.tail, Nil, mixList :+ (y.head :: nl))
    }
    helper(ls, Nil, Nil)
  }

  //Ex 10 * 13
  def encode[A](list: List[A]): List[(Int, A)] = pack(list).map(x => (x.length, x.head))

  //Ex11
  def encodeModified[A](list: List[A]): List[Any] = pack(list).map(x => x match {
    case x if (x.length == 1) => x.head
    case y if (x.length > 1)  => (x.length, x.head)
  })

  //Ex 12
  //TODO: Generified it and implement a trait MyNumeric and then apply
  def decode(ls: List[(Int, String)]): List[String] = {
    ls.map(x => x._2.toString * x._1).mkString.split("").toList
  }

  //Ex 14
  def duplicate[A](list: List[A]) = list.flatMap(x => List(x, x))

  //Ex 15
  def duplicateN(n: Int, list: List[String]) = list.map { x => x * n }.mkString.split("").toList

  //Ex 16
  def drop[A](n: Int, list: List[A]): List[A] = {
    val splittedList = list.splitAt(n)
    splittedList._1.init ++ splittedList._2
  }

  //Ex 17
  def split[A](n: Int, list: List[A]): (List[A], List[A]) = {
    list.splitAt(n)
  }

  //Ex 18
  def slice[A](from: Int, to: Int, list: List[A]): List[A] = {
    list.splitAt(from)._2.splitAt(to - from)._1
  }

  //Ex 19
  def rotateN[A](n: Int, list: List[A]): List[A] = {
    n match {
      case x if (x > 0) => {
        val splittedList = list.splitAt(n)
        splittedList._2 ++ splittedList._1
      }
      case x if (x < 0) => {
        val splittedList = list.splitAt(list.length - Math.abs(n))
        splittedList._2 ++ splittedList._1
      }
    }
  }

  //Ex 20.
  def removeAt[A](n: Int, list: List[A]): (List[A], A) = {
    val splittedList = list.splitAt(n)
    (splittedList._1 ++ splittedList._2.tail, splittedList._2.head)
  }

  //Ex 21
  def insertAt[A](ob: A, n: Int, list: List[A]): List[A] = {
    val splittedList = list.splitAt(n)
    splittedList._1 ++ List(ob) ++ splittedList._2
  }

  //Ex 22
  def range(from: Int, to: Int): List[Int] = List.range(from, to + 1)

}

