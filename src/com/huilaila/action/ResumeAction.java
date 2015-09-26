package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Resume;
import com.huilaila.service.IResumeService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class ResumeAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IResumeService resumeService;

	private Resume resume;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveResume() {
		System.out.println("===ResumeAction.saveResume===");
		Long resumeId = (Long) resumeService.saveResume(resume);
		success = resumeId != null;
		return SUCCESS;
	}

	public String findAllResume() {
		System.out.println("===ResumeAction.findAllResume===");
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
		pageBean = resumeService.findByPage(pageBean);
		pageBean.setSuccess(true);
		return SUCCESS;
	}

	public String findByExample() {
		System.out.println("===ResumeAction.findByExample===");
		pageBean = new Page();
		List resumes = resumeService.findByExample(resume);
		if (resumes != null) {
			pageBean.setRoot(resumes);
			pageBean.setTotalProperty(resumes.size());
			pageBean.setSuccess(true);
		} else {
			pageBean.setSuccess(false);
		}
		return SUCCESS;
	}

	public String deleteResume() {
		System.out.println("===ResumeAction.deleteResume===");
		success = resumeService.deleteResume(resume);
		return SUCCESS;
	}

	public String updateResume() throws Exception {
		System.out.println("===ResumeAction.updateResume===");
		if (resume != null) {
			success = resumeService.updateResume(resume);
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

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public void setResumeService(IResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
