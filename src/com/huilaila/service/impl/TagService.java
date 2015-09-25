package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.ITagDao;
import com.huilaila.po.Tag;
import com.huilaila.po.User;
import com.huilaila.service.ITagService;

public class TagService implements ITagService {
	private ITagDao tagDao;

	public ITagDao getTagDao() {
		return tagDao;
	}

	public void setTagDao(ITagDao tagDao) {
		this.tagDao = tagDao;
	}

	public Object saveTag(Tag tag) {
		return tagDao.saveTag(tag);
	}

	public boolean deleteTag(Tag tag) {
		Integer flag = tagDao.deleteById(tag);
		return flag != null;
	}

	public List findTags() {
		return tagDao.findTags();
	}

	public List findByUser(User user) {
		return tagDao.findByUser(user);
	}
}
