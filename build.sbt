name := "Functional"

version := "0.1"

scalaVersion := "2.13.7"

lazy val root = (project in file(".")).settings(
  name := "catsiohelloworld",
  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "3.2.10",
    // "core" module - IO, IOApp, schedulers
    // This pulls in the kernel and std modules automatically.
    "org.typelevel" %% "cats-effect" % "3.3.5",
    // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
    "org.typelevel" %% "cats-effect-kernel" % "3.3.5",
    // standard "effect" library (Queues, Console, Random etc.)
    "org.typelevel" %% "cats-effect-std" % "3.3.5",
    // better monadic for compiler plugin as suggested by documentation
    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
  )
)