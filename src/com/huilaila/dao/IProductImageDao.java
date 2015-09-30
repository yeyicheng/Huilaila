package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.ProductImage;

public interface IProductImageDao {

	Long saveProductImage(ProductImage productImage);

	Object deleteById(ProductImage productImage);

	Object update(ProductImage productImage);

	List findByExample(ProductImage productImage);

}
