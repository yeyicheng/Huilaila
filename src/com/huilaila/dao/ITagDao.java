package com.huilaila.dao;

import com.huilaila.po.Tag;

public interface ITagDao {
	public Object saveTag(Tag tag);

	public Integer deleteById(Tag tag);
}
