trait Philosophical {
  def philosophize() {
    println("I consume memory therefore I am")
  }
}
/*
What makes traits different than interfaces

they can maintain state
they can have concrete implementations

What makes a trait different from a class
  traits cannot have class parameters
  trait NoPoint(x: Int, y:Int) // would not compile

  super calls in classes are statically bound
  super calls in traits are dynamically bound
  this is what allows stackable modifications

  Enriching a thin interface:
    add methods to a class in terms of methods the class
    alredy has

  There is a tradeoff between thin and rich interfaces this
  makes life easier for the caller. A thin interface makes
  life easy on the implementer.

  Java prefers thin interfaces, scala concrete methods
  tips the balance to rich traits. 

  What you end up having is traits with a few abstract
  methods and lots of concrete methods. The concrete
  methods are easily overridable if need be but otherwise
  do not burden the implementor unnecessarily.
*/
