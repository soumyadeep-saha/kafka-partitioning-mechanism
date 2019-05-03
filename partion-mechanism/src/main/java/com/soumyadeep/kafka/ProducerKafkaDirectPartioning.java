package com.soumyadeep.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerKafkaDirectPartioning {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(properties);

		try {

			for (int i = 40; i < 60; i++) {
				myProducer.send(
						new ProducerRecord<String, String>("partition-mechanism-1", 0, "message1","Message Value : " + Integer.toString(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myProducer.close();
		}
	}
}
