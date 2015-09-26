package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Company;
import com.huilaila.po.Job;
import com.huilaila.service.IJobService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class JobAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IJobService jobService;

	private Job job;

	private Company company;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveJob() {
		System.out.println("===JobAction.saveJob===");
		Long jobId = (Long) jobService.saveJob(job);
		success = jobId != null;
		return SUCCESS;
	}

	public String findAllJob() {
		System.out.println("===JobAction.findAllJob===");
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
		int startInt = start != null ? Integer.valueOf(start) : 0;
		int limitInt = limit != null ? Integer.valueOf(limit) : 10;
		pageBean.setLimit(limitInt);
		pageBean.setStart(startInt);
		pageBean = jobService.findByPage(pageBean);
		pageBean.setSuccess(pageBean.getRoot() != null);
		return SUCCESS;
	}

	public String findByExample() {
		pageBean = new Page();
		List jobs = jobService.findByExample(job);
		success = jobs != null;
		if (success) {
			pageBean.setRoot(jobs);
			pageBean.setTotalProperty(jobs.size());
		}
		return SUCCESS;
	}

	public String deleteJob() {
		success = jobService.deleteJob(job);
		return SUCCESS;
	}

	public String updateJob() throws Exception {
		success = jobService.updateJob(job);
		return SUCCESS;
	}

	public String findByCompany() {
		pageBean = new Page();
		List jobs = jobService.findByCompany(company);
		if (jobs != null) {
			success = true;
			pageBean.setRoot(jobs);
			pageBean.setTotalProperty(jobs.size());
			pageBean.setSuccess(true);
		} else {
			success = false;
			pageBean.setSuccess(false);
		}
		return SUCCESS;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setJobService(IJobService jobService) {
		this.jobService = jobService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
