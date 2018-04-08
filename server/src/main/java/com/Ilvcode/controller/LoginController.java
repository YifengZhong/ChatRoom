package com.Ilvcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.json.JSONObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.Ilvcode.aspect.annotation.Logging;
import com.Ilvcode.dao.impl.UserNamePool;
import com.Ilvcode.domain.UserName;
import com.Ilvcode.service.UserPoolService;


@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	UserPoolService userPoolService;
	
	//add the user into active list and then broadcast to other users
	@MessageMapping("/login")
	@SendTo("/topic/login")
	@Logging
	public UserNamePool login(UserName username) throws Exception {
		UserNamePool userNamePool = userPoolService.getInstance();
		// if Pool is full return directly do not do the login 
		if (userNamePool.isFull()) {
			return userNamePool;
		}
		if(username != null) {
			if(userNamePool.isDuplicated(username.getFullName())) {
				//if name is duplicated ;
				return null;
			}
			userNamePool.addUser(username.getFullName());
			//Update the user flag to see if pool is full
			userNamePool.updateIsFull();
		}
		return userNamePool;
	}
	//Remove the user from active list and then broadcast to other users
	@MessageMapping("/logout")
	@SendTo("/topic/login")
	@Logging
	public UserNamePool logout(UserName username) throws Exception {
		UserNamePool userNamePool = UserNamePool.getInstance();
		//remove the user from pool and update the full flag
		if(username != null) {
			userNamePool.romoveUser(username.getFullName());
			userNamePool.updateIsFull();
		}
		return userNamePool;
	}
	
}
