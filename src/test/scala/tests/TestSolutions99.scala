package tests

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import solutions.Solutions99

class TestSolutions99 extends FunSuite with BeforeAndAfter {

  val solutions = new Solutions99

  test("testLast") {
    assert(solutions.last(List(1, 2, 3)) === 3)
    assert(solutions.last(List("C", "B", "A")) === "A")
    assert(solutions.last(List('a', 'b', 'c')) === 'c')

  }

  test("testPenultimate") {
    assert(solutions.penultimate(List(1, 2, 3)) === 2)
    assert(solutions.penultimate(List("C", "B", "A")) === "B")
    assert(solutions.penultimate(List('a', 'b', 'c')) === 'b')
  }

  test("testFindkth") {
    assert(solutions.findKth(2, List(1, 1, 2, 3, 5, 8)) === Some(2))
    assert(solutions.findKth(4, List("C", "B", "A", "D", "E")) === Some("E"))
    assert(solutions.findKth(1, List('a', 'b', 'c')) === Some('b'))
    assert(solutions.findKth(10, List('a', 'b', 'c')) === None)
  }

  test("testReverse") {
    assert(solutions.reverse(List(1, 1, 2, 3, 5, 8)) === List(8, 5, 3, 2, 1, 1))
    assert(solutions.reverse(List("C", "B", "A", "D", "E")) === List("E", "D", "A", "B", "C"))
    assert(solutions.reverse(List('a', 'b', 'c')) === List('c', 'b', 'a'))
  }

  test("testPalindrome") {
    assert(solutions.palindrome(List(1, 2, 3, 2, 1)) === true)
    assert(solutions.palindrome(List("C", "B", "A", "D", "E")) === false)
    assert(solutions.palindrome(List('a', 'b', 'b', 'a')) === true)
  }

  test("testFlatten") {
    assert(solutions.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8))
    assert(solutions.flatten(List(List(1, 2), 3)) === List(1, 2, 3))
    assert(solutions.flatten(List(2, List(3, List(5, 8)))) === List(2, 3, 5, 8))
  }

  test("testCompress") {
    assert(solutions.compress(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) === List('a', 'b', 'c', 'a', 'd', 'e'))
    assert(solutions.compress(List(1, 1, 2, 3, 3, 4, 5, 5)) === List(1, 2, 3, 4, 5))
  }

  test("testPack") {
    assert(solutions.pack(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")) === List(List("a", "a", "a", "a"), List("b"), List("c", "c"), List("a", "a"), List("d"), List("e", "e", "e", "e")))
  }

  test("testEncode") {
    assert(solutions.encode(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")) === List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e")))
  }

  test("testEncodeModified") {
    assert(solutions.encodeModified(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")) === List((4, "a"), "b", (2, "c"), (2, "a"), "d", (4, "e")))
  }

  test("testDecode") {
    assert(solutions.decode(List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e"))) === List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
  }

  test("testDuplicate") {
    assert(solutions.duplicate(List("a", "b", "c", "d")) === List("a", "a", "b", "b", "c", "c", "d", "d"))
  }

  test("testDuplicateN") {
    assert(solutions.duplicateN(3, List("a", "b", "c", "d")) === List("a", "a", "a", "b", "b", "b", "c", "c", "c", "d", "d", "d"))
  }

  test("testDropN") {
    assert(solutions.drop(3, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")) === List("a", "b", "d", "e", "f", "g", "h", "i", "j", "k"))
  }

  test("testSplit") {
    assert(solutions.split(3, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")) === (List("a", "b", "c"), List("d", "e", "f", "g", "h", "i", "j", "k")))
  }

  test("testSlice") {
    assert(solutions.slice(3, 7, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")) === List("d", "e", "f", "g"))
  }

  test("testremoveAt") {
    assert(solutions.removeAt(1, List("a", "b", "c", "d")) === (List("a", "c", "d"), "b"))
  }

  test("testInsertAt") {
    assert(solutions.insertAt("new", 1, List("a", "b", "c", "d")) === List("a", "new", "b", "c", "d"))
    assert(solutions.insertAt("new", 2, List("a", "b", "c", "d")) === List("a", "b", "new", "c", "d"))
  }

  test("testRotateN") {
    assert(solutions.rotateN(3, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")) === List("d", "e", "f", "g", "h", "i", "j", "k", "a", "b", "c"))
    assert(solutions.rotateN(-2, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")) === List("j", "k", "a", "b", "c", "d", "e", "f", "g", "h", "i"))
  }

}