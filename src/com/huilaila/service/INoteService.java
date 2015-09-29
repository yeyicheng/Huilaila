package com.huilaila.service;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Note;
import com.huilaila.po.User;

public interface INoteService {

	Long saveNote(Note note);

	Page findByPage(Page pageBean);

	List findByExample(Note note);

	boolean deleteNote(Note note);

	boolean updateNote(Note note);

	List findByUser(User user);

}
