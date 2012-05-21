/*
Notes the purpose of this exercise is to demonstrate the difference between
object and class defintions. Both can exist in the same file and are called
companions. Objects are singleton. Objects cannot take parameters. object 
definitions can access private members of companion class definitions.

If there is no companion class an object definition is a standalone object.


*/
import scala.collection.mutable.Map

object ChecksumAccumulator {
    //Create a private immutable mao for caching sums
    private val cache = Map[String,Int]()
 
    //Calculate takes a string
    def calculate(s: String): Int =
        //Check the cache
        if(cache.contains(s))
            cache(s)
        else{
            //instantiate new accumulator
            val acc = new ChecksumAccumulator
            //loop through chars in string and accum bytes
            for(c<-s)
                acc.add(c.toByte)
            //Calculate check sume
            val cs = acc.checksum()
            //Add to cache keyed by original value
            cache += (s->cs)
            //return checksum
            cs
        }
    //def add(b: Byte){ sum+=b }

    //def checksum(): Int=  ~(sum & 0xFF) + 1
}

class ChecksumAccumulator {
    private var sum = 0
    //add the byte to sum
    def add(b: Byte){ sum+=b }

    //flip bits - & against 255
    def checksum(): Int=  ~(sum & 0xFF) + 1
    
}

// vim: set ts=4 sw=4 et:
