package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.core.Page;
import com.huilaila.dao.IResumeDao;
import com.huilaila.po.Resume;

public class ResumeDao extends SqlMapClientDaoSupport implements IResumeDao {

	public Object saveResume(Resume resume) {
		return getSqlMapClientTemplate().insert("Resume.save", resume);
	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Resume.findByPage", page);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"Resume.findByCount", page);
	}

	public Integer update(Resume resume) throws Exception {
		return getSqlMapClientTemplate().update("Resume.update", resume);
	}

	public Integer deleteById(Resume resume) {
		return getSqlMapClientTemplate().delete("Resume.deleteById", resume);

	}

	public List findByExample(Resume resume) {
		return getSqlMapClientTemplate().queryForList("Resume.findByExample",
				resume);
	}

}
