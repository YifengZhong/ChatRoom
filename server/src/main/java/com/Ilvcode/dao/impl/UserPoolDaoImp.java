package com.Ilvcode.dao.impl;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.Ilvcode.aspect.annotation.Logging;
import com.Ilvcode.dao.UserPoolDao;

@Repository
public class UserPoolDaoImp implements UserPoolDao {

	@Override
	public UserNamePool getInstance() {
		
		return UserNamePool.getInstance();
	}

	@Override
	@Logging
	public void addUser(String user) {
		UserNamePool.getInstance().addUser(user);		
	}

	@Override
	@Logging
	public Set<String> getList() {
		return UserNamePool.getInstance().getList();		
	}

	@Override
	@Logging
	public boolean isDuplicated(String user) {
		return UserNamePool.getInstance().isDuplicated(user);
	}

	@Override
	@Logging
	public void removeuser(String user) {
		UserNamePool.getInstance().romoveUser(user);
	}

	@Override
	@Logging
	public boolean isFull() {
		return UserNamePool.getInstance().isFull();
	}

	@Override
	public void updateIsFull() {
		UserNamePool.getInstance().updateIsFull();
	}
	
}
