package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IUserDao;
import com.huilaila.po.User;
import com.huilaila.service.IUserService;
import com.huilaila.core.Page;

public class UserService implements IUserService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public boolean deleteUser(User user) {
		Integer flag = userDao.deleteById(user);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(userDao.findByPage(page));
		page.setTotalProperty(userDao.findByCount(page));
		return page;
	}

	public Object saveUser(User user) {
		return userDao.saveUser(user);
	}

	public boolean updateUser(User user) throws Exception {
		Integer flag = userDao.update(user);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public User login(User user) {
		return userDao.login(user);
	}

	public List findByExample(User user) {
		return userDao.findByExample(user);
	}

	public List findByLocation(User user) {
		return userDao.findByLocation(user);
	}

	public List findByTag(User user) {
		return userDao.findByTag(user);
	}

	public List findBySchool(User user) {
		return userDao.findBySchool(user);
	}

}
