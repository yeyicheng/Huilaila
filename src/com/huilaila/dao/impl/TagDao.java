package com.huilaila.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.ITagDao;
import com.huilaila.po.Tag;

public class TagDao extends SqlMapClientDaoSupport implements ITagDao {

	public Object saveTag(Tag tag) {
		return getSqlMapClientTemplate().insert("Tag.save", tag);
	}

	public Integer deleteById(Tag tag) {
		return getSqlMapClientTemplate().delete("Tag.deleteById", tag);
	}

}
