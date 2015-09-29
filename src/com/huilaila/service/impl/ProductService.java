package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.dao.IProductDao;
import com.huilaila.po.Company;
import com.huilaila.po.Product;
import com.huilaila.service.IProductService;

public class ProductService implements IProductService {
	private IProductDao productDao;
	
	public Long saveProduct(Product product) {
		return productDao.saveProduct(product);
	}

	public Page findByPage(Page pageBean) {
		pageBean.setRoot(productDao.findByPage(pageBean));
		pageBean.setTotalProperty(productDao.findByCount(pageBean));
		return pageBean;
	}

	public List findByExample(Product product) {
		return productDao.findByExample(product);
	}

	public boolean deleteProduct(Product product) {
		return productDao.deleteById(product) != null;
	}

	public boolean updateProduct(Product product) {
		return productDao.update(product) != null;
	}

	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}
}
