import ChecksumAccumulator.calculate

object Spring extends Application{
    for(season <- List("fall", "winter", "spring"))
        println("Season - "+ season + ": " + calculate(season))
}
