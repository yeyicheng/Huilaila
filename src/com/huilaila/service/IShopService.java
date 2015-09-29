package com.huilaila.service;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Shop;

public interface IShopService {

	Long saveShop(Shop shop);

	Page findByPage(Page pageBean);

	List findByExample(Shop shop);

	boolean deleteShop(Shop shop);

	boolean updateShop(Shop shop);

}
