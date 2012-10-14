/*
The first place the compiler will use implicits
is in conversions to Expected type. Any time the 
compiler sees X but needs Y it will look for a
conversion from X->Y

scala> val i: Int = 3.5

The above does not compile because it will lose
precision.

The code below does compile

Note: This code is in poor taste. Its bad to implicitly
convert to a more constrained type. This is because you
lose precision. Its much more sensible to convert to a
broader type.

scala.Predef is imported into every scala program and does
just what is decribed above by converting "smaller" numeric
types into "larger" ones.

because of this you can implicitly store smaller numeric types
in larger ones.

*/
object Example extends App {
  implicit def doubleToInt(x: Double) = x.toInt

  val i: Int = 3.4

  println(i)
}
