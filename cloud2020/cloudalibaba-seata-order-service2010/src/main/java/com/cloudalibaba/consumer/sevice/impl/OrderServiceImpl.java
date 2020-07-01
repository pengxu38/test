package com.cloudalibaba.consumer.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudalibaba.consumer.dao.OrderDao;
import com.cloudalibaba.consumer.domain.Order;
import com.cloudalibaba.consumer.sevice.AccountService;
import com.cloudalibaba.consumer.sevice.OrderService;
import com.cloudalibaba.consumer.sevice.StorageService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	StorageService storageService;
	
	@Override
	@GlobalTransactional(name="create-order",rollbackFor=Exception.class)
	public void create(Order order) {
			log.info("-------->开始创建订单");
			orderDao.create(order);
			log.info("-------->订单微服务开始调用库存,做扣减start");
			storageService.decrease(order.getProductId(), order.getCount());
			log.info("-------->订单微服务开始调用库存,做扣减end");
			
			log.info("-------->订单微服务开始调用账户,做扣减Money start");
			accountService.decrease(order.getUserId(), order.getMoney());
			log.info("-------->订单微服务开始调用账户,做扣减Money end");
			
			log.info("-------->修改订单状态");
			orderDao.update(order.getUserId(), 0);
			System.out.println(10/0);
	}

	@Override
	public void update(Long userId, Integer status) {
		
	}

}
