object ByNameSyntax extends App {

  def timer[A](blockOfCode: => A) = {
    val start = System.nanoTime()
    val result = blockOfCode
    val stop = System.nanoTime()
    val delta = stop - start
    (result, delta/1000000d)
  }

//  val res = timer(println("Andres is using by-name parameters"))
//  println(res._2)

  def readFile(filename: String) = io.Source.fromFile(filename).getLines()

  val (res, time) = timer(readFile("/Users/andres/Documents/write_files"))
  while(res.hasNext){
    println(time + " " + res.next())
  }
}
