/*
  Pattern Matching appears in more places that just match expressions

  Variable Definitions:

  val myTuple = (123, "abc")
  val (number, string) = myTuple


  Deconstructing Case Classes

  You can deconstruct a case class

  val exp =  new BinOp("*", Number(5), Number(1))
  val BinOp(op, left, right) = exp
  
  this assigns op, left, and right to the pieces of BinOp


  A Sequence of Case Classes can be used anywhere a function literal can

  A sequence of Case classes is a function except instead of having
  one entry point and list of parameters it has several
   
  this is commonly used in Actors code when a pattern match
  is passed directly to the react method


  A sequence of case classes generates a partial function
  if you apply the value on a function it does not suppport
  it will generate a runtime exceptions

  val second: List[Int] => Int = {
    case x :: y :: _ => y
  }

  this throws  a warning that the match is non-exhaustive

  if you pass a three element list it works
  if you pass an empty list it fails with a MatchError

  the Type List[Int] => Int includes all functions from
  List[Int] to Int whether they are partial or not

  val second: PartialFunction[List[Int],Int] ={
    case x :: y :: _ => y
  }

  this allows you to call isDefinedAt

  You should always attempt to work with complete functions because 
  there is a chance of runtime exceptions that the compiler cannot 
  assist with

*/


val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

println(withDefault(Some(1)))
println(withDefault(None))
