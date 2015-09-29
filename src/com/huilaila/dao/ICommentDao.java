package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.Comment;

public interface ICommentDao {

	Long saveComment(Comment comment);

	Object deleteById(Comment comment);

	List findByExample(Comment comment);

}
