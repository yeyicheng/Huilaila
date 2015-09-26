package com.huilaila.service;

import java.util.List;

import com.huilaila.po.JobFavorite;
import com.huilaila.po.User;

public interface IJobFavoriteService {
	public Object saveJobFavorite(JobFavorite jobFavorite);

	public boolean deleteJobFavorite(JobFavorite jobFavorite);

	public List findByUser(User user);
}
