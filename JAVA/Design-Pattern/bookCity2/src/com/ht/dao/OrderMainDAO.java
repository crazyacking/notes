package com.ht.dao;

import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.OrderMain;

public interface OrderMainDAO extends GenericDAO<OrderMain>{
	public List<OrderMain> findOrder(int id);
	public boolean delete(String oid);
	public List<OrderMain> findOrder(int id, int states);
	public OrderMain findByOId(String oid);
}
