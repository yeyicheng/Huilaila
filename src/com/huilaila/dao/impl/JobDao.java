package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IJobDao;
import com.huilaila.po.Company;
import com.huilaila.po.Job;
import com.huilaila.core.Page;

public class JobDao extends SqlMapClientDaoSupport implements IJobDao {

	public Object saveJob(Job job) {
		return getSqlMapClientTemplate().insert("Job.save", job);
	}

	public Integer deleteById(Job job) {
		return getSqlMapClientTemplate().delete("Job.deleteById", job);
	}

	public Integer update(Job job) throws Exception {
		return getSqlMapClientTemplate().update("Job.update", job);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Job.findByPage", page);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"Job.findByCount", page);
	}

	public List findByExample(Job job) {
		return getSqlMapClientTemplate().queryForList("Job.findByExample", job);
	}

	public List findByCompany(Company company) {
		return getSqlMapClientTemplate().queryForList("Job.findByCompany",
				company);
	}

}
