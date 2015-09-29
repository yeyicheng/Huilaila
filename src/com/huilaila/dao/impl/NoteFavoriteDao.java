package com.huilaila.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.INoteFavoriteDao;
import com.huilaila.po.NoteFavorite;

public class NoteFavoriteDao extends SqlMapClientDaoSupport implements
		INoteFavoriteDao {

	public Long saveNoteFavorite(NoteFavorite noteFavorite) {
		return (Long) getSqlMapClientTemplate().insert("NoteFavorite.save",
				noteFavorite);
	}

	public Object deleteById(NoteFavorite noteFavorite) {
		return getSqlMapClientTemplate().delete("NoteFavorite.deleteById",
				noteFavorite);
	}

}
