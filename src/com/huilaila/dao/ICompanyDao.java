package com.huilaila.dao;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Company;

public interface ICompanyDao {
	public Object saveCompany(Company company);

	public List findByPage(Page page);

	public int findByCount(Page page);

	public Integer update(Company company) throws Exception;

	public Integer deleteById(Company company);

	public List findByExample(Company company);
}
