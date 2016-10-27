trait SchedulingStrategy {
  def next : Process
  def running : Process
  def addProcess(process : Process)
  def removeProcess(process : Process)
  def removeProcess(pid : Int)
}

