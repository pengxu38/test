package com.cloudalibaba.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;

@Component
public class PaymentFallbackService implements PaymentService{

	@Override
	public CommonResult<Payment> paymentSQL(Long id) {
		return new CommonResult<Payment>(444444,"服务降级返回,--PaymentService",
				new Payment(id,"error"));
	}

}
