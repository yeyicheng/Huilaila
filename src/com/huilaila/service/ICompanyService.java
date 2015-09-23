package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Company;
import com.huilaila.core.Page;

public interface ICompanyService {
	public Object saveCompany(Company company);

	public Page findByPage(Page page);

	public boolean update(Company company) throws Exception;

	public boolean deleteById(Company company);

	public List findByExample(Company company);
}
