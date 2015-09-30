package com.huilaila.service;

import java.util.List;

import com.huilaila.po.OrderItem;

public interface IOrderItemService {

	Long saveOrderItem(OrderItem orderItem);

	List findByExample(OrderItem orderItem);

}
