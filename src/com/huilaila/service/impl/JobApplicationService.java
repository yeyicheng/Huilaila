package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IJobApplicationDao;
import com.huilaila.po.JobApplication;
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

	public List findByExample(JobApplication jobApplication) {
		return jobApplicationDao.findByExample(jobApplication);
	}

}
