package com.cloudalibaba.consumer.controller;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.cloudalibaba.consumer.service.PaymentService;

@RestController
public class CircleBreakController {

  @Resource
  private RestTemplate restemplate;
  
  @Value("${service-url.nacos-user-service}")
  private String serverUrl;
  
  @Resource
  PaymentService paymentService;
  
  @GetMapping(value="/fallback/{id}")
  //Java运行是异常
  //@SentinelResource(value="fallback",fallback="handlerFallback")
  //	blockHandler只负责sentinel控制台的配置违规
  //两个异常都配置，还是blockException 
  @SentinelResource(value="fallback",fallback="handlerFallback",
  blockHandler="handlerFallback",exceptionsToIgnore= {IllegalArgumentException.class})
  public CommonResult<Payment> fallback(@PathVariable Long id) {
	  CommonResult<Payment> result = restemplate.getForObject(serverUrl+"/paymentSql/"+id, CommonResult.class);
	  if(id ==4) {
		  throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
	  }else if(result.getData()==null) {
		  throw new NullPointerException("NullPointerException,非法参数异常");
	  }
	  return result;
  }
  
  public CommonResult handlerFallback(@PathVariable Long id,Throwable e) {
	  Payment p = new Payment(id,null);
	  return new CommonResult(444,"Java兜底异常handlerFallback"+e.getMessage(),p);
  }
  
  public CommonResult<Payment> blockHandler(@PathVariable Long id,BlockException b) {
	  Payment p = new Payment(id,null);
	  return new CommonResult(445,"sentinel控制台的配置违规BlockException"+b.getMessage(),p);
  }
  
  @GetMapping(value="/paymentSql/{id}")
  public String paymentSql(@PathVariable("id") Long id) {
	  return restemplate.getForObject(serverUrl+"/paymentSql/"+id, String.class);
  }
  
 
	
	@GetMapping(value="/consumer/paymentSQL/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
		return paymentService.paymentSQL(id);
	}
	
}
