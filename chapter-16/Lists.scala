/*
  Lists are similiar to Arrays

  Key Differences:
    Lists are immutable
    Lists have a recursive structure(Linked List) where arrays are flat

  Lists are Homogeneous - every item has the same type
  Lists are covariant:
    For each pair of types S and T, if S is a subtype of T, then List[S] is a subtype of List[T]
    note empty list has a list type of List[Nothing]

    You can assign val xs: List[String] = List() becase Nothing is a subtype of everything

  Constructing Lists:
  lists are built from Nil and infix(::) operator

  x :: xs indicates a list with x at the front
  because :: ends in a colon it associates right and is applied to args on left   x :: xs  


  Operations on lists:
    All list operations on list can be defined in terms of the following three:
      head - returns first element
      tail - returns the remainder of elements that are not head 
      isEmpty returns true if list is empty

      head and tail are defined only for non - empty lists
      Nil.head throws exception


  Lists can be disassembled with pattern matching
  val fruits = List("apple","orange", "banana") 
  val a :: b :: rest = fruits
  
  rest == List("banana")

  First Order Methods(Do not take functions as args) on List:
  
  Concatenation(:::) - Right associative appends right to left
  last - yields the last element
  init - yields all but the last
  because lists are singly linked these run in time proportional to the list size

  Laws related to reversing
    1. reverse is its own inverse
      xs.reverse.reverse == xs
    2. reverse turns init to tail and last to head
  
  Apply
    selects random element takes time proportional to list length

  Flatten
    flattens a list of lists

  Zipping
    Takes two list and returns a list of tuples 

  Unzip
    Splits a list of tuples
  
  toString
    returns a canonical string representation

  mkString
    returns a string with a pre, sep, and post of your choosing 



  Converting Lists/Arrays
  
*/
object App {
  def main(args: Array[String]){
    println("hello")

    val xs = List(1,2)
    val ys = List(3,4)

    val zs = append(xs,ys)
    val ds = rev(append(xs,ys))

    zs.foreach(println)
    ds.foreach(println)

    println("SUM: "  + sum(xs))
    val words = List("The","quick", "brown", "fox")
    println("Result: " + concat(words," "))
    val revwords = reverseLeft(words)

    revwords.foreach(println)
  }
  
  /*
  (1,2)
    1,(2)
      
  */
  def append(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case List() => ys 
    case x :: xs1 => x :: append(xs1,ys)  
  }

  /*
    This function grows quadratically becase it must traverse
    the list once for rev and once against for the ::: operator
  */
  def rev[Int](xs: List[Int]): List[Int] = xs match{
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
  }

  def sum(xs: List[Int]): Int =  (0 /: xs) (_ + _)

  def concat(xs: List[String], sep: String): String =  ("" /: xs) (_ + sep +_)
  
  def reverseLeft[T](xs: List[T]) = (List[T]() /: xs) {(ys, y) => y :: ys}
}

