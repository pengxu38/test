package com.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.IMessageService;

@RestController
public class SendMessageController {
	@Resource
	private IMessageService service;
	
	@GetMapping("/sendMessage")
	public String sendMessage() {
		return service.send();
	}
}
