package com.huilaila.service;

import java.util.List;

import com.huilaila.po.ProductFavorite;

public interface IProductFavoriteService {

	Long saveProductFavorite(ProductFavorite productFavorite);

	List findByExample(ProductFavorite productFavorite);

	boolean deleteProductFavorite(ProductFavorite productFavorite);

}
