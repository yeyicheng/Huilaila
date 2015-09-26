package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IJobApplicationDao;
import com.huilaila.po.Job;
import com.huilaila.po.JobApplication;
import com.huilaila.po.User;
import com.huilaila.service.IJobApplicationService;

public class JobApplicationService implements IJobApplicationService {

	private IJobApplicationDao jobApplicationDao;

	public IJobApplicationDao getJobApplicationDao() {
		return jobApplicationDao;
	}

	public void setJobApplicationDao(IJobApplicationDao jobApplicationDao) {
		this.jobApplicationDao = jobApplicationDao;
	}

	public Object saveJobApplication(JobApplication jobApplication) {
		return jobApplicationDao.saveJobApplicatoin(jobApplication);
	}

	public boolean updateJobApplication(JobApplication jobApplication)
			throws Exception {
		return jobApplicationDao.update(jobApplication) != null;
	}

	public boolean deleteJobApplication(JobApplication jobApplication) {
		return jobApplicationDao.deleteById(jobApplication) != null;
	}

//	public List findByExample(JobApplication jobApplication) {
//		return jobApplicationDao.findByExample(jobApplication);
//	}

	public List findByJob(Job job) {
		return jobApplicationDao.findByJob(job);
	}

	public List findByUser(User user) {
		return jobApplicationDao.findByUser(user);
	}

}
