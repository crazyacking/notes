package com.ht.entity;

import java.util.Date;

public class Favorite {
	private int favoriteId;
	private int bookId;
	private int customerId;
	private Date date;
	
	
	public Favorite() {
		super();
	}

	public Favorite(int favoriteId, int bookId, int customerId, Date date) {
		super();
		this.favoriteId = favoriteId;
		this.bookId = bookId;
		this.customerId = customerId;
		this.date = date;
	}
	
	public Favorite(int bookId, int customerId, Date date) {
		super();
		this.bookId = bookId;
		this.customerId = customerId;
		this.date = date;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
