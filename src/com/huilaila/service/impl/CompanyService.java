package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.ICompanyDao;
import com.huilaila.po.Company;
import com.huilaila.service.ICompanyService;
import com.huilaila.core.Page;

public class CompanyService implements ICompanyService {

	private ICompanyDao companyDao;
	
	public ICompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(ICompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public Object saveCompany(Company company) {
		return companyDao.saveCompany(company);
	}

	public Page findByPage(Page page) {
		page.setRoot(companyDao.findByPage(page));
		page.setTotalProperty(companyDao.findByCount(page));
		return page;
	}

	public boolean update(Company company) throws Exception {
		return companyDao.update(company) != null;
	}

	public boolean deleteById(Company company) {
		return companyDao.deleteById(company) != null;
	}

	public List findByExample(Company company) {
		return companyDao.findByExample(company);
	}
}
