package com.Ilvcode.dao.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.Ilvcode.domain.ConnectionNumLimit;

public class UserNamePool {
	private final ConnectionNumLimit MAX_NUM_CONNECTION = new ConnectionNumLimit(10);
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
	public boolean isDuplicated(String name) {
		return list.contains(name);
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	public void updateIsFull() {
		this.isFull= list.size() >= MAX_NUM_CONNECTION.getNumber();
		return;
	}
	public void romoveUser(String name) {
		list.remove(name);
	}
	public void addUser(String name) {
		list.add(name);
	}
	
}
