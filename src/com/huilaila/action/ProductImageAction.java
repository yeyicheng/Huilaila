package com.huilaila.action;

import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.ProductImage;
import com.huilaila.service.IProductImageService;

@SuppressWarnings("serial")
public class ProductImageAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IProductImageService productImageService;

	private ProductImage productImage;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveProductImage() {
		System.out.println("===ProductImageAction.saveProductImage===");
		Long productImageId = (Long) productImageService.saveProductImage(productImage);
		success = productImageId != null;
		return SUCCESS;
	}

	// public String findAllProductImage() {
	// System.out.println("===ProductImageAction.findAllProductImage===");
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
	// pageBean = productImageService.findByPage(pageBean);
	// pageBean.setSuccess(pageBean.getRoot() != null);
	// return SUCCESS;
	// }

	public String findByExample() {
		System.out.println("===ProductImageAction.findByExample===");
		pageBean = new Page();
		List productImages = productImageService.findByExample(productImage);
		success = productImages != null;
		if (success) {
			pageBean.setRoot(productImages);
			pageBean.setTotalProperty(productImages.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteProductImage() {
		success = productImageService.deleteProductImage(productImage);
		return SUCCESS;
	}

	public String updateProductImage() {
		success = productImageService.updateProductImage(productImage);
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

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}

	public void setProductImageService(IProductImageService productImageService) {
		this.productImageService = productImageService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
