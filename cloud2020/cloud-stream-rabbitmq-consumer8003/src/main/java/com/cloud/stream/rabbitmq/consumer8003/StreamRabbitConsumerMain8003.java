package com.cloud.stream.rabbitmq.consumer8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamRabbitConsumerMain8003 {
	public static void main(String[] args) {
		SpringApplication.run(StreamRabbitConsumerMain8003.class, args);
	}
}