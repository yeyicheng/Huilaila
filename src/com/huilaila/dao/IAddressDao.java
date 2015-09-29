package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.Address;

public interface IAddressDao {

	Long saveAddress(Address address);

	List findByExample(Address address);

	Object deleteById(Address address);

	Object update(Address address);

}
