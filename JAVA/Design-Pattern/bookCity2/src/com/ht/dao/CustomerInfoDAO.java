package com.ht.dao;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.CustomerInfo;

public interface CustomerInfoDAO extends GenericDAO<CustomerInfo> {
	/**
	 * 验证用户登录信息
	 * @param userName
	 * @param pwd
	 * @return
	 */
	CustomerInfo getNameAndPwd(String userName);
	
	/**
	 * 查询email是否存在
	 */
	CustomerInfo getEmail(String email);
}
