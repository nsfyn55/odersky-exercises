class Animal
trait HasLegs

class Frog extends Animal with  Philosophical {
  override def toString = "green"
  override def philosophize(){
    println("it aint easy bein " + toString)
  }

}
