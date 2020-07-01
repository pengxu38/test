package com.cloudalibaba.consumer.sevice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springcloud.entites.CommonResult;

@FeignClient(value="seata-storage-service")
public interface StorageService {
	
	@PostMapping(value="/storage/decrease")
	CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
