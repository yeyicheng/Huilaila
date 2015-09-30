package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IProductFavoriteDao;
import com.huilaila.po.ProductFavorite;
import com.huilaila.service.IProductFavoriteService;

public class ProductFavoriteService implements IProductFavoriteService {
	private IProductFavoriteDao productFavoriteDao;
	
	public Long saveProductFavorite(ProductFavorite productFavorite) {
		return productFavoriteDao.saveProductFavorite(productFavorite);
	}

//	public Page findByPage(Page pageBean) {
//		pageBean.setRoot(productFavoriteDao.findByPage(pageBean));
//		pageBean.setTotalProperty(productFavoriteDao.findByCount(pageBean));
//		return pageBean;
//	}

	public List findByExample(ProductFavorite productFavorite) {
		return productFavoriteDao.findByExample(productFavorite);
	}

	public boolean deleteProductFavorite(ProductFavorite productFavorite) {
		return productFavoriteDao.deleteById(productFavorite) != null;
	}

//	 public boolean updateProductFavorite(ProductFavorite productFavorite) {
//	 return productFavoriteDao.update(productFavorite) != null;
//	 }

	public IProductFavoriteDao getProductFavoriteDao() {
		return productFavoriteDao;
	}

	public void setProductFavoriteDao(IProductFavoriteDao productFavoriteDao) {
		this.productFavoriteDao = productFavoriteDao;
	}
}
