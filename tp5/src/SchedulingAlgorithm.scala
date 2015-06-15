trait SchedulingAlgorithm {
  def getNext(readyList : List[Process]) : (Process, Int, List[Process])


}
