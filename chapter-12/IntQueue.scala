abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x:Int) { buf += x}
}
/*
  put is dynamically bound which means the call to super is unknown.
  it cannot be used until something lets a concrete implementation
  to put.

  the use of abstract override means that this trait must
  be mixed in to a class that has a concrete definition 
  of the method in question
*/
trait Doubling extends IntQueue{
  abstract override def put(x: Int) { super.put(2*x) }
}

trait Incrementing extends IntQueue{
  abstract override def put(x:Int) { super.put(x + 1)}
}

trait Filtering extends IntQueue{
  abstract override def put(x:Int) { 
    if(x >= 0) super.put(x)
  }
}
/*
  Multiple Inheritance:
    With MI the called by a super call is statically determined where the call appears

    With traits, the methd called is determined by a linearization of the classes and traits
    that have been mixed in.

    val q = new BasicIntQueue with Incrementing with Doubling
    q.put(42) // which put is called?

    //First
    First gets called but not second

    //Last
    Same problem in reverse

    How does linearization work?

    class Animal
    trait Furry extends  Animal
    trait HasLegs extends Animal
    trait FourLegged extends HasLegs
    class Cat extends Animal with Furry with FourLegged
*/
