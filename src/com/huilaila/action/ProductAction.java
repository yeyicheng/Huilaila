package com.huilaila.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.huilaila.core.BaseAction;
import com.huilaila.core.Page;
import com.huilaila.po.Product;
import com.huilaila.service.IProductService;
import com.huilaila.utils.MyUtils;

@SuppressWarnings("serial")
public class ProductAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IProductService productService;

	private Product product;

	private boolean success;

	private Page pageBean;

	private String tip;

	public String saveProduct() {
		System.out.println("===ProductAction.saveProduct===");
		Long productId = (Long) productService.saveProduct(product);
		success = productId != null;
		return SUCCESS;
	}

	public String findAllProduct() {
		System.out.println("===ProductAction.findAllProduct===");
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
		pageBean = productService.findByPage(pageBean);
		pageBean.setSuccess(pageBean.getRoot() != null);
		return SUCCESS;
	}

	public String findByExample() {
		pageBean = new Page();
		List products = productService.findByExample(product);
		success = products != null;
		if (success) {
			pageBean.setRoot(products);
			pageBean.setTotalProperty(products.size());
			pageBean.setSuccess(true);
		}
		return SUCCESS;
	}

	public String deleteProduct() {
		success = productService.deleteProduct(product);
		return SUCCESS;
	}

	public String updateProduct() {
		success = productService.updateProduct(product);
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
