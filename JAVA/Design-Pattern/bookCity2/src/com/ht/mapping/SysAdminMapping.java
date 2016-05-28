package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.SysAdmin;

public class SysAdminMapping implements IResutlSetMapping {
	/**
	 * 将关系数据库中的一行的结果集转化为一个实体类
	 */
	@Override
	public SysAdmin mapping(ResultSet rs) throws Exception {
		int i = 1;
		SysAdmin admin = new SysAdmin(rs.getInt(i++), rs.getString(i++), rs.getString(i++), rs.getInt(i++));
		return admin;
	}

}
