object HOF extends App {

//  def sayHello(callback: () => Unit) {
//    callback()
//  }
//
//  def helloAll(): Unit = { println("Hello, All") }
//
//  sayHello(helloAll)

//  def runAFunction(f: Int => Unit): Unit = {
//    f(42)
//  }
//
//  def printIntPlus1(n: Int): Unit = { println(n + 1) }
//
//  runAFunction(printIntPlus1)

//  def executeNTimes(f: () => Unit, n: Int): Unit = {
//    for(_ <- 1 to n) f()
//  }
//
//  def helloAndres() : Unit = {
//    println("Hello churro")
//  }
//
//  executeNTimes(helloAndres, 2)

//  def executeAndPrint(f: (Int, Int) => Int, x: Int, y: Int): Unit ={
//    val result = f(x, y)
//    println(result)
//  }
//
  def sum(x: Int, y: Int): Int = x + y
  def multiply(x: Int, y: Int): Int = x * y
//
//  executeAndPrint(sum, 2, 3)

  def twoFunctionsCall(
                        f1: (Int, Int) => Int,
                        f2: (Int, Int) => Int,
                        x: Int,
                        y: Int): Tuple2[Int, Int] = {
    val res1 = f1(x, y)
    val res2 = f2(x, y)
    (res1, res2)
  }

//  val res = twoFunctionsCall(sum, multiply, 4, 5)
//  println(res)



}
