# flink-kafka-write

Attention: The code is based on Flink 0.9.1. 
From version 0.9.0 to 0.9.1, Flink has deleted several classes as well as changed some classes name.
(see link here for more details: Classes deleted or changed for Flink 0.9.1: https://github.com/apache/flink/commit/940a7c8a667875b8512b63e4a32453b1a2a58785)
If you use for example Flink 0.8.2 to run this program, it will not work.
For version older than 0.9.0 (include 0.9.0), use KafkaSource instead of FlinkKafkaConsumer
For the latest version like 0.10, maybe you need to change "KafkaSink" to "FlinkKafkaProducer". 
More information can be found here: Flink streaming with Kafka -- Java doc documentation https://ci.apache.org/projects/flink/flink-docs-master/api/java/org/apache/flink/streaming/connectors/kafka/package-summary.html. 

For some unknown reasons, my sbt cannot add flink 0.9.1 dependencies by itself. 
In that case, download all dependencies needed and put them into "YOURWORKSPACE/PROJECTNAME/lib" and delete the corresponding lines in build.sbt.

Good luck!
