package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.OrderItem;

public interface IOrderItemDao {

	Long saveOrderItem(OrderItem orderItem);

	List findByExample(OrderItem orderItem);

}
