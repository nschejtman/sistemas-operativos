trait Resource{
  def time : Int
}
case class CPU(time : Int) extends Resource
case class IO(time : Int) extends Resource
