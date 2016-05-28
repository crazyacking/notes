package com.ht.dao;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.CustomerInfo;

public interface CustomerInfoDAO extends GenericDAO<CustomerInfo> {
	/**
	 * ��֤�û���¼��Ϣ
	 * @param userName
	 * @param pwd
	 * @return
	 */
	CustomerInfo getNameAndPwd(String userName);
	
	/**
	 * ��ѯemail�Ƿ����
	 */
	CustomerInfo getEmail(String email);
}
