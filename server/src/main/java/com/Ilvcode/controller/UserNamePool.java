package com.Ilvcode.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserNamePool {
	private Set<String> list = new HashSet<>();
	private static UserNamePool userNamePool;
	private UserNamePool() {
		
	}
	public synchronized  static UserNamePool getInstance() {
		if(userNamePool == null) {
			userNamePool = new UserNamePool();
		}
		return userNamePool;
	}
	public Set<String> getList() {
		return list;
	}

	
}
