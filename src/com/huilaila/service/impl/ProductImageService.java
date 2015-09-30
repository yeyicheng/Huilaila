package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IProductImageDao;
import com.huilaila.po.ProductImage;
import com.huilaila.service.IProductImageService;

public class ProductImageService implements IProductImageService {
	private IProductImageDao productImageDao;
	
	public Long saveProductImage(ProductImage productImage) {
		return productImageDao.saveProductImage(productImage);
	}

//	public Page findByPage(Page pageBean) {
//		pageBean.setRoot(productImageDao.findByPage(pageBean));
//		pageBean.setTotalProperty(productImageDao.findByCount(pageBean));
//		return pageBean;
//	}

	public List findByExample(ProductImage productImage) {
		return productImageDao.findByExample(productImage);
	}

	public boolean deleteProductImage(ProductImage productImage) {
		return productImageDao.deleteById(productImage) != null;
	}

	 public boolean updateProductImage(ProductImage productImage) {
	 return productImageDao.update(productImage) != null;
	 }

	public IProductImageDao getProductImageDao() {
		return productImageDao;
	}

	public void setProductImageDao(IProductImageDao productImageDao) {
		this.productImageDao = productImageDao;
	}
}
