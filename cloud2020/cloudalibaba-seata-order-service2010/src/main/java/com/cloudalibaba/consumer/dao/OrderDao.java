package com.cloudalibaba.consumer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloudalibaba.consumer.domain.Order;

@Mapper
public 	interface OrderDao {
	void create(Order order);
	void update(@Param("userId") Long userId,@Param("status") Integer status) ;
}
