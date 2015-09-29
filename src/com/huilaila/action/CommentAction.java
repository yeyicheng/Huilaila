package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Comment;
import com.huilaila.service.ICommentService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class CommentAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private ICommentService commentService;

	private Comment comment;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveComment() {
		System.out.println("===CommentAction.saveComment===");
		Long commentId = (Long) commentService.saveComment(comment);
		success = commentId != null;
		return SUCCESS;
	}

//	public String findAllComment() {
//		System.out.println("===CommentAction.findAllComment===");
//		String strCondition = getRequest().getParameter("conditions");
//		List<String> conditions = new ArrayList<String>();
//		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
//		List<String> utf8Condition = new ArrayList<String>();
//		for (String c : conditions) {
//			try {
//				utf8Condition
//						.add(new String(c.getBytes("iso-8859-1"), "utf-8"));
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//		pageBean = new Page();
//		pageBean.setConditions(utf8Condition);
//		String start = getRequest().getParameter("start");
//		String limit = getRequest().getParameter("limit");
//		int startInt = start != null ? Integer.valueOf(start) : 0;
//		int limitInt = limit != null ? Integer.valueOf(limit) : 10;
//		pageBean.setLimit(limitInt);
//		pageBean.setStart(startInt);
//		pageBean = commentService.findByPage(pageBean);
//		pageBean.setSuccess(pageBean.getRoot() != null);
//		return SUCCESS;
//	}

	public String findByExample() {
		pageBean = new Page();
		List comments = commentService.findByExample(comment);
		success = comments != null;
		if (success) {
			pageBean.setRoot(comments);
			pageBean.setTotalProperty(comments.size());
		}
		return SUCCESS;
	}

	public String deleteComment() {
		success = commentService.deleteComment(comment);
		return SUCCESS;
	}

//	public String updateComment() {
//		success = commentService.updateComment(comment);
//		return SUCCESS;
//	}

	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page page) {
		this.pageBean = page;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
