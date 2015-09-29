package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.dao.INoteDao;
import com.huilaila.po.Note;
import com.huilaila.po.User;
import com.huilaila.service.INoteService;

public class NoteService implements INoteService {
	INoteDao noteDao;

	public Long saveNote(Note note) {
		return (Long) noteDao.saveNote(note);
	}

	public Page findByPage(Page pageBean) {
		pageBean.setRoot(noteDao.findByPage(pageBean));
		pageBean.setTotalProperty(noteDao.findByCount(pageBean));
		return pageBean;
	}

	public List findByExample(Note note) {
		return noteDao.findByExample(note);
	}

	public boolean deleteNote(Note note) {
		return noteDao.deleteById(note) != null;
	}

	public boolean updateNote(Note note) {
		return noteDao.update(note) != null;
	}

	public List findByUser(User user) {
		return noteDao.findByUser(user);
	}

	public INoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(INoteDao noteDao) {
		this.noteDao = noteDao;
	}
}
