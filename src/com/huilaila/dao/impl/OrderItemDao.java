package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IOrderItemDao;
import com.huilaila.po.OrderItem;

public class OrderItemDao extends SqlMapClientDaoSupport implements
		IOrderItemDao {

	public Long saveOrderItem(OrderItem orderItem) {
		return (Long) getSqlMapClientTemplate().insert("OrderItem.save",
				orderItem);
	}

	// public List findByPage(Page pageBean) {
	// return getSqlMapClientTemplate().queryForList("OrderItem.findByPage",
	// pageBean);
	// }

	// public int findByCount(Page pageBean) {
	// return (Integer) getSqlMapClientTemplate().queryForObject(
	// "OrderItem.findByCount", pageBean);
	// }

	// public Object update(OrderItem orderItem) {
	// return getSqlMapClientTemplate().update("OrderItem.update", orderItem);
	// }

	// public Object deleteById(OrderItem orderItem) {
	// return getSqlMapClientTemplate().delete("OrderItem.deleteById",
	// orderItem);
	// }

	public List findByExample(OrderItem orderItem) {
		return getSqlMapClientTemplate().queryForList("OrderItem.findByExample", orderItem);
	}

}
