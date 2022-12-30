name := "spark-sftp"

organization := "com.springml"

scalaVersion := "2.12.17"
val sparkV = "3.3.1"

version := "1.1.5"

// Dependent libraries
libraryDependencies ++=
  Seq(
    "org.apache.spark" %% "spark-core" % sparkV,
    "org.apache.spark" %% "spark-sql" % sparkV,
    "org.apache.spark" %% "spark-avro" % sparkV,
    "com.springml" % "sftp.client" % "1.0.3",
    "com.databricks" %% "spark-xml" % "0.15.0"
  )

// Test dependencies
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.3" % Test
libraryDependencies += "org.apache.avro" % "avro-mapred" % "1.11.1" % Test exclude("org.mortbay.jetty", "servlet-api")
libraryDependencies +=  "org.apache.spark" %% "spark-hive" % sparkV % Test

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>https://github.com/springml/spark-sftp</url>
    <licenses>
      <license>
        <name>Apache License, Verision 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/springml/spark-sftp</connection>
      <developerConnection>scm:git:git@github.com:springml/spark-sftp</developerConnection>
      <url>github.com/springml/spark-sftp</url>
    </scm>
    <developers>
      <developer>
        <id>springml</id>
        <name>Springml</name>
        <url>http://www.springml.com</url>
      </developer>
    </developers>)
