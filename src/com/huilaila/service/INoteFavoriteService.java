package com.huilaila.service;

import com.huilaila.po.NoteFavorite;

public interface INoteFavoriteService {

	public Long saveNoteFavorite(NoteFavorite noteFavorite);

	public boolean deleteNoteFavorite(NoteFavorite noteFavorite);
}
