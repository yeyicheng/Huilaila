package com.huilaila.dao;

import com.huilaila.po.NoteFavorite;

public interface INoteFavoriteDao {

	Long saveNoteFavorite(NoteFavorite noteFavorite);

	Object deleteById(NoteFavorite noteFavorite);

}
