package com.huilaila.service.impl;

import com.huilaila.dao.IJobFavoriteDao;
import com.huilaila.po.JobFavorite;
import com.huilaila.service.IJobFavoriteService;

public class JobFavoriteService implements IJobFavoriteService {

	private IJobFavoriteDao jobFavoriteDao;

	public IJobFavoriteDao getJobFavoriteDao() {
		return jobFavoriteDao;
	}

	public void setJobFavoriteDao(IJobFavoriteDao jobFavoriteDao) {
		this.jobFavoriteDao = jobFavoriteDao;
	}

	public Object saveJobFavorite(JobFavorite jobFavorite) {
		return jobFavoriteDao.saveJobFavorite(jobFavorite);
	}

	public boolean deleteJobFavorite(JobFavorite jobFavorite) {
		return jobFavoriteDao.deleteById(jobFavorite) != null;
	}

}
