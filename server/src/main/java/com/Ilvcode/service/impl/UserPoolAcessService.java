package com.Ilvcode.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.Ilvcode.dao.UserPoolDao;
import com.Ilvcode.dao.impl.UserNamePool;
import com.Ilvcode.dao.impl.UserPoolDaoImp;
import com.Ilvcode.service.UserPoolService;

public class UserPoolAcessService implements UserPoolService {
	
	@Autowired
	UserPoolDao userPoolDao;

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
