package com.atguigu.springcloud.disaboard9001;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class OrderHystrixDisboardMain9001 {
		public static void main(String[] args) {
			SpringApplication.run(OrderHystrixDisboardMain9001.class, args);
		}
}
