package com.huilaila.dao;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Product;

public interface IProductDao {

	Long saveProduct(Product product);

	List findByPage(Page pageBean);

	int findByCount(Page pageBean);

	Object update(Product product);

	Object deleteById(Product product);

	List findByExample(Product product);

}
