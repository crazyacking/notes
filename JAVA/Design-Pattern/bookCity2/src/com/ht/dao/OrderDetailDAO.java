package com.ht.dao;


import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.OrderDetail;

public interface OrderDetailDAO extends GenericDAO<OrderDetail>{
	public boolean deleteByOid(String id);
	public List<OrderDetail> findByOId(String oid);
}
