package com.ht.db;

import java.sql.ResultSet;

public interface IResutlSetMapping {
	
	/**
	 * ��rs��ǰ������ת��Ϊһ��ʵ�����
	 * @param rs
	 * @return ����ʵ����
	 * @throws Exception
	 */
	public Object mapping(ResultSet rs) throws Exception;
}
