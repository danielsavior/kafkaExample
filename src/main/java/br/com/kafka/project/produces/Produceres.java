package br.com.kafka.project.produces;

import java.util.Properties;
import java.util.Scanner;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.Producer;

public class Produceres {
	 private static Scanner in;
	  public static void main(String[] argv)throws Exception {
	      String topicName = "shurubiba";
	      in = new Scanner(System.in);
	      System.out.println("Enter message(type exit to quit)");

	      //Configure the Producer
	      Properties configProperties = new Properties();
	      configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
	      configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
	      configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

	      Producer<String, String> producer = new KafkaProducer<String, String>(configProperties);
	      String line = in.nextLine();
	      while(!line.equals("exit")) {
	          ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
	          producer.send(rec);
	          line = in.nextLine();
	      }
	      in.close();
	      producer.close();
	  }
}
