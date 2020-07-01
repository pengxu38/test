package com.atguigu.springcloud.client3366;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudClientMain3366 {
	public static void main(String[] args) { 
		SpringApplication.run(SpringCloudClientMain3366.class, args);
	}
}
