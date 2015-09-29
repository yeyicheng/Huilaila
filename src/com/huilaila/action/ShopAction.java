package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Shop;
import com.huilaila.service.IShopService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class ShopAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IShopService shopService;

	private Shop shop;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveShop() {
		System.out.println("===ShopAction.saveShop===");
		Long shopId = (Long) shopService.saveShop(shop);
		success = shopId != null;
		return SUCCESS;
	}

	public String findAllShop() {
		System.out.println("===ShopAction.findAllShop===");
		String strCondition = getRequest().getParameter("conditions");
		List<String> conditions = new ArrayList<String>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		List<String> utf8Condition = new ArrayList<String>();
		for (String c : conditions) {
			try {
				utf8Condition
						.add(new String(c.getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		pageBean = new Page();
		pageBean.setConditions(utf8Condition);
		String start = getRequest().getParameter("start");
		String limit = getRequest().getParameter("limit");
		int startInt = start != null ? Integer.valueOf(start) : 0;
		int limitInt = limit != null ? Integer.valueOf(limit) : 10;
		pageBean.setLimit(limitInt);
		pageBean.setStart(startInt);
		pageBean = shopService.findByPage(pageBean);
		pageBean.setSuccess(pageBean.getRoot() != null);
		return SUCCESS;
	}

	public String findByExample() {
		pageBean = new Page();
		List shops = shopService.findByExample(shop);
		success = shops != null;
		if (success) {
			pageBean.setRoot(shops);
			pageBean.setTotalProperty(shops.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteShop() {
		success = shopService.deleteShop(shop);
		return SUCCESS;
	}

	public String updateShop() {
		success = shopService.updateShop(shop);
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

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
