package com.huilaila.dao;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.User;

public interface IUserDao {
	public Object saveUser(User user);

	public List findByPage(Page page);

	public int findByCount(Page page);

	public Integer update(User user) throws Exception;

	public Integer deleteById(User user);

	public User login(User user);

	public List findByExample(User user);
	
	public List findByLocation(User user);
	
	public List findByTag(User user);
	
	public List findBySchool(User user);
}
 