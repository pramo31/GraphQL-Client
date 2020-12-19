name := "github-graphql-scala"

version := "0.1"

scalaVersion := "2.13.2"

lazy val root = (project in file("."))
  .settings(
	libraryDependencies ++= Seq(
	  "org.scalaj" %% "scalaj-http" % "2.4.2",
	  "com.google.code.gson" % "gson" % "2.8.6",
	  "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.0",
	  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.11.0",
	  "org.scala-lang" % "scala-reflect" % "2.13.2",
	  "org.scalatest" %% "scalatest" % "3.1.1" % Test,
	  "com.typesafe" % "config" % "1.3.4",
	  "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
	  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
	  "org.slf4j" % "slf4j-api" % "1.7.5",
	  "org.slf4j" % "slf4j-simple" % "1.7.5"
	)
)
	
// Merge strategy to handle deduplicate errors
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}


mainClass in(Compile, run) := Some("cs474.project.graphql.client.Main")
mainClass in assembly := Some("cs474.project.graphql.client.Main")