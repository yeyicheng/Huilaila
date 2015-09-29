package com.huilaila.action;

import java.util.Date;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Order;
import com.huilaila.service.IOrderService;

@SuppressWarnings("serial")
public class OrderAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IOrderService orderService;

	private Order order;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveOrder() {
		System.out.println("===OrderAction.saveOrder===");
		order.setOrderTime(new Date());
		Long orderId = (Long) orderService.saveOrder(order);
		success = orderId != null;
		return SUCCESS;
	}

//	public String findAllOrder() {
//		System.out.println("===OrderAction.findAllOrder===");
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
//		pageBean = orderService.findByPage(pageBean);
//		pageBean.setSuccess(pageBean.getRoot() != null);
//		return SUCCESS;
//	}

	public String findByExample() {
		pageBean = new Page();
		List orders = orderService.findByExample(order);
		success = orders != null;
		if (success) {
			pageBean.setRoot(orders);
			pageBean.setTotalProperty(orders.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteOrder() {
		success = orderService.deleteOrder(order);
		return SUCCESS;
	}

	// public String updateOrder() {
	// success = orderService.updateOrder(order);
	// return SUCCESS;
	// }

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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
