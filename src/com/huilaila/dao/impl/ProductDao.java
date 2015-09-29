package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.core.Page;
import com.huilaila.dao.IProductDao;
import com.huilaila.po.Product;

public class ProductDao extends SqlMapClientDaoSupport implements IProductDao {

	public Long saveProduct(Product product) {
		return (Long) getSqlMapClientTemplate().insert("Product.save", product);
	}

	public List findByPage(Page pageBean) {
		return getSqlMapClientTemplate().queryForList("Product.findByPage",
				pageBean);
	}

	public int findByCount(Page pageBean) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"Product.findByCount", pageBean);
	}

	public Object update(Product product) {
		return getSqlMapClientTemplate().update("Product.update", product);
	}

	public Object deleteById(Product product) {
		return getSqlMapClientTemplate().delete("Product.deleteById", product);
	}

	public List findByExample(Product product) {
		return getSqlMapClientTemplate().queryForList("Product.findByExample", product);
	}

}
