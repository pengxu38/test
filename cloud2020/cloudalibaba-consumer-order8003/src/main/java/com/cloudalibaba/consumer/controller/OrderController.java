package com.cloudalibaba.consumer.controller;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

  @Resource
  private RestTemplate restemplate;
  
  @Value("${service-url.nacos-user-service}")
  private String serverUrl;
  
  @GetMapping(value="/consumer/payment/nacos/{id}")
  public String paymentInfo(@PathVariable("id") Long id) {
	  return restemplate.getForObject(serverUrl+"/payment/nacos/"+id, String.class);
  }
	
}
