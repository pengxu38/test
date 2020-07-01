package com.cloudalibaba.provider.payment9002.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;

@RestController
public class PaymentController {
	
	public static Map<Long,Payment> hashMap = new HashMap<Long,Payment>();
	
	static {
		hashMap.put(1L, new Payment(1L, "1xxxxxxxxxxxxxxx"));
		hashMap.put(2L, new Payment(1L, "2xxxxxxxxxxxxxxx"));
		hashMap.put(3L, new Payment(1L, "3xxxxxxxxxxxxxxx"));
	}
	
    @Value("${server.port}")
    private String serverPort;
    
    
	@GetMapping(value="/paymentSql/{id}")
	public  CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
		Payment payment = hashMap.get(id);
		CommonResult<Payment> result = new CommonResult(200,"from sql serverport:"+ serverPort,payment);
		return result;
	}
	
}
