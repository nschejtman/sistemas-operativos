case class Process(var priority : Int, arrivalTime : Long, pid : Int, var resources : List[Resource]){

  var runningTime = 0
  var readyTime = 0
  var blockedTime = 0
  var resIdx = 0

  def run() = {
    for(resource : Resource <- resources){
      System.require(resource.name(), resource.time())
    }
  }



}
