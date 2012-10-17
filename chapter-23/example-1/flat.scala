/*
  The compiler turns all for expressions into
  the higher order functions map, flatMap, and withFilter
*/
case class Person(name: String,
                  isMale: Boolean,
                  children: Person*)

object Example extends App{

  val lara = Person("Lara", false)
  val bob = Person("Bob", true)
  val julie = Person("Julie", false, lara, bob)
  val persons = List(lara, bob, julie)

  println(
    persons withFilter (!_.isMale) 
  )

  println(
    persons filter (p => !p.isMale) flatMap (p => 
      (p.children map (c => (p.name, c.name)))
    )
  )

  println( for (p <- persons; if(!p.isMale); c <- p.children) 
    yield(p.name, c.name))
}

object Example2 extends App{

  val lara = Person("Lara", false)
  val bob = Person("Bob", true)
  val julie = Person("Julie", false, lara, bob)
  val persons = List(lara, bob, julie)
  // below p is a pattern
  //            (generator)  (definition)   (filter)
  println(for (p <- persons; n = p.name; if(n startsWith "L")) yield n)
}
