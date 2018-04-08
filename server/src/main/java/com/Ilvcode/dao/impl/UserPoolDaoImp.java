package com.Ilvcode.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.Ilvcode.dao.UserPoolDao;

@Repository
public class UserPoolDaoImp implements UserPoolDao {

	@Override
	public UserNamePool getInstance() {
		
		return UserNamePool.getInstance();
	}

	@Override
	public void addUser(String user) {
		UserNamePool.getInstance().addUser(user);		
	}

	@Override
	public Set<String> getList() {
		return UserNamePool.getInstance().getList();		
	}

	@Override
	public boolean isDuplicated(String user) {
		return UserNamePool.getInstance().isDuplicated(user);
	}

	@Override
	public void removeuser(String user) {
		UserNamePool.getInstance().romoveUser(user);
	}

	@Override
	public boolean isFull() {
		return UserNamePool.getInstance().isFull();
	}

	@Override
	public void updateIsFull() {
		UserNamePool.getInstance().updateIsFull();
	}
	
}
