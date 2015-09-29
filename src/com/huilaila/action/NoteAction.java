package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Note;
import com.huilaila.po.User;
import com.huilaila.service.INoteService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class NoteAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private INoteService noteService;

	private Note note;

	private boolean success;

	private Page pageBean;

	private String tip;

	private User user;

	public String saveNote() {
		System.out.println("===NoteAction.saveNote===");
		Long noteId = (Long) noteService.saveNote(note);
		success = noteId != null;
		return SUCCESS;
	}

	public String findAllNote() {
		System.out.println("===NoteAction.findAllNote===");
		String strCondition = getRequest().getParameter("conditions");
		List<String> conditions = new ArrayList<String>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		List<String> utf8Condition = new ArrayList<String>();
		for (String c : conditions) {
			try {
				utf8Condition
						.add(new String(c.getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		pageBean = new Page();
		pageBean.setConditions(utf8Condition);
		String start = getRequest().getParameter("start");
		String limit = getRequest().getParameter("limit");
		int startInt = start != null ? Integer.valueOf(start) : 0;
		int limitInt = limit != null ? Integer.valueOf(limit) : 10;
		pageBean.setLimit(limitInt);
		pageBean.setStart(startInt);
		pageBean = noteService.findByPage(pageBean);
		pageBean.setSuccess(pageBean.getRoot() != null);
		return SUCCESS;
	}

	public String findByExample() {
		pageBean = new Page();
		List notes = noteService.findByExample(note);
		success = notes != null;
		if (success) {
			pageBean.setRoot(notes);
			pageBean.setTotalProperty(notes.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteNote() {
		success = noteService.deleteNote(note);
		return SUCCESS;
	}

	public String updateNote() throws Exception {
		success = noteService.updateNote(note);
		return SUCCESS;
	}

	public String findByUser() {
		pageBean = new Page();
		List notes = noteService.findByUser(user);
		if (notes != null) {
			success = true;
			pageBean.setRoot(notes);
			pageBean.setTotalProperty(notes.size());
			pageBean.setSuccess(true);
		} else {
			success = false;
			pageBean.setSuccess(false);
		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public void setNoteService(INoteService noteService) {
		this.noteService = noteService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
