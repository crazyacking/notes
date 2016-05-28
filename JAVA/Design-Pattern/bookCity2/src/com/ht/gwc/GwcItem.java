package com.ht.gwc;

public class GwcItem {
	private int bookId;
	private String bookName;
	private float price;
	private float specialPrice;
	private int num;
	private String smallImg;
	public GwcItem() {
		super();
	}
	public GwcItem(int bookId, String bookName, float price,
			float specialPrice, String smallImg) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.specialPrice = specialPrice;
		this.smallImg = smallImg;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public double getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(float specialPrice) {
		this.specialPrice = specialPrice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + num;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result
				+ ((smallImg == null) ? 0 : smallImg.hashCode());
		result = prime * result + Float.floatToIntBits(specialPrice);
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
		GwcItem other = (GwcItem) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (num != other.num)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (smallImg == null) {
			if (other.smallImg != null)
				return false;
		} else if (!smallImg.equals(other.smallImg))
			return false;
		if (Float.floatToIntBits(specialPrice) != Float
				.floatToIntBits(other.specialPrice))
			return false;
		return true;
	}
}
