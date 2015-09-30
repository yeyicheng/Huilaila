package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.dao.ICartItemDao;
import com.huilaila.po.CartItem;
import com.huilaila.service.ICartItemService;

public class CartItemService implements ICartItemService {
	private ICartItemDao cartItemDao;

	public Long saveCartItem(CartItem cartItem) {
		return cartItemDao.saveCartItem(cartItem);
	}

	// public Page findByPage(Page pageBean) {
	// pageBean.setRoot(cartItemDao.findByPage(pageBean));
	// pageBean.setTotalProperty(cartItemDao.findByCount(pageBean));
	// return pageBean;
	// }

	public List findByExample(CartItem cartItem) {
		return cartItemDao.findByExample(cartItem);
	}

	public boolean deleteCartItem(CartItem cartItem) {
		return cartItemDao.deleteById(cartItem) != null;
	}

	public boolean updateCartItem(CartItem cartItem) {
		return cartItemDao.update(cartItem) != null;
	}

	public ICartItemDao getCartItemDao() {
		return cartItemDao;
	}

	public void setCartItemDao(ICartItemDao cartItemDao) {
		this.cartItemDao = cartItemDao;
	}
}
