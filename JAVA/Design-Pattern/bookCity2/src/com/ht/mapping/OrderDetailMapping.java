package com.ht.mapping;

import java.sql.ResultSet;
import com.ht.entity.OrderDetail;
import com.ht.db.IResutlSetMapping;

public class OrderDetailMapping implements IResutlSetMapping {

	@Override
	public OrderDetail mapping(ResultSet rs) throws Exception {
		int i = 1;
		OrderDetail  orderDetail = new OrderDetail();
		orderDetail.setDid(rs.getInt(i++));
		orderDetail.setOid(rs.getString(i++));
		orderDetail.setBookId(rs.getInt(i++));
		orderDetail.setBookName(rs.getString(i++));
		orderDetail.setSpecialPrice(rs.getFloat(i++));
		orderDetail.setNum(rs.getInt(i++));
		return orderDetail;
	}

}
