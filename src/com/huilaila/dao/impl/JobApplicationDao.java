package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IJobApplicationDao;
import com.huilaila.po.Job;
import com.huilaila.po.JobApplication;
import com.huilaila.po.User;

public class JobApplicationDao extends SqlMapClientDaoSupport implements
		IJobApplicationDao {

	public Object saveJobApplicatoin(JobApplication jobApplication) {
		return getSqlMapClientTemplate().insert("JobApplication.save",
				jobApplication);

	}

	public Integer deleteById(JobApplication jobApplication) {
		return getSqlMapClientTemplate().delete("JobApplication.deleteById",
				jobApplication);

	}

	public Integer update(JobApplication jobApplication) {
		return getSqlMapClientTemplate().update("JobApplication.update",
				jobApplication);
	}

//	public List findByExample(JobApplication jobApplication) {
//		return getSqlMapClientTemplate().queryForList("JobApplication.findByExample", jobApplication);
//	}

	public List findByJob(Job job) {
		return getSqlMapClientTemplate().queryForList("JobApplication.findByJob", job);
	}

	public List findByUser(User user) {
		return getSqlMapClientTemplate().queryForList("JobApplication.findByUser", user);
	}
}
