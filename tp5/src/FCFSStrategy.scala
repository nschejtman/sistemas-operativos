case class FCFSStrategy extends SchedulingStrategy{
  var processes : List[Process] = Nil

  override def next: Process = processes.head

  override def removeProcess(process: Process): Unit = ???

  override def removeProcess(pid: Int): Unit = ???

  override def addProcess(process: Process): Unit = processes = process :: processes

  override def running: Process = ???
}
