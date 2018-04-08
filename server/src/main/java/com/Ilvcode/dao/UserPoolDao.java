package com.Ilvcode.dao;

import java.util.Set;

import com.Ilvcode.dao.impl.UserNamePool;

public interface UserPoolDao {
	public UserNamePool getInstance();
	public void addUser(String user);
	public Set<String> getList();
	public boolean isDuplicated(String user);
	public void removeuser(String user);
	public boolean isFull();
	public void updateIsFull();
}
