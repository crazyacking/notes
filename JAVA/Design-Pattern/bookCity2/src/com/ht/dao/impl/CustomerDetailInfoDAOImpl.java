package com.ht.dao.impl;

import java.util.List;

import com.ht.dao.CustomerDetailInfoDAO;
import com.ht.entity.CustomerDetailInfo;
import com.ht.mapping.CustomerDetailInfoMapping;

public class CustomerDetailInfoDAOImpl implements CustomerDetailInfoDAO {

	@Override
	public boolean delete(int id) {
		int row = 0;
		String sql = "delete from customerDetailInfo where customerId = " + id;
		try {
			row = jdbcTemplate.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public List<CustomerDetailInfo> findAll() {
		return null;
	}

	@Override
	public CustomerDetailInfo findById(int id) {
		String sql = "select * from customerDetailInfo where customerId = " + id;
		CustomerDetailInfo customerDetailInfo = null;
		try {
			List<CustomerDetailInfo> customerDetailInfos = jdbcTemplate.query(sql, new CustomerDetailInfoMapping());
			if(customerDetailInfos.size() != 0) {
				customerDetailInfo = customerDetailInfos.get(0); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return customerDetailInfo;
	}

	
	/**
	 * 对客户详细信息进行插入操作
	 */
	@Override
	public boolean save(CustomerDetailInfo customerDetailInfo) {
		int row = 0;
		String sql = "insert into customerDetailInfo " +
					 "		(customerId, realname, tel, address, countMoney, qq) " +
					 "values  " +
					 "		(?,?,?,?,?,?)";
		Object[] values = new Object[]{customerDetailInfo.getCustomerId(),
									   customerDetailInfo.getRealname(),
									   customerDetailInfo.getTel(),
									   customerDetailInfo.getAddress(),
									   customerDetailInfo.getCountMoney(),
									   customerDetailInfo.getQq()
									   };
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return row == 1;
	}

	@Override
	public boolean update(CustomerDetailInfo o) {
		return false;
	}
}
