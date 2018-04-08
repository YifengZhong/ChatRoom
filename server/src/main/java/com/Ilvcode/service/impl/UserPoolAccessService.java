package com.Ilvcode.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Ilvcode.aspect.annotation.Logging;
import com.Ilvcode.dao.UserPoolDao;
import com.Ilvcode.dao.impl.UserNamePool;
import com.Ilvcode.service.UserPoolService;

@Service
public class UserPoolAccessService implements UserPoolService {
	
	@Autowired
	private UserPoolDao userPoolDao;

	@Override
	public UserNamePool getInstance() {
		return userPoolDao.getInstance();
	}

	@Override
	@Logging
	public void addUser(String user) {
		userPoolDao.addUser(user);
	}

	@Override
	public Set<String> getList() {
		return userPoolDao.getList();
	}

	@Override
	@Logging
	public boolean isDuplicated(String user) {
		return userPoolDao.isDuplicated(user);
	}

	@Override
	@Logging
	public void removeuser(String user) {
		userPoolDao.removeuser(user);
	}

	@Override
	@Logging
	public boolean isFull() {
		return userPoolDao.isFull();
	}

	@Override
	@Logging
	public void updateIsFull() {
		userPoolDao.updateIsFull();
	}

}
