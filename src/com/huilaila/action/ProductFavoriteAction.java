package com.huilaila.action;

import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.ProductFavorite;
import com.huilaila.service.IProductFavoriteService;

@SuppressWarnings("serial")
public class ProductFavoriteAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IProductFavoriteService productFavoriteService;

	private ProductFavorite productFavorite;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveProductFavorite() {
		System.out.println("===ProductFavoriteAction.saveProductFavorite===");
		Long productFavoriteId = (Long) productFavoriteService.saveProductFavorite(productFavorite);
		success = productFavoriteId != null;
		return SUCCESS;
	}

	// public String findAllProductFavorite() {
	// System.out.println("===ProductFavoriteAction.findAllProductFavorite===");
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
	// pageBean = productFavoriteService.findByPage(pageBean);
	// pageBean.setSuccess(pageBean.getRoot() != null);
	// return SUCCESS;
	// }

	public String findByExample() {
		System.out.println("===ProductFavoriteAction.findByExample===");
		pageBean = new Page();
		List productFavorites = productFavoriteService.findByExample(productFavorite);
		success = productFavorites != null;
		if (success) {
			pageBean.setRoot(productFavorites);
			pageBean.setTotalProperty(productFavorites.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteProductFavorite() {
		success = productFavoriteService.deleteProductFavorite(productFavorite);
		return SUCCESS;
	}

//	public String updateProductFavorite() {
//		success = productFavoriteService.updateProductFavorite(productFavorite);
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

	public ProductFavorite getProductFavorite() {
		return productFavorite;
	}

	public void setProductFavorite(ProductFavorite productFavorite) {
		this.productFavorite = productFavorite;
	}

	public void setProductFavoriteService(IProductFavoriteService productFavoriteService) {
		this.productFavoriteService = productFavoriteService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
