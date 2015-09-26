package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.JobFavorite;
import com.huilaila.po.User;

public interface IJobFavoriteDao {
	public Object saveJobFavorite(JobFavorite jobFavorite);

	public Integer deleteById(JobFavorite jobFavorite);

	public List findByUser(User user);
}
