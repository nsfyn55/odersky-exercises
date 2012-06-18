/*
The Option Type

  can either be Some(x) or None
  A Map returns other Some(value) or None

  the most common way to take optional values
  apart is through a pattern match

  

*/

val capitals = Map("France" -> "Paris")

println(capitals get "France")
println(show(capitals get "France"))
println(show(capitals get "USA"))

def show(x: Option[String]) = x match{
  case Some(x) => x
  case None => "?"
}
