package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.OrderMain;

public class OrderMainMapping implements IResutlSetMapping {

	@Override
	public OrderMain mapping(ResultSet rs) throws Exception {
		int i = 1;
		OrderMain orderMain = new OrderMain(rs.getString(i++),
											rs.getInt(i++),
											rs.getFloat(i++),
											rs.getInt(i++),
											rs.getString(i++),
											rs.getString(i++),
											rs.getString(i++));
		return orderMain;
	}

}
