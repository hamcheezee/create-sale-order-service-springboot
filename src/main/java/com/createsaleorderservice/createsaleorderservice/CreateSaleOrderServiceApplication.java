package com.createsaleorderservice.createsaleorderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class CreateSaleOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateSaleOrderServiceApplication.class, args);
	}

	// @Bean
	// CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
	// 	return args -> {
	// 		kafkaTemplate.send("kafkatopic", "This message is sent from Kafka :D ");
	// 	};
	// }

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("statustopic", "This message is sent from Kafka :D ");
		};
	}

}
