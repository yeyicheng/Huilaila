package com.huilaila.service;

import java.util.List;

import com.huilaila.po.JobApplication;

public interface IJobApplicationService {
	public Object saveJobApplication(JobApplication jobApplication);

	public boolean updateJobApplication(JobApplication jobApplication) throws Exception;

	public boolean deleteJobApplication(JobApplication jobApplication);
	
	public List findByExample(JobApplication jobApplication);

}
