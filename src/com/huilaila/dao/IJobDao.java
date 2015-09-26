package com.huilaila.dao;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Company;
import com.huilaila.po.Job;

public interface IJobDao {
	public Object saveJob(Job job);

	public Integer deleteById(Job job);

	public Integer update(Job job) throws Exception;

	public List findByPage(Page page);

	public int findByCount(Page page);

	public List findByExample(Job job);

	public List findByCompany(Company company);
}
