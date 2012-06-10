class ArrayElement( 
  val contents:  Array[String]
) extends Element


/*
Notes:

if you leave out extends clause then the compiler assumes you extend scala.AnyRef
which is equivalent to java.lang.Object

  Regarding Extensions
    private members are not inherited
    a member is not inherited if a member of the same name and parameters already exists

    You cannot define a field with the same name as a method.

    java has four namespaces - fields, methods, packages, and types
    scala has two - values(fields, methods, packages, and singleton objects
                  - types(classes and trait names)
      in scala you can override a parameterless method with a val - forbidden in java

Original Implementations:

code smell - conts only job is getting copied:
we can eliminate redundancy by  combining into a parametric field

class ArrayElement(conts: Array[String]) extends Element{
  def contents: Array[String] = conts
}


*/
