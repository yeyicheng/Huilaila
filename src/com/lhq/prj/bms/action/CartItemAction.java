/*
 * @(#)CartItemAction.java 2008-10-11
 * Download by http://www.codefans.net
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;

import com.lhq.prj.bms.po.CartItem;
import com.lhq.prj.bms.po.Commodity;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.service.ICartItemService;
import com.lhq.prj.bms.service.ICommodityService;

@SuppressWarnings("serial")
public class CartItemAction extends BaseAction {

	private ICartItemService cartItemService;

	private ICommodityService commodityService;

	private boolean success;

	private Page pageBean;

	private Integer page;

	private CartItem cartItem;

	public String saveCartItem() throws Exception {
		User user = (User) getSession().getAttribute("user");
		// cartItem.setLoanTime(new Date());
		cartItem.setTime(new Date());
		// cartItem.setLoannerId(user.getUserId());
		// cartItem.setLoanner(user.getEmplName());
		CartItem record = findExact();
		if (record != null) {
			int amount = record.getAmount() + cartItem.getAmount();
			Commodity commodity = new Commodity();
			commodity.setChannel(cartItem.getChannel());
			commodity.setNovid(cartItem.getNovid());
			commodity.setSizeone(cartItem.getSize());
			commodity = commodityService.findExact(commodity);
			if (amount > commodity.getNumbers()) {
				record.setAmount(commodity.getNumbers());
			} else {
				record.setAmount(record.getAmount() + cartItem.getAmount());
			}
			record.setTime(new Date());
			if (cartItemService.updateCartItem(record)) {
				success = true;
			}
		} else if (cartItemService.saveCartItem(cartItem) != null) {
			success = true;
		}
		return SUCCESS;
	}

	public CartItem findExact() {
		pageBean = new Page();
		CartItem cartItemFound = cartItemService.findExact(cartItem);
		return cartItemFound;
	}

	/**
	 * ɾ���¼
	 * 
	 * @return
	 */
	public String deleteCartItem() {
		String strSubjectId = getRequest().getParameter("ids");
		if (strSubjectId != null && !"".equals(strSubjectId)) {
			// success = subjectService.deleteSubject(strSubjectId);
			success = cartItemService.deleteCartItem(strSubjectId);
		}
		return SUCCESS;
	}

	/**
	 * ����ͼ��軹��¼
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findCartItemByBook() {
		String strSubjectId = getRequest().getParameter("subjectId");
		Commodity commodity = new Commodity();
		if (strSubjectId != null && !"".equals(strSubjectId)) {
			// book.setBookId(Integer.valueOf(strBookId));
			commodity.setSubjectId(Long.valueOf(strSubjectId));
		}
		pageBean = new Page();
		pageBean.setObjCondition(commodity);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		pageBean.setStart(++start);
		pageBean.setLimit(limit = limit == 0 ? 10 : limit);
		pageBean = cartItemService.findByPage(pageBean);
		return SUCCESS;
	}

	/**
	 * �޸Ľ軹��¼��Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateCartItem() throws Exception {
		success = cartItemService.updateCartItem(cartItem);
		return SUCCESS;
	}

	public String findbyUserId() throws Exception {
		User user = (User) getSession().getAttribute("user");
		if (user == null) {
			return ERROR;
		}
		pageBean = new Page();
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		pageBean.setStart(++start);
		pageBean.setUserId(user.getUserId());
		pageBean.setLimit(limit = limit == 0 ? 10 : limit);
		pageBean = cartItemService.findByPage(pageBean);
		return SUCCESS;
	}

	public Page getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page page) {
		this.pageBean = page;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setCartItemService(ICartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	public ICartItemService getCartItemService() {
		return cartItemService;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public ICommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(ICommodityService commodityService) {
		this.commodityService = commodityService;
	}

}
