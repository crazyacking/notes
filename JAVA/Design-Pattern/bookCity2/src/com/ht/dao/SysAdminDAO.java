package com.ht.dao;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.SysAdmin;

public interface SysAdminDAO extends GenericDAO<SysAdmin> {
	public SysAdmin findNameAndPwd(String name, String pwd);
}
