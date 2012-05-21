import ChecksumAccumulator.calculate

object Summer{
    def main(args: Array[String]){
        println("STARTING...")
        for(arg <- args)
            print(arg + " calc arg - " + calculate(arg));
    }
}
