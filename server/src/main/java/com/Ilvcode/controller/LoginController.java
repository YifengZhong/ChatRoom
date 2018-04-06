package com.Ilvcode.controller;
import java.util.Set;

//import org.json.JSONObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class LoginController {
	//add the user into active list and then broadcast to other users
	@MessageMapping("/login")
	@SendTo("/topic/login")
	public UserNamePool login(UserName username) throws Exception {
		System.out.println("in login"+  username.getFullName());
		UserNamePool userNamePool = UserNamePool.getInstance();
		if(username != null) {
			userNamePool.getList().add(username.getFullName());
		}
		return userNamePool;
	}
	//Remove the user from active list and then broadcast to other users
	@MessageMapping("/logout")
	@SendTo("/topic/login")
	public Set<String> logout(UserName username) throws Exception {
		System.out.println("in logout" + username.getFullName());
		Set<String> set = UserNamePool.getInstance();
		set.remove(username.getFullName());
		return set;
	}
	
}
