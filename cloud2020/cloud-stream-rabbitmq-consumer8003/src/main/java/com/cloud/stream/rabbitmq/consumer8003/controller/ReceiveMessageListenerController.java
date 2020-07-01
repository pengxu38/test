package com.cloud.stream.rabbitmq.consumer8003.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

	@Value("${server.port}")
	private String serverPort;
	
	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		System.out.println("消费者"+serverPort+"👌收到消息：" + message.getPayload());
	}
	
	
}
