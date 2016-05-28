package com.ht.entity;

public class BookStock {
	private int stockId;
	private int bookId;
	private int bookCount;
	private int minNum;

	public BookStock() {
		super();
	}

	public BookStock(int bookId, int bookCount, int minNum) {
		super();
		this.bookId = bookId;
		this.bookCount = bookCount;
		this.minNum = minNum;
	}

	public BookStock(int stockId, int bookId, int bookCount, int minNum) {
		super();
		this.stockId = stockId;
		this.bookId = bookId;
		this.bookCount = bookCount;
		this.minNum = minNum;
	}

	@Override
	public String toString() {
		return "BookStock [bookCount=" + bookCount + ", bookId=" + bookId
				+ ", minNum=" + minNum + ", stockId=" + stockId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookCount;
		result = prime * result + bookId;
		result = prime * result + minNum;
		result = prime * result + stockId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStock other = (BookStock) obj;
		if (bookCount != other.bookCount)
			return false;
		if (bookId != other.bookId)
			return false;
		if (minNum != other.minNum)
			return false;
		if (stockId != other.stockId)
			return false;
		return true;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getMinNum() {
		return minNum;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}

}
