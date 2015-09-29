package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.IOrderDao;
import com.huilaila.po.Order;
import com.huilaila.service.IOrderService;

public class OrderService implements IOrderService {
	private IOrderDao orderDao;
	
	public Long saveOrder(Order order) {
		return orderDao.saveOrder(order);
	}

//	public Page findByPage(Page pageBean) {
//		pageBean.setRoot(orderDao.findByPage(pageBean));
//		pageBean.setTotalProperty(orderDao.findByCount(pageBean));
//		return pageBean;
//	}

	public List findByExample(Order order) {
		return orderDao.findByExample(order);
	}

	public boolean deleteOrder(Order order) {
		return orderDao.deleteById(order) != null;
	}

	// public boolean updateOrder(Order order) {
	// return orderDao.update(order) != null;
	// }

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
