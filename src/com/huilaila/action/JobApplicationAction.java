package com.huilaila.action;

import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Job;
import com.huilaila.po.JobApplication;
import com.huilaila.po.User;
import com.huilaila.service.IJobApplicationService;

@SuppressWarnings("serial")
public class JobApplicationAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IJobApplicationService jobApplicationService;

	private JobApplication jobApplication;

	private boolean success;

	private Page pageBean;

	private String tip;

	private Job job;

	private User user;

	public String saveJobApplication() {
		System.out.println("===JobApplicationAction.saveJobApplication===");
		Long jobApplicationId = (Long) jobApplicationService
				.saveJobApplication(jobApplication);
		success = jobApplicationId != null;
		return SUCCESS;
	}

	public String findByJob() {
		System.out.println("===JobApplicationAction.findByExample===");
		pageBean = new Page();
		List applications = jobApplicationService.findByJob(job);
		if (applications != null) {
			pageBean.setRoot(applications);
			pageBean.setTotalProperty(applications.size());
			pageBean.setSuccess(true);
		} else {
			pageBean.setSuccess(false);
		}
		return SUCCESS;
	}
	
	public String findByUser() {
		System.out.println("===JobApplicationAction.findByExample===");
		pageBean = new Page();
		List applications = jobApplicationService.findByUser(user);
		if (applications != null) {
			pageBean.setRoot(applications);
			pageBean.setTotalProperty(applications.size());
			pageBean.setSuccess(true);
		} else {
			pageBean.setSuccess(false);
		}
		return SUCCESS;
	}

	public String deleteJobApplication() {
		System.out.println("===JobApplicationAction.deleteJobApplication===");
		success = jobApplicationService.deleteJobApplication(jobApplication);
		return SUCCESS;
	}

	public String updateJobApplication() throws Exception {
		System.out.println("===JobApplicationAction.updateJobApplication===");
		if (jobApplication != null) {
			success = jobApplicationService
					.updateJobApplication(jobApplication);
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
