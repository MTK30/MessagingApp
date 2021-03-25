name := """MTK-PLAY"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean).disablePlugins(PlayFilters)

scalaVersion := "2.13.1"

val javaVersion = settingKey[String]("The version of Java used for building.")

javaVersion := System.getProperty("java.version")

val java9AndSupLibraryDependencies: Seq[sbt.ModuleID] =
  if (!javaVersion.toString.startsWith("1.8")) {
    Seq(
      "com.sun.activation" % "javax.activation" % "1.2.0",
      "com.sun.xml.bind" % "jaxb-core" % "2.3.0",
      "com.sun.xml.bind" % "jaxb-impl" % "2.3.1",
      "javax.jws" % "javax.jws-api" % "1.1",
      "javax.xml.bind" % "jaxb-api" % "2.3.0",
      "javax.xml.ws" % "jaxws-api" % "2.3.1"
    )
  } else {
    Seq.empty
  }

libraryDependencies ++= Seq(
  guice,
  javaJdbc,
  "mysql" % "mysql-connector-java" % "5.1.48",
  "org.projectlombok" % "lombok" % "1.18.8",
  "org.elasticsearch.client"% "elasticsearch-rest-high-level-client" % "7.6.0"
) ++ java9AndSupLibraryDependencies
