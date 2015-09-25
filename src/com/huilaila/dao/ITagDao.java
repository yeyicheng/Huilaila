package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.Tag;
import com.huilaila.po.User;

public interface ITagDao {
	public Object saveTag(Tag tag);

	public Integer deleteById(Tag tag);

	public List findTags();

	public List findByUser(User user);
	
}
