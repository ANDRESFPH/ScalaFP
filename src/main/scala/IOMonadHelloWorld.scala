import cats.effect.IO
import cats.effect.unsafe.implicits.global

object IOMonadHelloWorld extends App {
  val helloEffect: IO[Unit] = IO { println("hello world") }

//  helloEffect.unsafeRunSync()

  val program: IO[Unit] = for {
    _ <- IO { println("Welcome to Scala, whats your name?") }
    name <- IO { scala.io.StdIn.readLine() }
    nameUC = name.toUpperCase()
    _ <- IO { println(s"Hello: $nameUC") }
  } yield ()

  program.unsafeRunSync()
}
