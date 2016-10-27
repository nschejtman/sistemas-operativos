trait Resource{
  def time() : Int
  def name() : String
}

case class CPU(time : Int, final val name : String = "CPU") extends Resource{
}

case class IO(time : Int, final val name : String = "IO") extends Resource {
}
