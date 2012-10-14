class PreferredPrompt(val preference: String) 
class PreferredDrink(val drink: String) {
  override def toString = drink
}

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink){
    println("Welcome, " + name + ". The system is ready and there is a delicious " + drink + " waiting")    
    println(prompt.preference)
  }
}
