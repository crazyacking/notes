package com.ht.dao.impl;

import java.util.List;

import com.ht.dao.OrderDetailDAO;
import com.ht.entity.OrderDetail;
import com.ht.mapping.OrderDetailMapping;

public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public List<OrderDetail> findAll() {
		return null;
	}

	@Override
	public OrderDetail findById(int id) {
		return null;
	}

	@Override
	public boolean save(OrderDetail orderDetail) {
		int row = 0;
		String sql = "insert into orderDetail " +
					"		(oid, bookId, bookName, specialPrice, num) " +
					"values " +
					"		(?,?,?,?,?)";
		Object[] values = new Object[]{orderDetail.getOid(),
									   orderDetail.getBookId(),
									   orderDetail.getBookName(),
									   orderDetail.getSpecialPrice(),
									   orderDetail.getNum()
									   };
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public boolean update(OrderDetail o) {
		return false;
	}

	@Override
	public boolean deleteByOid(String id) {
		int row = 0;
		String sql = "delete from orderDetail where oid = " + id;
		try {
			row = jdbcTemplate.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1 == row;
	}

	@Override
	public List<OrderDetail> findByOId(String oid) {
		List<OrderDetail> list = null;
		String sql = "select * from orderDetail where oid = ?";
		try {
			list = jdbcTemplate.query(sql, new OrderDetailMapping(), oid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
