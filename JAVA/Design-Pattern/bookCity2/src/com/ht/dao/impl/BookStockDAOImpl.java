package com.ht.dao.impl;

import java.util.List;

import com.ht.dao.BookStockDAO;
import com.ht.entity.BookStock;
import com.ht.mapping.BookStockMapping;

public class BookStockDAOImpl implements BookStockDAO {

	@Override
	public boolean delete(int id) {
		
		String sql = "delete bookStock from bookStock where stockId=" + id;
		int row = 0;
		try {
			row = jdbcTemplate.update(sql);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return (row == 1);
	}

	@Override
	public List<BookStock> findAll() {
		String sql = "select stockId,bookId,bookCount,minNum from bookStock";
		List<BookStock> list = null;
		try {
				list = jdbcTemplate.query(sql, new BookStockMapping());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
	}

	@Override
	public BookStock findById(int id) {
		String sql = "select stockId,bookId,bookCount,minNum " +
		" from bookStock " +
		" where stockId=" + id;
		List<BookStock> list = null;
		try {
				list = jdbcTemplate.query(sql, new BookStockMapping());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list.get(0);
	}

	@Override
	public boolean save(BookStock bookStock) {
		
		int row = 0;
		String sql = "insert into bookStock(bookId,bookCount,minNum) " +
						" values(?,?,?)";
		
		Object[] values = new Object[]{bookStock.getBookId(), bookStock.getBookCount(), bookStock.getMinNum()};
		
		try {
			row = jdbcTemplate.update(sql, values);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return (row == 1);
	}

	@Override
	public boolean update(BookStock bookStock) {
		
		String sql = "update bookStock " +
		" set bookId=?,bookCount=?,minNum=? " +
		" where stockId=?";
		int row = 0;
		Object[] values = new Object[]{bookStock.getBookId(), bookStock.getBookCount(), bookStock.getMinNum(), bookStock.getStockId()};
		try {
				row = jdbcTemplate.update(sql, values);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return (row == 1);
	}
}
