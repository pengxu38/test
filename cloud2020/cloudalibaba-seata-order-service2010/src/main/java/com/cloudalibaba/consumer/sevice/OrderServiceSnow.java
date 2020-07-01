package com.cloudalibaba.consumer.sevice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceSnow {
	
	@Autowired
	private IdGeneratorSnowflake IdGenerator;
	
	public String getIdBySnowFlake() {
		ExecutorService threadpool = Executors.newFixedThreadPool(5);
		for(int i=0;i<20;i++) {
			threadpool.submit(()->{
				System.out.println(IdGenerator.snowflakeId());
			});
		}
		return "hello snowfakeId";
	}
}
