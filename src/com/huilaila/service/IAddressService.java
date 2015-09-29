package com.huilaila.service;

import java.util.List;

import com.huilaila.po.Address;

public interface IAddressService {

	Long saveAddress(Address address);

//	Page findByPage(Page pageBean);

	List findByExample(Address address);

	boolean deleteAddress(Address address);

	boolean updateAddress(Address address);

}
