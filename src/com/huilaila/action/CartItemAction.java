package com.huilaila.action;

import java.util.Date;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.CartItem;
import com.huilaila.service.ICartItemService;

@SuppressWarnings("serial")
public class CartItemAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private ICartItemService cartItemService;

	private CartItem cartItem;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveCartItem() {
		System.out.println("===CartItemAction.saveCartItem===");
		Long cartItemId = (Long) cartItemService.saveCartItem(cartItem);
		success = cartItemId != null;
		return SUCCESS;
	}

	// public String findAllCartItem() {
	// System.out.println("===CartItemAction.findAllCartItem===");
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
	// pageBean = cartItemService.findByPage(pageBean);
	// pageBean.setSuccess(pageBean.getRoot() != null);
	// return SUCCESS;
	// }

	public String findByExample() {
		pageBean = new Page();
		List cartItems = cartItemService.findByExample(cartItem);
		success = cartItems != null;
		if (success) {
			pageBean.setRoot(cartItems);
			pageBean.setTotalProperty(cartItems.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteCartItem() {
		success = cartItemService.deleteCartItem(cartItem);
		return SUCCESS;
	}

	public String updateCartItem() {
		success = cartItemService.updateCartItem(cartItem);
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

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public void setCartItemService(ICartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
