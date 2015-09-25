package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Tag;
import com.huilaila.po.User;

public interface ITagService {
	public Object saveTag(Tag tag);

	public boolean deleteTag(Tag tag);

	public List findTags();

	public List findByUser(User user);

}
