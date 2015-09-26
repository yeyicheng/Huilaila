package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IJobFavoriteDao;
import com.huilaila.po.User;

public class JobFavoriteDao extends SqlMapClientDaoSupport implements IJobFavoriteDao {

	public Object saveJobFavorite(com.huilaila.po.JobFavorite jobFavorite) {
		return getSqlMapClientTemplate()
				.insert("JobFavorite.save", jobFavorite);
	}

	public Integer deleteById(com.huilaila.po.JobFavorite jobFavorite) {
		return getSqlMapClientTemplate().delete("JobFavorite.deleteById",
				jobFavorite);
	}

	public List findByUser(User user) {
		return getSqlMapClientTemplate().queryForList("JobFavorite.findByUser", user);
	}

}
