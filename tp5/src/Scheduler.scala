case class Scheduler(schedulingStrategy: SchedulingStrategy) {
  def addProcess(process: Process) = schedulingStrategy.addProcess(process)
  def next = schedulingStrategy.next
  def running = schedulingStrategy.running
  def removeProcess(process: Process) = schedulingStrategy.removeProcess(process)
  def removeProcess(pid : Int) = schedulingStrategy.removeProcess(pid)
}
