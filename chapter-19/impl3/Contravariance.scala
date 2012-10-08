/*
Odersky uses this example to define the purpose of contravariance

for instance in this case if a function accepting a paramenter of
o: OutputChannel[String] is defined and the body of tha that method
calls o.write("abc"). Then supplying a value of OutputChannel[AnyRef] 
is valid. This is because "abc" is a subtype of AnyRef.

The reverse of this would not hold true. If the type was covariant:
trait OutputChannel[+T]{
  def write(x: T)
}

one could define a method as follows:

def output(o:OutputChannel[Object]){
  o.write("abc")  
}

o:OutputChannel[Integer] = ...

output(o)

In this case o is a valid subtype of the OutputChannel Type definition
but it allows for a case where "abc" which is a subtype of object to 
be written to OutputChannel[Integer] which is a valid subtype of 
OutputChannel[Object]

The compiler would balk at this definition because the position of write
is negative(contravariant)

Interesting side note the defintion of function types make use of contravariance

trait Function1[-S, +T]{
  apply(x: s): T
}

This defines a one parameter function that takes a contravariant type arg
and returns a covariant result.

*/

trait OutputChannel[-T]{
  def write(x: T)
}
