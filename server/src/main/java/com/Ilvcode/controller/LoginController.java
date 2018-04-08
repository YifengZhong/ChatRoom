package com.Ilvcode.controller;
import java.util.Set;

//import org.json.JSONObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.Ilvcode.domain.UserName;
import com.Ilvcode.service.UserNamePool;


@RestController
@CrossOrigin
public class LoginController {
	//add the user into active list and then broadcast to other users
	@MessageMapping("/login")
	@SendTo("/topic/login")
	public UserNamePool login(UserName username) throws Exception {
		System.out.println("in login"+  username.getFullName());
		UserNamePool userNamePool = UserNamePool.getInstance();
		if (userNamePool.isFull()) {
			return userNamePool;
		}
		if(username != null) {
			if(userNamePool.isDuplicated(username.getFullName())) {
				//TODO return value;
				return null;
			}
			userNamePool.addUser(username.getFullName());
			userNamePool.updateIsFull();
		}
		return userNamePool;
	}
	//Remove the user from active list and then broadcast to other users
	@MessageMapping("/logout")
	@SendTo("/topic/login")
	public UserNamePool logout(UserName username) throws Exception {
		System.out.println("in logout" + username.getFullName());
		UserNamePool userNamePool = UserNamePool.getInstance();
		if(username != null) {
			userNamePool.romoveUser(username.getFullName());
			userNamePool.updateIsFull();
		}
		return userNamePool;
	}
	
}
