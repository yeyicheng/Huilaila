package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.dao.IShopDao;
import com.huilaila.po.Shop;
import com.huilaila.service.IShopService;

public class ShopService implements IShopService {
	private IShopDao shopDao;
	
	public Long saveShop(Shop shop) {
		return shopDao.saveShop(shop);
	}

	public Page findByPage(Page pageBean) {
		pageBean.setRoot(shopDao.findByPage(pageBean));
		pageBean.setTotalProperty(shopDao.findByCount(pageBean));
		return pageBean;
	}

	public List findByExample(Shop shop) {
		return shopDao.findByExample(shop);
	}

	public boolean deleteShop(Shop shop) {
		return shopDao.deleteById(shop) != null;
	}

	public boolean updateShop(Shop shop) {
		return shopDao.update(shop) != null;
	}

	public IShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(IShopDao shopDao) {
		this.shopDao = shopDao;
	}
}
