package com.huilaila.action;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.JobApplication;
import com.huilaila.service.IJobApplicationService;

@SuppressWarnings("serial")
public class JobApplicationAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IJobApplicationService jobApplicationService;

	private JobApplication jobApplication;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveJobApplication() {
		Long jobApplicationId = (Long) jobApplicationService
				.saveJobApplication(jobApplication);
		return jobApplicationId != null ? SUCCESS : ERROR;
	}

	public String findByExample() {
		pageBean = new Page();
		pageBean.setRoot(jobApplicationService.findByExample(jobApplication));
		return SUCCESS;
	}

	public String deleteJobApplication() {
		return jobApplicationService.deleteJobApplication(jobApplication) ? SUCCESS
				: ERROR;
	}

	public String updateJobApplication() throws Exception {
		JobApplication currUser = (JobApplication) getSession().getAttribute(
				"currUser");
		if (currUser == null) {
			return ERROR;
		}
		if (jobApplication != null) {
			success = jobApplicationService
					.updateJobApplication(jobApplication);
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

	public JobApplication getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}

	public void setJobApplicationService(
			IJobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
