package com.Ilvcode.service;

import java.util.Set;

import com.Ilvcode.dao.impl.UserNamePool;

public interface UserPoolService {
	public UserNamePool getInstance();
	public void addUser(String user);
	public Set<String> getList();
	public boolean isDuplicated(String user);
	public void removeuser(String user);
	public boolean isFull();
	public void updateIsFull();
}
