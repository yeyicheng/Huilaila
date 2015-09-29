package com.huilaila.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huilaila.dao.IAddressDao;
import com.huilaila.po.Address;

public class AddressDao extends SqlMapClientDaoSupport implements IAddressDao {

	public Long saveAddress(Address address) {
		return (Long) getSqlMapClientTemplate().insert("Address.save", address);
	}

	// public List findByPage(Page pageBean) {
	// return getSqlMapClientTemplate().queryForList("Address.findByPage",
	// pageBean);
	// }

	// public int findByCount(Page pageBean) {
	// return (Integer) getSqlMapClientTemplate().queryForObject(
	// "Address.findByCount", pageBean);
	// }

	public Object update(Address address) {
		return getSqlMapClientTemplate().update("Address.update", address);
	}

	public Object deleteById(Address address) {
		return getSqlMapClientTemplate().delete("Address.deleteById", address);
	}

	public List findByExample(Address address) {
		return getSqlMapClientTemplate().queryForList("Address.findByExample",
				address);
	}

}
