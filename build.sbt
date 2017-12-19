name := "scala-practice-1"

version := "0.1"

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

libraryDependencies += "com.softwaremill.sttp" %% "core" % "1.1.2"
