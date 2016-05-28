package com.ht.entity;
import java.util.Date;

public class BookDiscuss {
	private int disId;
	private int bookId;
	private int customerId;
	private String context;
	private Date writeDate;
	private int states;
	public BookDiscuss() {
		super();
	}
	
	public BookDiscuss(int disId, int bookId, int customerId, String context,
			Date writeDate, int states) {
		super();
		this.disId = disId;
		this.bookId = bookId;
		this.customerId = customerId;
		this.context = context;
		this.writeDate = writeDate;
		this.states = states;
	}
	
	public BookDiscuss(int bookId, int customerId, String context,
			Date writeDate, int states) {
		this.bookId = bookId;
		this.customerId = customerId;
		this.context = context;
		this.writeDate = writeDate;
		this.states = states;
	}

	public int getDisId() {
		return disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "BookDiscuss [bookId=" + bookId + ", context=" + context
				+ ", customerId=" + customerId + ", disId=" + disId
				+ ", states=" + states + ", writeDate=" + writeDate + "]";
	}
}
