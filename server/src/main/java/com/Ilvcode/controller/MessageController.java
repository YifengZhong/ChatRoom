package com.Ilvcode.controller;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.Ilvcode.aspect.annotation.Logging;
import com.Ilvcode.domain.MessageInfo;



@RestController
@CrossOrigin
public class MessageController {
	@Logging
	@MessageMapping("/messaging")
	@SendTo("/topic/messaging")
	public MessageInfo messaging(MessageInfo message) throws Exception {
		//get the message from a certain user and broadcast to other users.
		return message;
	}
}
