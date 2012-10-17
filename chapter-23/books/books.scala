case class Book(title: String, authors: String *)
object Example extends App { 
  def books: List[Book] = 
    List(
      Book(
        "Structure and Intrepretation of Computer Programs",
        "Abelson, Harlod", "Sussman, Gerald"
      ),
      Book( 
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ),
      Book(
        "The Java Language Specification", "Gosling, James", 
        "Joy, Bill", "Steel, Guy", "Bracha, Gilad"
      )
    ) 
}
