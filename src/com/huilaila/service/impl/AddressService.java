package com.huilaila.service.impl;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.dao.IAddressDao;
import com.huilaila.po.Address;
import com.huilaila.service.IAddressService;

public class AddressService implements IAddressService {
	private IAddressDao addressDao;
	
	public Long saveAddress(Address address) {
		return addressDao.saveAddress(address);
	}

//	public Page findByPage(Page pageBean) {
//		pageBean.setRoot(addressDao.findByPage(pageBean));
//		pageBean.setTotalProperty(addressDao.findByCount(pageBean));
//		return pageBean;
//	}

	public List findByExample(Address address) {
		return addressDao.findByExample(address);
	}

	public boolean deleteAddress(Address address) {
		return addressDao.deleteById(address) != null;
	}

	public boolean updateAddress(Address address) {
		return addressDao.update(address) != null;
	}

	public IAddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}
}
