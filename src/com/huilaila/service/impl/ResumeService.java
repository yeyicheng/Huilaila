package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IResumeDao;
import com.huilaila.po.Resume;
import com.huilaila.service.IResumeService;
import com.huilaila.core.Page;

public class ResumeService implements IResumeService {

	private IResumeDao resumeDao;
	
	public IResumeDao getResumeDao() {
		return resumeDao;
	}

	public void setResumeDao(IResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	public Object saveResume(Resume resume) {
		return resumeDao.saveResume(resume);
	}

	public Page findByPage(Page page) {
		page.setRoot(resumeDao.findByPage(page));
		page.setTotalProperty(resumeDao.findByCount(page));
		return page;
	}

	public boolean updateResume(Resume resume) throws Exception {
		return resumeDao.update(resume) != null;
	}

	public boolean deleteResume(Resume resume) {
		return resumeDao.deleteById(resume) != null;
	}

	public List findByExample(Resume resume) {
		return resumeDao.findByExample(resume);
	}

}
