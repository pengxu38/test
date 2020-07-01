package com.cloudalibaba.consumer.controller;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FlowLimitController {
	
	@GetMapping("/testA")
	public String testA() {
		return "------testA";
	}
	
	@GetMapping("/testB")
	public String testB() {
		log.info(Thread.currentThread().getName()+"\t");
		return "------testB";
	} 
	
	@GetMapping("/testD")
	public String testD() {
		try {
			TimeUnit.SECONDS.sleep(1);
			log.info("测试RT：" + Thread.currentThread().getName()+"\t");
		} catch (Exception e) {
			log.error("",e);
		}
		return "------testD";
	} 
	
	@GetMapping("/testE")
	public String testE() {
		log.info("测试异常比例");
		System.out.println(10/0);
		return "------testD1";
	} 
	
	@GetMapping(value="testHotKey")
	@SentinelResource(value="testHotKey",blockHandler="deal_testHotKey")
	public String testHotKey(@RequestParam(value="p1",required=false) String p1,
										@RequestParam(value="p2",required=false) String p2) {
		System.out.println(10/0);
		return "testHotKey";
	}
		
	public String deal_testHotKey( String p1,String p2,BlockException exception) {
		return ".............del_testHotKey";
	}
}
