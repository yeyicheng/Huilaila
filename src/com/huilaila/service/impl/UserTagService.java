package com.huilaila.service.impl;

import com.huilaila.dao.IUserTagDao;
import com.huilaila.po.UserTag;
import com.huilaila.service.IUserTagService;

public class UserTagService implements IUserTagService {

	private IUserTagDao userTagDao;

	public IUserTagDao getUserTagDao() {
		return userTagDao;
	}

	public void setUserTagDao(IUserTagDao userTagDao) {
		this.userTagDao = userTagDao;
	}

	public Object saveUserTag(UserTag userTag) {
		return userTagDao.saveUserTag(userTag);
	}

	public boolean deleteUserTag(UserTag userTag) {
		return userTagDao.deleteById(userTag) != null;
	}

	public boolean deleteByUserIdAndTagId(UserTag userTag) {
		return userTagDao.deleteByUserIdAndTagId(userTag) != null;
	}

}
