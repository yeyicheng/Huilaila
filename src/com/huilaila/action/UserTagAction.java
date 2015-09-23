package com.huilaila.action;

import com.huilaila.core.BaseAction;
import com.huilaila.po.UserTag;
import com.huilaila.service.IUserTagService;

@SuppressWarnings("serial")
public class UserTagAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IUserTagService userTagService;

	private UserTag userTag;

	private boolean success;

	private String tip;

	public String saveUserTag() {
		Long userTagId = (Long) userTagService.saveUserTag(userTag);
		return userTagId != null ? SUCCESS : ERROR;
	}

	public String deleteUserTag() {
		return userTagService.deleteUserTag(userTag) ? SUCCESS : ERROR;
	}

	public String deleteUserTagByUserIdAndTagId() {
		return userTagService.deleteByUserIdAndTagId(userTag) ? SUCCESS : ERROR;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public UserTag getUserTag() {
		return userTag;
	}

	public void setUserTag(UserTag userTag) {
		this.userTag = userTag;
	}

	public void setUserTagService(IUserTagService userTagService) {
		this.userTagService = userTagService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
