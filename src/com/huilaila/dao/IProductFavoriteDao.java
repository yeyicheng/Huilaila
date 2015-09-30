package com.huilaila.dao;

import java.util.List;

import com.huilaila.po.ProductFavorite;

public interface IProductFavoriteDao {

	Long saveProductFavorite(ProductFavorite productFavorite);

	List findByExample(ProductFavorite productFavorite);

	Object deleteById(ProductFavorite productFavorite);

}
