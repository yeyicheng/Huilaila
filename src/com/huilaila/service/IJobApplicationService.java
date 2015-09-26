package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Job;
import com.huilaila.po.JobApplication;
import com.huilaila.po.User;

public interface IJobApplicationService {
	public Object saveJobApplication(JobApplication jobApplication);

	public boolean updateJobApplication(JobApplication jobApplication) throws Exception;

	public boolean deleteJobApplication(JobApplication jobApplication);
	
//	public List findByExample(JobApplication jobApplication);

	public List findByJob(Job job);

	public List findByUser(User user);

}
