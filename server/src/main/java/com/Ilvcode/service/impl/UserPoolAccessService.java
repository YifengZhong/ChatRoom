package com.Ilvcode.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	public void addUser(String user) {
		userPoolDao.addUser(user);
	}

	@Override
	public Set<String> getList() {
		return userPoolDao.getList();
	}

	@Override
	public boolean isDuplicated(String user) {
		return userPoolDao.isDuplicated(user);
	}

	@Override
	public void removeuser(String user) {
		userPoolDao.removeuser(user);
	}

	@Override
	public boolean isFull() {
		return userPoolDao.isFull();
	}

	@Override
	public void updateIsFull() {
		userPoolDao.updateIsFull();
	}

}
