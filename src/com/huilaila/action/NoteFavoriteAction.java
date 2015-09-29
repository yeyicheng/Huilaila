package com.huilaila.action;

import com.huilaila.core.BaseAction;
import com.huilaila.po.NoteFavorite;
import com.huilaila.service.INoteFavoriteService;

@SuppressWarnings("serial")
public class NoteFavoriteAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private INoteFavoriteService noteFavoriteService;

	private NoteFavorite noteFavorite;

	private boolean success;

	private String tip;

	public String saveNoteFavorite() {
		Long noteFavoriteId = (Long) noteFavoriteService.saveNoteFavorite(noteFavorite);
		success = noteFavoriteId != null;
		return SUCCESS;
	}

	public String deleteNoteFavorite() {
		success = noteFavoriteService.deleteNoteFavorite(noteFavorite);
		return SUCCESS;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public NoteFavorite getNoteFavorite() {
		return noteFavorite;
	}

	public void setNoteFavorite(NoteFavorite noteFavorite) {
		this.noteFavorite = noteFavorite;
	}

	public void setNoteFavoriteService(INoteFavoriteService noteFavoriteService) {
		this.noteFavoriteService = noteFavoriteService;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
