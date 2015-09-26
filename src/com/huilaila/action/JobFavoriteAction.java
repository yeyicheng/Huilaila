package com.huilaila.action;

import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.JobFavorite;
import com.huilaila.po.User;
import com.huilaila.service.IJobFavoriteService;

@SuppressWarnings("serial")
public class JobFavoriteAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IJobFavoriteService jobFavoriteService;

	private JobFavorite jobFavorite;

	private boolean success;

	private Page pageBean;

	private String tip;

	private User user;

	public String saveJobFavorite() {
		System.out.println("===JobFavoriteAction.saveJobFavorite===");
		Long jobFavoriteId = (Long) jobFavoriteService
				.saveJobFavorite(jobFavorite);
		success = jobFavoriteId != null;
		return SUCCESS;
	}

	public String deleteJobFavorite() {
		System.out.println("===JobFavoriteAction.saveJobFavorite===");
		success = jobFavoriteService.deleteJobFavorite(jobFavorite);
		return SUCCESS;
	}

	public String findByUser() {
		System.out.println("===JobFavoriteAction.findByUser===");
		pageBean = new Page();
		List jobs = jobFavoriteService.findByUser(user);
		if (jobs != null) {
			pageBean.setRoot(jobs);
			pageBean.setTotalProperty(jobs.size());
			pageBean.setSuccess(true);
		} else {
			pageBean.setSuccess(false);
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

	public JobFavorite getJobFavorite() {
		return jobFavorite;
	}

	public void setJobFavorite(JobFavorite jobFavorite) {
		this.jobFavorite = jobFavorite;
	}

	public void setJobFavoriteService(IJobFavoriteService jobFavoriteService) {
		this.jobFavoriteService = jobFavoriteService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
