import java.io.{PrintWriter,File}
object MyAssert{

  def main(args: Array[String]){
    var assertionsEnabled = true

    myAssert(() => 5>3)
    
    myAssertTwo(5>3)

    myAssertThree(5<3)

    def myAssert(predicate:() => Boolean) = 
      if (assertionsEnabled && !predicate())
        throw new AssertionError

    def myAssertTwo(predicate: => Boolean) = 
      if (assertionsEnabled && !predicate)
        throw new AssertionError

    def myAssertThree(predicate: Boolean) = 
      if (assertionsEnabled && !predicate)
        throw new AssertionError

    false
  }
     
}

/*
  Note the difference between myAssert and myAssertTwo. The latter uses named parameters so
  we don't need to provide the awkward syntax for the predicate arguement


  The major difference between myAssertTwo and myAssertThree is that in the latter the expression is 
  evaluated before it is passed as an arg rather than being passed as a function value

  You can and will see side effects in the latter even if insertions are disabled for instance
  if your expression was x/0==0 would through an ArthmeticException even with disabled assertions

/
