package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.ICommentDao;
import com.huilaila.po.Comment;

public class CommentDao extends SqlMapClientDaoSupport implements ICommentDao {
	public Long saveComment(Comment comment) {
		return (Long) getSqlMapClientTemplate().insert("Comment.save", comment);
	}

	public Object deleteById(Comment comment) {
		return getSqlMapClientTemplate().delete("Comment.deleteById", comment);
	}

	public List findByExample(Comment comment) {
		return getSqlMapClientTemplate().queryForList("Comment.findByExample",
				comment);
	}

}
