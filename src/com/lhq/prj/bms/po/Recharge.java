package com.lhq.prj.bms.po;

import java.util.Date;

public class Recharge {
	// ��ֵ���
	private Integer rechargeId;
	// �û����
	private Long userId;
	// ��ֵ��ʽ
	private String method;
	// �˻�����
	private String accountName;
	// ��ֵ���
	private Float amount;
	// �Ա��������
	private String tbOrderId;
	// �ύʱ��
	private Date submitTime;
	// ����ʱ��
	private Date closeTime;
	// ״̬
	private String state;
	// ��ע
	private String note;

	public Integer getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(Integer rechargeId) {
		this.rechargeId = rechargeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTbOrderId() {
		return tbOrderId;
	}

	public void setTbOrderId(String tbOrderId) {
		this.tbOrderId = tbOrderId;
	}

}
