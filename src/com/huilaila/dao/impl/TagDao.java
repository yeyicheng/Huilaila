package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.ITagDao;
import com.huilaila.po.Tag;
import com.huilaila.po.User;

public class TagDao extends SqlMapClientDaoSupport implements ITagDao {

	public Object saveTag(Tag tag) {
		return getSqlMapClientTemplate().insert("Tag.save", tag);
	}

	public Integer deleteById(Tag tag) {
		return getSqlMapClientTemplate().delete("Tag.deleteById", tag);
	}

	public List findTags() {
		return getSqlMapClientTemplate().queryForList("Tag.findTags");
	}

	public List findByUser(User user) {
		return getSqlMapClientTemplate().queryForList("Tag.findByUser", user);
	}
}
