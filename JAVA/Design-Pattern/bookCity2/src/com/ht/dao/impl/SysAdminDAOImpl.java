package com.ht.dao.impl;

import java.util.List;

import com.ht.dao.SysAdminDAO;
import com.ht.entity.SysAdmin;
import com.ht.mapping.SysAdminMapping;

public class SysAdminDAOImpl implements SysAdminDAO {

	
	@Override
	public boolean delete(int id) {
		int row = 0;
		String sql = "delete from sysAdmin where id = " + id;
		try {
			row = jdbcTemplate.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	@Override
	public List<SysAdmin> findAll() {
		String sql = "select * from sysAdmin";
		List<SysAdmin> sysAdmins = null;
		try {
			sysAdmins = jdbcTemplate.query(sql, new SysAdminMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysAdmins;
	}

	@Override
	public SysAdmin findById(int id) {
		String sql = "select * from sysAdmin where id = ?";
		List<SysAdmin> sysAdmins = null;
 		SysAdmin sysAdmin = null;
		try {
			sysAdmins = jdbcTemplate.query(sql, new SysAdminMapping(), id);
			if(sysAdmins.size() != 0) {
				sysAdmin = sysAdmins.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysAdmin;
	}

	
	
	@Override
	public boolean save(SysAdmin sysAdmin) {
		int row = 0;
		String sql = "insert into sysAdmin (adminName, pwd, type) values (?, ?, ?)";
		Object[] values = new Object[]{sysAdmin.getAdminName(), sysAdmin.getPwd(), sysAdmin.getAdminType()};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1 == row;
	}

	/**
	 * 修改权限
	 */
	@Override
	public boolean update(SysAdmin sysAdmin) {
		String sql = "update sysAdmin set type = ? where id = ?";
		int row = 0;
		try {
			row = jdbcTemplate.update(sql, sysAdmin.getAdminType(), sysAdmin.getAdminId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	
	/**
	 * 登录验证
	 */
	@Override
	public SysAdmin findNameAndPwd(String name, String pwd) {
		String sql = "select * from sysAdmin where adminName = ? and pwd = ?";
		SysAdmin admin = null;
		List<SysAdmin> list = null;
		try {
			list = jdbcTemplate.query(sql, new SysAdminMapping(), name, pwd);
			if(list.size() != 0) {
				admin = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}
