abstract class Fruit {
  val v: String
  def m: String
}

abstract class Apple extends Fruit {
  val v: String 
  val m: String // Ok to override def with val
}

abstract class BadApple extends Fruit {
  var v: String //Illegal val with var 
  val m: String 
}

abstract class AnortherBadApple extends Fruit {
  def v: String //Illegal val with def
  val m: String
}
