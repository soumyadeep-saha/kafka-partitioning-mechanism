package com.soumyadeep.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerKafkaRoundRobin {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(properties);

		try {

			for (int i = 101; i <= 200; i++) {
				myProducer.send(
						new ProducerRecord<String, String>("partition-mechanism-1", "Message Value : " + Integer.toString(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myProducer.close();
		}
	}
}
