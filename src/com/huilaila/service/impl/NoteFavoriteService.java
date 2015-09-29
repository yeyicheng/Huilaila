package com.huilaila.service.impl;

import com.huilaila.dao.INoteFavoriteDao;
import com.huilaila.po.NoteFavorite;
import com.huilaila.service.INoteFavoriteService;

public class NoteFavoriteService implements INoteFavoriteService {
	private INoteFavoriteDao noteFavoriteDao;
	
	public Long saveNoteFavorite(NoteFavorite noteFavorite) {
		return noteFavoriteDao.saveNoteFavorite(noteFavorite);
	}

	public boolean deleteNoteFavorite(NoteFavorite noteFavorite) {
		return noteFavoriteDao.deleteById(noteFavorite) != null;
	}

	public INoteFavoriteDao getNoteFavoriteDao() {
		return noteFavoriteDao;
	}

	public void setNoteFavoriteDao(INoteFavoriteDao noteFavoriteDao) {
		this.noteFavoriteDao = noteFavoriteDao;
	}

}
