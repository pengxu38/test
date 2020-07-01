package com.cloudalibaba.consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entites.CommonResult;
import com.cloudalibaba.consumer.domain.Order;
import com.cloudalibaba.consumer.sevice.OrderService;
import com.cloudalibaba.consumer.sevice.OrderServiceSnow;

@RestController
public class OrderController {

	@Resource
	private OrderService orderService;
	
	@Resource
	private OrderServiceSnow snow ;
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	@GetMapping("/order/create")
	public CommonResult create(Order order) {
		orderService.create(order);
		return new CommonResult(200,"订单创建成功");
	}
	
	@GetMapping("/snow")
	public String snow() {
		 return snow.getIdBySnowFlake();
	}
}
