package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IOrderItemDao;
import com.huilaila.po.OrderItem;
import com.huilaila.service.IOrderItemService;

public class OrderItemService implements IOrderItemService {
	private IOrderItemDao orderItemDao;
	
	public Long saveOrderItem(OrderItem orderItem) {
		return orderItemDao.saveOrderItem(orderItem);
	}

//	public Page findByPage(Page pageBean) {
//		pageBean.setRoot(orderItemDao.findByPage(pageBean));
//		pageBean.setTotalProperty(orderItemDao.findByCount(pageBean));
//		return pageBean;
//	}

	public List findByExample(OrderItem orderItem) {
		return orderItemDao.findByExample(orderItem);
	}

//	public boolean deleteOrderItem(OrderItem orderItem) {
//		return orderItemDao.deleteById(orderItem) != null;
//	}

	// public boolean updateOrderItem(OrderItem orderItem) {
	// return orderItemDao.update(orderItem) != null;
	// }

	public IOrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	public void setOrderItemDao(IOrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
}
