package com.huilaila.action;

import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.OrderItem;
import com.huilaila.service.IOrderItemService;

@SuppressWarnings("serial")
public class OrderItemAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IOrderItemService orderItemService;

	private OrderItem orderItem;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveOrderItem() {
		System.out.println("===OrderItemAction.saveOrderItem===");
		Long orderItemId = (Long) orderItemService.saveOrderItem(orderItem);
		success = orderItemId != null;
		return SUCCESS;
	}

	// public String findAllOrderItem() {
	// System.out.println("===OrderItemAction.findAllOrderItem===");
	// String strCondition = getRequest().getParameter("conditions");
	// List<String> conditions = new ArrayList<String>();
	// MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
	// List<String> utf8Condition = new ArrayList<String>();
	// for (String c : conditions) {
	// try {
	// utf8Condition
	// .add(new String(c.getBytes("iso-8859-1"), "utf-8"));
	// } catch (UnsupportedEncodingException e) {
	// e.printStackTrace();
	// }
	// }
	// pageBean = new Page();
	// pageBean.setConditions(utf8Condition);
	// String start = getRequest().getParameter("start");
	// String limit = getRequest().getParameter("limit");
	// int startInt = start != null ? Integer.valueOf(start) : 0;
	// int limitInt = limit != null ? Integer.valueOf(limit) : 10;
	// pageBean.setLimit(limitInt);
	// pageBean.setStart(startInt);
	// pageBean = orderItemService.findByPage(pageBean);
	// pageBean.setSuccess(pageBean.getRoot() != null);
	// return SUCCESS;
	// }

	public String findByExample() {
		System.out.println("===OrderItemAction.findByExample===");
		pageBean = new Page();
		List orderItems = orderItemService.findByExample(orderItem);
		success = orderItems != null;
		if (success) {
			pageBean.setRoot(orderItems);
			pageBean.setTotalProperty(orderItems.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

//	public String deleteOrderItem() {
//		success = orderItemService.deleteOrderItem(orderItem);
//		return SUCCESS;
//	}
//
//	public String updateOrderItem() {
//		success = orderItemService.updateOrderItem(orderItem);
//		return SUCCESS;
//	}

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

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public void setOrderItemService(IOrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
