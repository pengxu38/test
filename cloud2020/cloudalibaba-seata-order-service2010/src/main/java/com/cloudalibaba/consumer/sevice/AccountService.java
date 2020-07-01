package com.cloudalibaba.consumer.sevice;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springcloud.entites.CommonResult;


@FeignClient(value="seata-account-service")
public interface AccountService {
	
	@PostMapping(value="/account/decrease")
	CommonResult decrease(@RequestParam("userId")Long userId,
			                              @RequestParam("money")BigDecimal money);
}
