package com.huilaila.dao;

import com.huilaila.po.JobFavorite;

public interface IJobFavoriteDao {
	public Object saveJobFavorite(JobFavorite jobFavorite);

	public Integer deleteById(JobFavorite jobFavorite);
}
