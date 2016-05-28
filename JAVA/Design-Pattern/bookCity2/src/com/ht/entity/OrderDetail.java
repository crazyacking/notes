package com.ht.entity;

public class OrderDetail {
	private int did;
	private String oid;
	private int bookId;
	private String bookName;
	private float specialPrice;
	private int num;

	public OrderDetail() {
		super();
	}

	public OrderDetail(int did, String oid, int bookId, String bookName,
			float specialPrice, int num) {
		super();
		this.did = did;
		this.oid = oid;
		this.bookId = bookId;
		this.bookName = bookName;
		this.specialPrice = specialPrice;
		this.num = num;
	}
	
	public OrderDetail(String oid, int bookId, String bookName,
			float specialPrice, int num) {
		super();
		this.oid = oid;
		this.bookId = bookId;
		this.bookName = bookName;
		this.specialPrice = specialPrice;
		this.num = num;
	}
	
	public OrderDetail(int bookId, String bookName,
			float specialPrice, int num) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.specialPrice = specialPrice;
		this.num = num;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
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

	public float getSpecialPrice() {
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
		result = prime * result + did;
		result = prime * result + num;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (did != other.did)
			return false;
		if (num != other.num)
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (Float.floatToIntBits(specialPrice) != Float
				.floatToIntBits(other.specialPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetail [bookId=" + bookId + ", bookName=" + bookName
				+ ", did=" + did + ", num=" + num + ", oid=" + oid
				+ ", specialPrice=" + specialPrice + "]";
	}
}
