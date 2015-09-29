package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Comment;

public interface ICommentService {

	Long saveComment(Comment comment);

	boolean deleteComment(Comment comment);

	List findByExample(Comment comment);

}
