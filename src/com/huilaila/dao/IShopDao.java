package com.huilaila.dao;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Shop;

public interface IShopDao {

	Long saveShop(Shop shop);

	List findByPage(Page pageBean);

	int findByCount(Page pageBean);

	List findByExample(Shop shop);

	Object deleteById(Shop shop);

	Object update(Shop shop);

}
