package com.huilaila.action;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.JobFavorite;
import com.huilaila.service.IJobFavoriteService;

@SuppressWarnings("serial")
public class JobFavoriteAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IJobFavoriteService jobFavoriteService;

	private JobFavorite jobFavorite;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveJobFavorite() {
		Long jobFavoriteId = (Long) jobFavoriteService
				.saveJobFavorite(jobFavorite);
		return jobFavoriteId != null ? SUCCESS : ERROR;
	}

	public String deleteJobFavorite() {
		return jobFavoriteService.deleteJobFavorite(jobFavorite) ? SUCCESS
				: ERROR;
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

}
