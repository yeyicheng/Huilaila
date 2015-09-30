package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.ICartItemDao;
import com.huilaila.po.CartItem;

public class CartItemDao extends SqlMapClientDaoSupport implements ICartItemDao {

	public Long saveCartItem(CartItem cartItem) {
		return (Long) getSqlMapClientTemplate().insert("CartItem.save", cartItem);
	}

	// public List findByPage(Page pageBean) {
	// return getSqlMapClientTemplate().queryForList("CartItem.findByPage",
	// pageBean);
	// }

	// public int findByCount(Page pageBean) {
	// return (Integer) getSqlMapClientTemplate().queryForObject(
	// "CartItem.findByCount", pageBean);
	// }

	public Object update(CartItem cartItem) {
		return getSqlMapClientTemplate().update("CartItem.update", cartItem);
	}

	public Object deleteById(CartItem cartItem) {
		return getSqlMapClientTemplate().delete("CartItem.deleteById", cartItem);
	}

	public List findByExample(CartItem cartItem) {
		return getSqlMapClientTemplate().queryForList("CartItem.findByExample",
				cartItem);
	}

}
