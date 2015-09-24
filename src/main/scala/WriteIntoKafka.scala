import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.KafkaSink
import org.apache.flink.streaming.util.serialization.SerializationSchema
/**
 * @author Tianshu YANG
 */
object WriteIntoKafka {
  def main(args: Array[String]) {
    val env =StreamExecutionEnvironment.getExecutionEnvironment
    //Get the Execution Environment
    val stream = env.fromElements[String]("Happy")
    //Create a new stream from elements input
    stream.addSink(new KafkaSink[String]("localhost:9092","test", new MySerializationSchema))
    //Add a KafkaSink to the data stream, remind that only stream with sink added will be executed once .execute is called
    println("Hi TestKafka")
    env.execute //Execute the data stream
    println("Success!")
  }
}
class MySerializationSchema extends SerializationSchema[String,Array[Byte]]{
  //Class to define the serialization schema.
  override def serialize(string: String) : Array[Byte] = string.getBytes
  //Define the serialization rule
}
