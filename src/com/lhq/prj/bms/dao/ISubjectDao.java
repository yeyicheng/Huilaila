package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.po.Subject;

/**
 * ISubjectDao.java Create on 2008-9-18 ����08:16:37
 * 
 * ��Ʒ�־ò�ӿ�
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public interface ISubjectDao {

	/**
	 * ����һ����Ʒ�����ݿ�
	 * 
	 * @param subject
	 * @return
	 */
	public Object saveSubject(Subject subject);

	/**
	 * ����������Ʒ
	 * 
	 * @return
	 */
	public List findAll();

	/**
	 * �޸���Ʒ��Ϣ
	 * 
	 * @param subject
	 * @return
	 * @throws Exception
	 */
	public Integer update(Subject subject) throws Exception;

	/**
	 * ����idɾ����Ʒ
	 * 
	 * @param subjectId
	 * @return
	 */
	public Integer deleteById(Integer subjectId);
}
