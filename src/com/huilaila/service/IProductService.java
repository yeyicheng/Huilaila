package com.huilaila.service;

import java.util.List;

import com.huilaila.core.Page;
import com.huilaila.po.Company;
import com.huilaila.po.Product;

public interface IProductService {

	Long saveProduct(Product product);

	Page findByPage(Page pageBean);

	List findByExample(Product product);

	boolean deleteProduct(Product product);

	boolean updateProduct(Product product);

}
