package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Job;
import com.huilaila.core.Page;

public interface IJobService {
	public Object saveJob(Job job);

	public Page findByPage(Page page);

	public boolean updateJob(Job job) throws Exception;

	public boolean deleteJob(Job job);

	public List findByExample(Job job);
}
