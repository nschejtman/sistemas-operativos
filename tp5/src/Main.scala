import scala.util.Random

object Main extends App {
  var globalTime : Int = 0
  private val processes: List[Process] = Nil

  for(i <- 1 to 20){
    Process(Random.nextInt(10), Random.nextInt(100), i)
  }






}
