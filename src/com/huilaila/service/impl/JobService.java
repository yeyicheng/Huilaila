package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IJobDao;
import com.huilaila.po.Job;
import com.huilaila.service.IJobService;
import com.huilaila.core.Page;

public class JobService implements IJobService {

	private IJobDao jobDao;

	public IJobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(IJobDao jobDao) {
		this.jobDao = jobDao;
	}

	public Object saveJob(Job job) {
		return jobDao.saveJob(job);
	}

	public Page findByPage(Page page) {
		page.setRoot(jobDao.findByPage(page));
		page.setTotalProperty(jobDao.findByCount(page));
		return page;
	}

	public boolean updateJob(Job job) throws Exception {
		return jobDao.update(job) != null;
	}

	public boolean deleteJob(Job job) {
		return jobDao.deleteById(job) != null;
	}

	public List findByExample(Job job) {
		return jobDao.findByExample(job);
	}

}
