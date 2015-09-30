package com.huilaila.service;

import java.util.List;

import com.huilaila.po.ProductImage;

public interface IProductImageService {

	Long saveProductImage(ProductImage productImage);

	List findByExample(ProductImage productImage);

	boolean deleteProductImage(ProductImage productImage);

	boolean updateProductImage(ProductImage productImage);

}
