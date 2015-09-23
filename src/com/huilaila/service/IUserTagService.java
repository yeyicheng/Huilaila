package com.huilaila.service;

import com.huilaila.po.UserTag;

public interface IUserTagService {
	public Object saveUserTag(UserTag userTag);

	public boolean deleteUserTag(UserTag userTag);

	public boolean deleteByUserIdAndTagId(UserTag userTag);
}
