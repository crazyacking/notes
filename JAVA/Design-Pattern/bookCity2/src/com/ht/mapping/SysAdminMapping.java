package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.SysAdmin;

public class SysAdminMapping implements IResutlSetMapping {
	/**
	 * ����ϵ���ݿ��е�һ�еĽ����ת��Ϊһ��ʵ����
	 */
	@Override
	public SysAdmin mapping(ResultSet rs) throws Exception {
		int i = 1;
		SysAdmin admin = new SysAdmin(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getInt(i++));
		return admin;
	}

}
