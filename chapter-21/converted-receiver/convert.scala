/*
  Converting the reciever has several benefits
  it allows smoother integration of classes into
  existing class hierarchies.

  Second it is what allows us to create domain specific
  languages.


  The example below converts the reciever of the Integer
  type so that it will seamlessly integrate with our 
  Rational type


*/
object Example extends App {
  implicit def intToRational(i: Int) = new Rational(i,1)
  val r = new Rational(1,2)
  println(1+r)
}

/*
  Converting receiver can also be used to simulate new 
  syntax.

  map uses the syntax below
  Map(1->"one", 2->"two")

  This uses an implict def from int to ArrowAssoc that 
  makes the -> method available.

  This pattern is known as Rich Wrappers.

*/
object Example2 extends App {
  val m = Map(1->"one", 2->"two")

}

class Rational(val n: Int, val d: Int){
  def + (that: Rational): Rational = 
    new Rational(
      n * that.d + that.n * d,
      d * that.d
    )

  def + (i: Int): Rational = 
    new Rational(
      n+i * d, d
    )

  override def toString = n +"/"+d
    
}
