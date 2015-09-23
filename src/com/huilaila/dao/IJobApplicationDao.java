package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.JobApplication;

public interface IJobApplicationDao {
	public Object saveJobApplicatoin(JobApplication jobApplication);

	public Integer deleteById(JobApplication jobApplication);

	public Integer update(JobApplication jobApplication);

	public List findByExample(JobApplication jobApplication);
}
