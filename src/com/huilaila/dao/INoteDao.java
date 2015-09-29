package com.huilaila.dao;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Note;
import com.huilaila.po.User;

public interface INoteDao {

	Object saveNote(Note note);

	List findByPage(Page pageBean);

	int findByCount(Page pageBean);

	List findByExample(Note note);

	Object deleteById(Note note);

	Object update(Note note);

	List findByUser(User user);

}
