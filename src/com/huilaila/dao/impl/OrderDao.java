package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IOrderDao;
import com.huilaila.po.Order;

public class OrderDao extends SqlMapClientDaoSupport implements IOrderDao {

	public Long saveOrder(Order order) {
		return (Long) getSqlMapClientTemplate().insert("Order.save", order);
	}

	// public List findByPage(Page pageBean) {
	// return getSqlMapClientTemplate().queryForList("Order.findByPage",
	// pageBean);
	// }

	// public int findByCount(Page pageBean) {
	// return (Integer) getSqlMapClientTemplate().queryForObject(
	// "Order.findByCount", pageBean);
	// }

	// public Object update(Order order) {
	// return getSqlMapClientTemplate().update("Order.update", order);
	// }

	public Object deleteById(Order order) {
		return getSqlMapClientTemplate().delete("Order.deleteById", order);
	}

	public List findByExample(Order order) {
		return getSqlMapClientTemplate().queryForList("Order.findByExample",
				order);
	}

}
