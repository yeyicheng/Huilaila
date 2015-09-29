package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.core.Page;
import com.huilaila.dao.INoteDao;
import com.huilaila.po.Note;
import com.huilaila.po.User;

public class NoteDao extends SqlMapClientDaoSupport implements INoteDao {

	public Object saveNote(Note note) {
		return getSqlMapClientTemplate().insert("Note.save", note);
	}

	public Integer deleteById(Note note) {
		return getSqlMapClientTemplate().delete("Note.deleteById", note);
	}

	public Integer update(Note note) {
		return getSqlMapClientTemplate().update("Note.update", note);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Note.findByPage", page);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"Note.findByCount", page);
	}

	public List findByExample(Note note) {
		return getSqlMapClientTemplate().queryForList("Note.findByExample",
				note);
	}

	public List findByUser(User user) {
		return getSqlMapClientTemplate().queryForList("Note.findByUser",
				user);
	}

}
