package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Job;
import com.huilaila.service.IJobService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class JobAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IJobService jobService;

	private Job job;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveJob() {
		Long jobId = (Long) jobService.saveJob(job);
		return jobId != null ? SUCCESS : ERROR;
	}

	public String findAllJob() {
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
		pageBean = jobService.findByPage(pageBean);
		return SUCCESS;
	}

	public String findByExample() {
		pageBean = new Page();
		pageBean.setRoot(jobService.findByExample(job));
		return SUCCESS;
	}

	public String deleteJob() {
		return jobService.deleteJob(job) ? SUCCESS : ERROR;
	}

	public String updateJob() throws Exception {
		Job currUser = (Job) getSession().getAttribute("currUser");
		if (currUser == null) {
			return ERROR;
		}
		if (job != null) {
			success = jobService.updateJob(job);
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
