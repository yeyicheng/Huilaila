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
		Long companyId = (Long) companyService.saveCompany(company);
		return companyId != null ? SUCCESS : ERROR;
	}

	public String findAllCompany() {
		System.out.println("===");
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
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		pageBean.setStart(++start);
		pageBean.setLimit(limit = limit == 0 ? 20 : limit);
		pageBean = companyService.findByPage(pageBean);
		return SUCCESS;
	}

	public String findByExample() {
		pageBean = new Page();
		pageBean.setRoot(companyService.findByExample(company));
		return SUCCESS;
	}

	public String deleteCompany() {
		return companyService.deleteById(company) ? SUCCESS : ERROR;
	}

	public String updateCompany() throws Exception {
		Company currUser = (Company) getSession().getAttribute("currUser");
		if (currUser == null) {
			return ERROR;
		}
		if (company != null) {
			success = companyService.update(company);
		} else {
			success = false;
		}
		return success ? SUCCESS : ERROR;
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
