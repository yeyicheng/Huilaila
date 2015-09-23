package com.huilaila.action;

import com.huilaila.core.BaseAction;
import com.huilaila.po.Tag;
import com.huilaila.service.ITagService;

@SuppressWarnings("serial")
public class TagAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private ITagService tagService;

	private Tag tag;

	private boolean success;

	private String tip;

	public String saveTag() {
		Long tagId = (Long) tagService.saveTag(tag);
		return tagId != null ? SUCCESS : ERROR;
	}

	public String deleteTag() {
		return tagService.deleteTag(tag) ? SUCCESS : ERROR;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
