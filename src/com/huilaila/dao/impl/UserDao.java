package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.core.Page;
import com.huilaila.dao.IUserDao;
import com.huilaila.po.Tag;
import com.huilaila.po.User;

public class UserDao extends SqlMapClientDaoSupport implements IUserDao {

	public Integer deleteById(User user) {
		return getSqlMapClientTemplate().delete("User.deleteById", user);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"User.findByCount", page);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("User.findByPage", page);
	}

	public Object saveUser(User user) {
		return getSqlMapClientTemplate().insert("User.save", user);
	}

	public Integer update(User user) throws Exception {
		return getSqlMapClientTemplate().update("User.update", user);
	}

	public User login(User user) {
		return (User) getSqlMapClientTemplate().queryForObject("User.login",
				user);
	}

	public List findByExample(User user) {
		return getSqlMapClientTemplate().queryForList("User.findByExample",
				user);
	}

	public List findByLocation(User user) {
		return getSqlMapClientTemplate().queryForList("User.findByLocation",
				user);
	}

	public List findByTag(Tag tag) {
		return getSqlMapClientTemplate().queryForList("User.findByTag", tag);
	}

	public List findBySchool(User user) {
		return getSqlMapClientTemplate()
				.queryForList("User.findBySchool", user);
	}

}
