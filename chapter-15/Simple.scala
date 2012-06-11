abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operation: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, righ: Expr) extends Expr

object App{
  def simplifyTop(expr: Expr): Expr = expr match{
    case UnOp("-",UnOp("-",e)) => e //Double Negation
    case _ => expr
  }
}

/*
Case Modifier:

The case modifier tells the compiler to add syntactic conveniences
1. A factory method with same name as class
   val v = Var("x")
   this is nest when nesting because you don't need tons of new keywords

2. All args get implicit val prefix so they are maintained as fields
   v.name == "x" //true

3. The compiler adds natural implementations of methdos toString, hashCode, and equals
   this prints, hashes, and compares the whole tree (class and args) recursively
   elements of case classes are always compared structurally
   val op = BinOp(+, Number(1.0), Var("x"))
   op.right == Var("x")//true

4. Compiler adds a copy method. Allows you to make copies with
  different attributes
  op.copy(operator = '-') // only changes the operator attribute


Kinds Of Patterns

Wildcard Patterns

  case _ => matches anything
  case BinOp(_,_,_) matches any BinOp

Constant Patterns

  Any literal, val , or singleton can be used as a constant
  Nil, a singleton, is a good example

Variable Patterns:

 matches any object similiar to wildcard, but scala binds the variable
 to whatever the object is.

 case somethingElse => "not zero" + somethingElse

 variable or constant?

 a variable with a lower case letter is a variable all others
 are constants

 you can use lower case variables as constants two ways
 prefix with qualifier - this.pi
 use back ticks        - `pi`

Constructor Patterns
  
  supports deep matches
  case BinOp("+", e, Number(0))" // checks 3 levels deep

Sequence Patterns

  case List(0, _ ,_) // a 3 element list starting with 0
  cast List(0,_*) // an arbitrarily long list starting with 0
 
Tuple Patterns
  
  case (a, b, c) // arbitrary tuple 3

Typed Patterns
  
  def generalSize(x: Any): = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  It is best practice to use the type matching above instead
  of type checking and casting

  type erasure considerations:
  look at the underscores in the above expression 
  these are there because type information is lost
  at run time. so you couldn't use the following

  case m: Map[Int, Int] => m.size // throws warning will match Map[String, String]

  You can pattern match on the types of strings 
  because these are handled differently

  case a: Array[String] // totally valid will not match Array[Int]
  
  variable binding:
  you can tell the compiler to do a pattern match
  then assign a variable 

  case UnOp("abs", e @ UnOp("abs", _)) => e
  // if this pattern succeeds then the portion after @ is assigned to e 


Pattern Guards:
  you can't do the following 

  case BinOp("+", x, x) => BinOp("*", x , Number(2))
  patterns must be linear, x can only appear once
  on right hand side

  you can achieve this effect using guards
  
  case BinOp("+", x, y) if x == y => BinOp("*", x , Number(2))
  
  there are other uses for guarded patterns
  case n: Int if n > 0 => n //match only positive integers
  
pattern matching does not work like switch statements in the
sense that there is no fall through. If you put less specific
cases 'catch-all's' before more specific ones the less
specific will always be run in favor.

Sealed Classes:
  its important in pattern matching that you cover all possible cases 
  how can we be sure we have if you can add arbitrary cases at anytime?

  Sealed classes can only have subclasses defined in the same file
  and you get compiler support if you haven't added a pattern match
  for a specific case in the form of a warning(Match is not Exhaustive)
  this warning indicates that a MatchError is a possibility.

  If you encounter a situation where you intend a non exhaustive list
  the compiler can be silence by adding an @unchecked annotation
*/
