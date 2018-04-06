package com.Ilvcode.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserNamePool {
	private final Integer MAX_NUM_CONNECTION = 10;
	private Set<String> list = new HashSet<>();
	private static UserNamePool userNamePool;
	private boolean isFull;
	private UserNamePool(boolean isFull) {
		this.isFull = isFull;
	}
	public synchronized  static UserNamePool getInstance() {
		if(userNamePool == null) {
			userNamePool = new UserNamePool(false);
		}
		return userNamePool;
	}
	public Set<String> getList() {
		return list;
	}
	public boolean isFull() {
		return isFull;
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	public void updateIsFull() {
		this.isFull= list.size() >= MAX_NUM_CONNECTION;
	}

	
}
