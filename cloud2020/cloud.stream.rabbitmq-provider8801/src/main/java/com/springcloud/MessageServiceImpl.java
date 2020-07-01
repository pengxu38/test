package com.springcloud;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import cn.hutool.core.lang.UUID;

@EnableBinding(Source.class) //定义消息的推送管道
public class MessageServiceImpl implements IMessageService {

	@Resource
	private MessageChannel output ; //消息发送管道
	
	@Override
	public String send() {
		String serial = UUID.randomUUID().toString();
		boolean f = output.send(MessageBuilder.withPayload(serial).build());
		return serial + ":" + f;
	}

}
