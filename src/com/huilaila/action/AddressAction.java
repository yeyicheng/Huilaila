package com.huilaila.action;

import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Address;
import com.huilaila.service.IAddressService;

@SuppressWarnings("serial")
public class AddressAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IAddressService addressService;

	private Address address;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveAddress() {
		System.out.println("===AddressAction.saveAddress===");
		Long addressId = (Long) addressService.saveAddress(address);
		success = addressId != null;
		return SUCCESS;
	}

//	public String findAllAddress() {
//		System.out.println("===AddressAction.findAllAddress===");
//		String strCondition = getRequest().getParameter("conditions");
//		List<String> conditions = new ArrayList<String>();
//		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
//		List<String> utf8Condition = new ArrayList<String>();
//		for (String c : conditions) {
//			try {
//				utf8Condition
//						.add(new String(c.getBytes("iso-8859-1"), "utf-8"));
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//		pageBean = new Page();
//		pageBean.setConditions(utf8Condition);
//		String start = getRequest().getParameter("start");
//		String limit = getRequest().getParameter("limit");
//		int startInt = start != null ? Integer.valueOf(start) : 0;
//		int limitInt = limit != null ? Integer.valueOf(limit) : 10;
//		pageBean.setLimit(limitInt);
//		pageBean.setStart(startInt);
//		pageBean = addressService.findByPage(pageBean);
//		pageBean.setSuccess(pageBean.getRoot() != null);
//		return SUCCESS;
//	}

	public String findByExample() {
		pageBean = new Page();
		List addresss = addressService.findByExample(address);
		success = addresss != null;
		if (success) {
			pageBean.setRoot(addresss);
			pageBean.setTotalProperty(addresss.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteAddress() {
		success = addressService.deleteAddress(address);
		return SUCCESS;
	}

	public String updateAddress() {
		success = addressService.updateAddress(address);
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
