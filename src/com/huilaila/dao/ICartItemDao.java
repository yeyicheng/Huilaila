package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.CartItem;

public interface ICartItemDao {

	Long saveCartItem(CartItem cartItem);

	Object deleteById(CartItem cartItem);

	Object update(CartItem cartItem);

	List findByExample(CartItem cartItem);

}
