package com.cloudalibaba.consumer.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;

public class CustomerBlockHandler {

	
	public CommonResult handleException(BlockException exception) {
		return new CommonResult(444, "按客户自定义,globalhandlerexception"+"\t",new Payment(200L,"1"));
	}
	
	public CommonResult handleException2(BlockException exception) {
		return new CommonResult(444, "按客户自定义2,globalhandlerexception"+"\t 服务不可用",new Payment(200L,"22"));
	}
}
