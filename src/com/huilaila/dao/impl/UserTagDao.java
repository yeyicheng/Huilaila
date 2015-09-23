package com.huilaila.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IUserTagDao;
import com.huilaila.po.UserTag;

public class UserTagDao extends SqlMapClientDaoSupport implements IUserTagDao {

	public Object saveUserTag(UserTag userTag) {
		return getSqlMapClientTemplate().insert("UserTag.save", userTag);
	}

	public Integer deleteById(UserTag userTag) {
		return getSqlMapClientTemplate().delete("Tag.deleteById", userTag);
	}

	public Integer deleteByUserIdAndTagId(UserTag userTag) {
		return getSqlMapClientTemplate().delete("Tag.deleteByUserIdAndTagId", userTag);
	}

}
