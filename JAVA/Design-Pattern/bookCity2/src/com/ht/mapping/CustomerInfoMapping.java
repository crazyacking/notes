package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.CustomerInfo;

public class CustomerInfoMapping implements IResutlSetMapping {

	@Override
	public CustomerInfo mapping(ResultSet rs) throws Exception {
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustomerId(rs.getInt("customerId"));
		customerInfo.setCustomerName(rs.getString("customerName"));
		customerInfo.setPwd(rs.getString("pwd"));
		customerInfo.setEmail(rs.getString("email"));
		return customerInfo;
	}
}
