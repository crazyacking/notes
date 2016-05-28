package com.ht.dao.impl;

import java.util.List;

import com.ht.dao.FavoriteDAO;
import com.ht.entity.Favorite;
import com.ht.mapping.FavoriteMapping;
import com.ht.util.Tool;

public class FavoriteDAOImpl implements FavoriteDAO {

	@Override
	public boolean delete(int id) {
		int row = 0;
		String sql = "delete from favorite where favoriteId = ?";
		try {
			row = jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public List<Favorite> findAll() {
		return null;
	}

	@Override
	public Favorite findById(int id) {
		return null;
	}

	@Override
	public boolean save(Favorite favorite) {
		int row = 0;
		String sql = "insert into favorite (bookId, customerId, date) values (?, ?, ?)";
		Object[] values = new Object[]{favorite.getBookId(), favorite.getCustomerId(), Tool.convertDateToString(favorite.getDate())};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public boolean update(Favorite o) {
		return false;
	}

	@Override
	public List<Favorite> findByCustomerId(int customerId) {
		List<Favorite> lists = null;
		String sql = "select * from favorite where customerId=?";
		try {
			lists = jdbcTemplate.query(sql, new FavoriteMapping(), customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public Favorite findByBookId(int bookId, int customerId) {
		List<Favorite> lists = null;
		Favorite favorite = null;
		String sql = "select * from favorite where bookId=? and customerId=?";
		try {
			lists = jdbcTemplate.query(sql, new FavoriteMapping(), bookId, customerId);
			if(lists.size() != 0) {
				favorite = lists.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return favorite;
	}

	@Override
	public boolean delete(String ids) {
		int row = 0;
		String sql = "delete from favorite where favoriteId in (" + ids + ")";
		try {
			row = jdbcTemplate.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0 != row;
	}
}
