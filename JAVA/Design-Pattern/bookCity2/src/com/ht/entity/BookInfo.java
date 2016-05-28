package com.ht.entity;

import java.util.Date;

public class BookInfo {
	private int bookId;
	private String bookName;
	private int bookTypeId;
	private String publishName;
	private String author;
	private String context;
	private String smallImg;
	private String bigImg;
	private float price;
	private Date publishDate;
	private int bookStates;
	private float specialPrice;

	public BookInfo() {
	
	}

	public BookInfo(int bookId, String bookName, int bookTypeId,
			String publishName, String author, String context, String smallImg,
			String bigImg, float price, Date publishDate, int bookStates,
			float specialPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.publishName = publishName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.publishDate = publishDate;
		this.bookStates = bookStates;
		this.specialPrice = specialPrice;
	}
	
	public BookInfo(String bookName, int bookTypeId,
			String publishName, String author, String context, String smallImg,
			String bigImg, float price, Date publishDate, int bookStates,
			float specialPrice) {
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.publishName = publishName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.publishDate = publishDate;
		this.bookStates = bookStates;
		this.specialPrice = specialPrice;
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

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getPublishName() {
		return publishName;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getBookStates() {
		return bookStates;
	}

	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}

	public float getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(float specialPrice) {
		this.specialPrice = specialPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bigImg == null) ? 0 : bigImg.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookStates;
		result = prime * result + bookTypeId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result
				+ ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result
				+ ((publishName == null) ? 0 : publishName.hashCode());
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
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bigImg == null) {
			if (other.bigImg != null)
				return false;
		} else if (!bigImg.equals(other.bigImg))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStates != other.bookStates)
			return false;
		if (bookTypeId != other.bookTypeId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		if (publishName == null) {
			if (other.publishName != null)
				return false;
		} else if (!publishName.equals(other.publishName))
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


	@Override
	public String toString() {
		return "BookInfo [author=" + author + ", bigImg=" + bigImg
				+ ", bookId=" + bookId + ", bookName=" + bookName
				+ ", bookStates=" + bookStates + ", bookTypeId=" + bookTypeId
				+ ", context=" + context + ", price=" + price
				+ ", publishDate=" + publishDate + ", publishName="
				+ publishName + ", smallImg=" + smallImg + ", specialPrice="
				+ specialPrice + "]";
	}
}
