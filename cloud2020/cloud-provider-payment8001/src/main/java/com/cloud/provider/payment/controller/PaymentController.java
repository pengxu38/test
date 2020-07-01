package com.cloud.provider.payment.controller;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.cloud.provider.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value ="/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result=paymentService.create(payment);
        log.info("******结果："+result);

         if(result>0){
            return new CommonResult(200,"插入数据库成功"+serverPort,result);
        }else {
             return new CommonResult(444,"插入数据库失败"+serverPort,null);
         }
    }

    @GetMapping(value ="/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentByid(id);
        log.info("******结果："+payment+"啊哈哈"+serverPort);

        if(payment!=null){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录"+serverPort,null);
        }
    }
    @GetMapping(value="/payment/discovery")
    public Object discovery() {
     List<String> list = 	discoveryClient.getServices();
     list.stream().forEach(element->log.info("*****element*****" + element));
     List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
     instances.stream().forEach(instance->log.info(
    			instance.getServiceId()+"\t"+
                instance.getHost()+"\t" + 
    		    instance.getPort() +"\t"+ 
                instance.getUri()));
       return this.discoveryClient;
    }
    
	@GetMapping(value="/payment/lb")
	public String getPaymentLB() {
		return serverPort;
	}
	
	@GetMapping(value="/payment/feign/timeout")
	public String payFeithTimeout() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
		}
		return serverPort;
	}
	
	@GetMapping(value="/payment/zipkin")
	public String zipkin() {
		return serverPort;
	}
	
}
