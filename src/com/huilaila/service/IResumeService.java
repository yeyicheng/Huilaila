package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Resume;
import com.huilaila.core.Page;

public interface IResumeService {
	public Object saveResume(Resume resume);

	public Page findByPage(Page page);

	public boolean updateResume(Resume resume) throws Exception;

	public boolean deleteResume(Resume resume);

	public List findByExample(Resume resume);

}
