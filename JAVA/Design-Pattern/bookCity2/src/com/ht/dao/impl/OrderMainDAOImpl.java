package com.ht.dao.impl;

import java.util.List;

import com.ht.dao.OrderMainDAO;
import com.ht.entity.OrderMain;
import com.ht.mapping.OrderMainMapping;

public class OrderMainDAOImpl implements OrderMainDAO {

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public List<OrderMain> findAll() {
		String sql = "select * from orderMain";
		List<OrderMain> orderMains = null;
		try {
			orderMains = jdbcTemplate.query(sql, new OrderMainMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderMains;
	}

	public List<OrderMain> findOrder(int id) {
		String sql = "select * from OrderMain where customerId = ?";
		List<OrderMain> orderMains = null;
		try {
			orderMains =jdbcTemplate.query(sql, new OrderMainMapping(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderMains;
	}

	@Override
	public boolean save(OrderMain orderMain) {
		int row = 0;
		String sql = "insert into orderMain " +
					 "		(oid, customerId, moneyCount, states, shouName, shouTel,shouAddress) " +
					 "values " +
					 "		(?,?,?,?,?,?,?)";
		Object[] values = new Object[]{orderMain.getOid(), 
									   orderMain.getCustomerId(), 
									   orderMain.getMoneyCount(),
									   orderMain.getStates(),
									   orderMain.getShouName(),
									   orderMain.getShouTel(),
									   orderMain.getShouAddress()};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public boolean update(OrderMain orderMain) {
		int row = 0;
		String sql = "update orderMain set states = ? where oid = ?";
		try {
			row = jdbcTemplate.update(sql, orderMain.getStates(), orderMain.getOid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public OrderMain findById(int id) {
		return null;
	}

	@Override
	public boolean delete(String oid) {
		int row = 0;
		String sql = "delete from orderMain where oid = ? and states = 1";
		try {
			row = jdbcTemplate.update(sql, oid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}
	
	public List<OrderMain> findOrder(int id, int states) {
		
		StringBuffer where = new StringBuffer("and 1 = 1");
		List<OrderMain> orderMains = null;
		switch (states) {
			case 1: where.append("and states = 1");break;
			case 2: where.append("and states = 2");break;
			case 3: where.append("and states = 3");break;			
		}
		String sql = "select * from OrderMain where customerId = ? " + where;
		try {
			orderMains = jdbcTemplate.query(sql, new OrderMainMapping(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderMains;
	}

	@Override
	public OrderMain findByOId(String oid) {
		OrderMain orderMain = null;
		List<OrderMain> orderMains = null;
		String sql = "select * from orderMain where oid = ?";
		try {
			orderMains = jdbcTemplate.query(sql, new OrderMainMapping(), oid);
			if(orderMains.size() != 0) {
				orderMain = orderMains.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderMain;
	}
}
