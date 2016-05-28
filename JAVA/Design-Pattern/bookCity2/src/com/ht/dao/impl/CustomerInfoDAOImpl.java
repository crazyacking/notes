package com.ht.dao.impl;
import java.util.List;
import com.ht.dao.CustomerInfoDAO;
import com.ht.entity.CustomerInfo;
import com.ht.mapping.CustomerInfoMapping;

public class CustomerInfoDAOImpl implements CustomerInfoDAO {

	@Override
	public boolean delete(int id) {
		int row = 0;
		String sql = "delete from customerInfo where customerId = " + id;
		try {
			row = jdbcTemplate.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public List<CustomerInfo> findAll() {
		String sql = "select customerId, customerName, pwd, email from customerInfo";
		List<CustomerInfo> customerInfos = null;
		try {
			customerInfos = jdbcTemplate.query(sql, new CustomerInfoMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerInfos;
	}

	@Override
	public CustomerInfo findById(int id) {
		return null;
	}

	@Override
	public boolean save(CustomerInfo customerInfo) {
		String sql = "insert into customerInfo (customerName, pwd,email) values (?, ?, ?)";
		int row = 0;
		Object[] values = new Object[]{customerInfo.getCustomerName(), customerInfo.getPwd(), customerInfo.getEmail()};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public boolean update(CustomerInfo customerInfo) {
		int row = 0;
		String sql = "update customerInfo set customerName = ?, pwd = ?, email = ? where customerId = ?";
		Object[] values = new Object[]{customerInfo.getCustomerName(), customerInfo.getPwd(), customerInfo.getEmail(), customerInfo.getCustomerId()};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public CustomerInfo getNameAndPwd(String customerName) {
		String sql = "select customerId ,customerName, pwd, email from customerInfo where customerName = ?";
		CustomerInfo customerInfo = null;
		List<CustomerInfo> customerInfos = null;
 		Object[] values = new Object[]{customerName};
		try {
			customerInfos = jdbcTemplate.query(sql, new CustomerInfoMapping(), values);
			if (customerInfos.size()!= 0) {
				customerInfo = customerInfos.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerInfo; 
	}

	@Override
	public CustomerInfo getEmail(String email) {
		String sql = "select customerId ,customerName, pwd, email from customerInfo where email = ?";
		CustomerInfo customerInfo = null;
		List<CustomerInfo> customerInfos = null;
		try {
			customerInfos = jdbcTemplate.query(sql, new CustomerInfoMapping(), email);
			if (customerInfos.size()!= 0) {
				customerInfo = customerInfos.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerInfo;
	}
}
