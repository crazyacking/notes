package com.ht.dao.impl;

import java.util.List;
import java.util.Vector;
import com.ht.dao.BookDiscussDAO;
import com.ht.entity.BookDiscuss;
import com.ht.mapping.BookDiscussMapping;
import com.ht.util.Tool;

public class BookDiscussDAOImpl implements BookDiscussDAO {

	@Override
	public boolean delete(int id) {
		String sql = "delete bookDiscuss from bookDiscuss where disId=?";
		int row = 0;
		try {
			row = jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1 == row;
	}

	@Override
	public List<BookDiscuss> findAll() {
		String sql = "select * from bookDiscuss";
		List<BookDiscuss> list = new Vector<BookDiscuss>();
		try {
			list = jdbcTemplate.query(sql, new BookDiscussMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BookDiscuss findById(int id) {
		String sql = "select * from bookDiscuss where disId = " + id;
		List<BookDiscuss> list = null;
		BookDiscuss dis = null;
		try {
			list = jdbcTemplate.query(sql, new BookDiscussMapping());
			if(list.size() != 0) {
				dis = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dis;
	}

	@Override
	public boolean save(BookDiscuss bookDiscuss) {
		int row = 0;
		String sql = "insert into bookDiscuss(bookId, customerId, context, writeDate, states) values (?,?,?,?,?)";
		String StrDate = Tool.convertDateToString(bookDiscuss.getWriteDate());
		Object[] values = new Object[]{bookDiscuss.getBookId(), bookDiscuss.getCustomerId(), bookDiscuss.getContext(), StrDate, bookDiscuss.getStates()};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1 == row;
	}

	@Override
	public boolean update(BookDiscuss bookDiscuss) {
		String sql = "update bookDiscuss set bookId = ?, customerId = ?, context = ?, states=? where disId=?";
		Object[] values = new Object[]{bookDiscuss.getBookId(), bookDiscuss.getCustomerId(), bookDiscuss.getContext(), bookDiscuss.getStates(), bookDiscuss.getDisId()};
		int row = 0;
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1 == row;
	}

	@Override
	public List<BookDiscuss> findDiscussByBookId(int bookId) {
		String sql = "select * from bookDiscuss where states = 1 and bookId=? order by disId desc";
		StringBuffer sb = new StringBuffer(sql);
		List<BookDiscuss> list = new Vector<BookDiscuss>();
		try {
			list = jdbcTemplate.query(sb.toString(), new BookDiscussMapping(),bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
