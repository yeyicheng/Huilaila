package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IProductImageDao;
import com.huilaila.po.ProductImage;

public class ProductImageDao extends SqlMapClientDaoSupport implements
		IProductImageDao {

	public Long saveProductImage(ProductImage productImage) {
		return (Long) getSqlMapClientTemplate().insert("ProductImage.save",
				productImage);
	}

	// public List findByPage(Page pageBean) {
	// return getSqlMapClientTemplate().queryForList("ProductImage.findByPage",
	// pageBean);
	// }

	// public int findByCount(Page pageBean) {
	// return (Integer) getSqlMapClientTemplate().queryForObject(
	// "ProductImage.findByCount", pageBean);
	// }

	 public Object update(ProductImage productImage) {
		 return getSqlMapClientTemplate().update("ProductImage.update", productImage);
	 }

	public Object deleteById(ProductImage productImage) {
		return getSqlMapClientTemplate().delete("ProductImage.deleteById",
				productImage);
	}

	public List findByExample(ProductImage productImage) {
		return getSqlMapClientTemplate().queryForList("ProductImage.findByExample", productImage);
	}

}
