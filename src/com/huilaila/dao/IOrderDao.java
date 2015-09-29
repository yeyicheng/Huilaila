package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.Order;

public interface IOrderDao {

	Long saveOrder(Order order);

	List findByExample(Order order);

	Object deleteById(Order order);

}
