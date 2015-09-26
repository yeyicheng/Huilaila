package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Company;
import com.huilaila.service.ICompanyService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class CompanyAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private ICompanyService companyService;

	private Company company;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveCompany() {
		System.out.println("===CompanyAction.saveCompany===");
		Long companyId = (Long) companyService.saveCompany(company);
		success = companyId != null;
		return SUCCESS;
	}

	public String findAllCompany() {
		System.out.println("===CompanyAction.findAllCompany===");
		String strCondition = getRequest().getParameter("conditions");
		List<String> conditions = new ArrayList<String>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		List<String> utf8Condition = new ArrayList<String>();
		for (String c : conditions) {
			try {
				utf8Condition
						.add(new String(c.getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		pageBean = new Page();
		pageBean.setConditions(utf8Condition);
		String start = getRequest().getParameter("start");
		String limit = getRequest().getParameter("limit");
		int startInt = start != null ? Integer.parseInt(start) : 0;
		int limitInt = limit != null ? Integer.parseInt(limit) : 10;
		pageBean.setStart(startInt);
		pageBean.setLimit(limitInt);
		pageBean = companyService.findByPage(pageBean);
		pageBean.setSuccess(true);
		return SUCCESS;
	}

	public String findByExample() {
		System.out.println("===CompanyAction.findByExample===");
		pageBean = new Page();
		List companys = companyService.findByExample(company);
		if (companys != null) {
			pageBean.setRoot(companys);
			pageBean.setTotalProperty(companys.size());
			pageBean.setSuccess(true);
			success = true;
		}
		return SUCCESS;
	}

	public String deleteCompany() {
		System.out.println("===CompanyAction.deleteCompany===");
		success = companyService.deleteById(company);
		return SUCCESS;
	}

	public String updateCompany() throws Exception {
		if (company != null) {
			success = companyService.update(company);
		} else {
			success = false;
		}
		return SUCCESS;
	}

	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page page) {
		this.pageBean = page;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
