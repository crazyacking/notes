package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.CustomerDetailInfo;

public class CustomerDetailInfoMapping implements IResutlSetMapping {

	@Override
	public CustomerDetailInfo mapping(ResultSet rs) throws Exception {
		int i = 1;
		CustomerDetailInfo info = new CustomerDetailInfo(rs.getInt(i++), 
														 rs.getString(i++),
														 rs.getString(i++),
														 rs.getString(i++),
														 rs.getFloat(i++),
														 rs.getString(i++));
		return info;
	}
		
}
