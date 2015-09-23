package com.huilaila.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IJobFavoriteDao;

public class JobFavoriteDao extends SqlMapClientDaoSupport implements IJobFavoriteDao {

	public Object saveJobFavorite(com.huilaila.po.JobFavorite jobFavorite) {
		return getSqlMapClientTemplate()
				.insert("JobFavorite.save", jobFavorite);
	}

	public Integer deleteById(com.huilaila.po.JobFavorite jobFavorite) {
		return getSqlMapClientTemplate().delete("JobFavorite.deleteById",
				jobFavorite);
	}

}
