import AssemblyKeys._

assemblySettings

test in assembly := {}

val libjoda = "joda-time" % "joda-time" % "2.2"
val libspecs2 = "org.specs2" %% "specs2" % "2.4.2" % "test"
val libbreeze = "org.scalanlp" %% "breeze" % "0.11.2"
val libbreezenative = "org.scalanlp" %% "breeze-natives" % "0.11.2"

lazy val commonSettings = Seq(
	organization := "com.amadeus.ti",
	version := "0.1.0",
	scalaVersion := "2.10.5",
	sbtVersion := "0.13.13"
)

lazy val libSettings = Seq(
	libraryDependencies += libjoda,
	libraryDependencies += libspecs2,
	libraryDependencies += libbreeze,
	libraryDependencies += libbreezenative
)

lazy val root = (project in file(".")).
	settings(commonSettings: _*).
	settings(libSettings: _*).
	settings(
		name := "induction-scala-data-science"
	)

checksums in update := Nil

javacOptions in Compile ++= Seq("-source", "1.6",  "-target", "1.6")

scalacOptions += "-target:jvm-1.6"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

parallelExecution in Test := false

resolvers ++= Seq(
	Resolver.sonatypeRepo("public"),
	Resolver.sonatypeRepo("releases"),
	Resolver.sonatypeRepo("snapshots"),
	"Local repository"   at "http://localhost/artifacts/mavenrepo/",
	"Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
	Resolver.mavenLocal)

publishTo := Some("Local Maven Repo" at "http://localhost/artifacts/mavenrepo/")

testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

packageArchetype.java_application

net.virtualvoid.sbt.graph.Plugin.graphSettings

