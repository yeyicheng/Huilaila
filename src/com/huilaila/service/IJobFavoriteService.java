package com.huilaila.service;

import com.huilaila.po.JobFavorite;

public interface IJobFavoriteService {
	public Object saveJobFavorite(JobFavorite jobFavorite);

	public boolean deleteJobFavorite(JobFavorite jobFavorite);
}
