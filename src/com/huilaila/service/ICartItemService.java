package com.huilaila.service;

import java.util.List;

import com.huilaila.po.CartItem;

public interface ICartItemService {

	Long saveCartItem(CartItem cartItem);

	boolean deleteCartItem(CartItem cartItem);

	boolean updateCartItem(CartItem cartItem);

	List findByExample(CartItem cartItem);

}
