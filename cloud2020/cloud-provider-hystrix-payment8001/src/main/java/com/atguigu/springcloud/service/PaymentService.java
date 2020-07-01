package com.atguigu.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import cn.hutool.core.util.IdUtil;

@Service
public class PaymentService {

	public String paymentInfo_ok(Integer id) {
		return "线程池："+ Thread.currentThread().getName() +  " paymentInfo_od,id:" + id;
	}
	

	@HystrixCommand(fallbackMethod="paymentInfo_TimeOutHander",commandProperties= {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
	})
	public String paymentInfo_TimeOut(Integer id) {
		int num = 3;
		try {
			TimeUnit.SECONDS.sleep(num);
//			 System.out.println(10/0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池："+ Thread.currentThread().getName() +  " paymentInfo_TimeOut,id:" + id;
	}
	
	public String paymentInfo_TimeOutHander(Integer id) {
		return "线程池1："+ Thread.currentThread().getName() +  "系统繁忙请稍后再试	 paymentInfo_TimeOutHander,id:" + id;
	}
	
	@HystrixCommand(fallbackMethod="paymentCircuitBreaker_fallback",commandProperties= {
			@HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数10 失败达到60次跳闸
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"),//失败率达到多少跳闸
	})
	 public String paymentCircuitBreaker(@PathVariable("id") Integer  id) {
		 if(id<0) {
			 throw new RuntimeException("******id***不能为负数");
		 }
		 String serialNumber = IdUtil.simpleUUID();
		return Thread.currentThread().getName()+"\t"+"调用成功，流水号：" + serialNumber;
	 }
	
	 
	 public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
		 return "id 不能负数，请稍后再试，id:" + id;
	 }
}
