package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.core.Page;
import com.huilaila.dao.IShopDao;
import com.huilaila.po.Shop;

public class ShopDao extends SqlMapClientDaoSupport implements IShopDao {

	public Long saveShop(Shop shop) {
		return (Long) getSqlMapClientTemplate().insert("Shop.save", shop);
	}

	public List findByPage(Page pageBean) {
		return getSqlMapClientTemplate().queryForList("Shop.findByPage",
				pageBean);
	}

	public int findByCount(Page pageBean) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"Shop.findByCount", pageBean);
	}

	public Object update(Shop shop) {
		return getSqlMapClientTemplate().update("Shop.update", shop);
	}

	public Object deleteById(Shop shop) {
		return getSqlMapClientTemplate().delete("Shop.deleteById", shop);
	}

	public List findByExample(Shop shop) {
		return getSqlMapClientTemplate().queryForList("Shop.findByExample",
				shop);
	}

}
