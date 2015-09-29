package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.ICommentDao;
import com.huilaila.po.Comment;
import com.huilaila.service.ICommentService;

public class CommentService implements ICommentService {
	private ICommentDao commentDao;

	public Long saveComment(Comment comment) {
		return commentDao.saveComment(comment);
	}

	public boolean deleteComment(Comment comment) {
		return commentDao.deleteById(comment) != null;
	}

	public List findByExample(Comment comment) {
		return commentDao.findByExample(comment);
	}

	public ICommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}

}
