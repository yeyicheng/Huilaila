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
		Long resumeId = (Long) resumeService.saveResume(resume);
		return resumeId != null ? SUCCESS : ERROR;
	}

	public String findAllResume() {
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
		pageBean = resumeService.findByPage(pageBean);
		return SUCCESS;
	}

	public String findByExample() {
		pageBean = new Page();
		pageBean.setRoot(resumeService.findByExample(resume));
		return SUCCESS;
	}

	public String deleteResume() {
		return resumeService.deleteResume(resume) ? SUCCESS : ERROR;
	}

	public String updateResume() throws Exception {
		Resume currUser = (Resume) getSession().getAttribute("currUser");
		if (currUser == null) {
			return ERROR;
		}
		if (resume != null) {
			success = resumeService.updateResume(resume);
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
