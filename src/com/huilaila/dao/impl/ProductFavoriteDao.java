package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IProductFavoriteDao;
import com.huilaila.po.ProductFavorite;

public class ProductFavoriteDao extends SqlMapClientDaoSupport implements
		IProductFavoriteDao {

	public Long saveProductFavorite(ProductFavorite productFavorite) {
		return (Long) getSqlMapClientTemplate().insert("ProductFavorite.save",
				productFavorite);
	}

	// public List findByPage(Page pageBean) {
	// return getSqlMapClientTemplate().queryForList("ProductFavorite.findByPage",
	// pageBean);
	// }

	// public int findByCount(Page pageBean) {
	// return (Integer) getSqlMapClientTemplate().queryForObject(
	// "ProductFavorite.findByCount", pageBean);
	// }

	// public Object update(ProductFavorite productFavorite) {
	// return getSqlMapClientTemplate().update("ProductFavorite.update",
	// productFavorite);
	// }

	public Object deleteById(ProductFavorite productFavorite) {
		return getSqlMapClientTemplate().delete("ProductFavorite.deleteById",
				productFavorite);
	}

	public List findByExample(ProductFavorite productFavorite) {
		return getSqlMapClientTemplate().queryForList("ProductFavorite.findByExample", productFavorite);
	}

}
