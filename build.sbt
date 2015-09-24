name := "flink-kafka-write"
 
version := "1.0"
 
scalaVersion := "2.10.5"

libraryDependencies += "org.apache.flink" % "flink-clients" % "0.9.1"

//libraryDependencies += "org.apache.flink" % "flink-scala" % "0.9.1"

//libraryDependencies += "org.apache.flink" % "flink-streaming-scala" % "0.9.1"

//libraryDependencies += "org.apache.flink" % "flink-connector-kafka" % "0.9.1" exclude("org.apache.kafka", "kafka_${scala.binary.version}")

libraryDependencies += "org.apache.kafka" %% "kafka" % "0.8.2.1"

//libraryDependencies ++= Seq("org.apache.flink" % "flink-clients" % "0.9.1", "org.apache.kafka" % "kafka_2.10" % "0.8.2.1", "org.apache.flink" % "flink-streaming-core" % "0.9.1")

libraryDependencies += "org.apache.flink" % "flink-streaming-core" % "0.9.1"

//libraryDependencies += "log4j" % "log4j" % "1.2.14"

mergeStrategy in assembly <<= (mergeStrategy in assembly) { mergeStrategy => {
    case entry => {
      val strategy = mergeStrategy(entry)
      if (strategy == MergeStrategy.deduplicate) MergeStrategy.first
      else strategy
    }
  }
}
 
fork in run := true
