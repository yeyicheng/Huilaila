package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.core.Page;
import com.huilaila.dao.ICompanyDao;
import com.huilaila.po.Company;

public class CompanyDao extends SqlMapClientDaoSupport implements ICompanyDao {

	public Object saveCompany(Company company) {
		return getSqlMapClientTemplate().insert("Company.save", company);

	}

	public List findByPage(Page page) {
		return getSqlMapClientTemplate().queryForList("Company.findByPage",
				page);

	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"Company.findByCount", page);

	}

	public Integer update(Company company) throws Exception {
		return getSqlMapClientTemplate().update("Company.update", company);

	}

	public Integer deleteById(Company company) {
		return getSqlMapClientTemplate().delete("Company.deleteById", company);

	}

	public List findByExample(Company company) {
		return getSqlMapClientTemplate().queryForList("Company.findByLocation",
				company);
	}

}
