package com.huilaila.service;

import java.util.List;

import com.huilaila.po.User;
import com.huilaila.core.Page;

public interface IUserService {
	public Object saveUser(User user);

	public Page findByPage(Page page);

	public boolean updateUser(User user) throws Exception;

	public boolean deleteUser(User user);

	public User login(User user);

	public List findByExample(User user);

	public List findByLocation(User user);

	public List findByTag(User user);

	public List findBySchool(User user);
}
