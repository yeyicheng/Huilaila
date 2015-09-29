package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Order;

public interface IOrderService {

	Long saveOrder(Order order);

	List findByExample(Order order);

	boolean deleteOrder(Order order);

}
