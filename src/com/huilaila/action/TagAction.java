package com.huilaila.action;

import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Tag;
import com.huilaila.po.User;
import com.huilaila.service.ITagService;

@SuppressWarnings("serial")
public class TagAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private ITagService tagService;

	private Tag tag;

	private User user;

	private Page pageBean;

	private boolean success;

	private String tip;

	public String saveTag() {
		System.out.println("===TagAction.saveTag===");
		Long tagId = (Long) tagService.saveTag(tag);
		success = tagId != null;
		return SUCCESS;
	}

	public String deleteTag() {
		System.out.println("===TagAction.deleteTag===");
		success = tagService.deleteTag(tag);
		return SUCCESS;
	}

	public String findTags() {
		System.out.println("===TagAction.findTags===");
		pageBean = new Page();
		List tags = tagService.findTags();
		if (null == tags) {
			success = false;
		} else {
			pageBean.setRoot(tags);
			pageBean.setTotalProperty(tags.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String findByUser() {
		System.out.println("===TagAction.findByUser===");
		pageBean = new Page();
		List tags = tagService.findByUser(user);
		if (null == tags) {
			success = false;
		} else {
			pageBean.setRoot(tags);
			pageBean.setTotalProperty(tags.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
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

	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page pageBean) {
		this.pageBean = pageBean;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
