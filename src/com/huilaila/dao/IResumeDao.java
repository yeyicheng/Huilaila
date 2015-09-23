package com.huilaila.dao;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Resume;

public interface IResumeDao {
	public Object saveResume(Resume resume);

	public List findByPage(Page page);

	public int findByCount(Page page);

	public Integer update(Resume resume) throws Exception;

	public Integer deleteById(Resume resume);

	public List findByExample(Resume resume);
}
