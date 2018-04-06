package com.Ilvcode.controller;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MessageController {

	@MessageMapping("/messaging")
	@SendTo("/topic/messaging")
	public MessageInfo messaging(MessageInfo message) throws Exception {
		System.out.println("in messsaging"+  message.getContent());
		
		Thread.sleep(1000);
		return message;
	}
}
