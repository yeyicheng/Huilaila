package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.Job;
import com.huilaila.po.JobApplication;
import com.huilaila.po.User;

public interface IJobApplicationDao {
	public Object saveJobApplicatoin(JobApplication jobApplication);

	public Integer deleteById(JobApplication jobApplication);

	public Integer update(JobApplication jobApplication);

//	public List findByExample(JobApplication jobApplication);

	public List findByJob(Job job);

	public List findByUser(User user);
}
