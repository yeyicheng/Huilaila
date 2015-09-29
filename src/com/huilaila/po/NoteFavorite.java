package com.huilaila.po;

public class NoteFavorite {
	Long noteFavoriteId;
	Long userId;
	long noteId;

	public Long getNoteFavoriteId() {
		return noteFavoriteId;
	}

	public void setNoteFavoriteId(Long noteFavoriteId) {
		this.noteFavoriteId = noteFavoriteId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}
}
