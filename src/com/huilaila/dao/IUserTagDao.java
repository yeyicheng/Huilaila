package com.huilaila.dao;

import com.huilaila.po.UserTag;

public interface IUserTagDao {
	public Object saveUserTag(UserTag userTag);

	public Integer deleteById(UserTag userTag);

	public Integer deleteByUserIdAndTagId(UserTag userTag);
}
