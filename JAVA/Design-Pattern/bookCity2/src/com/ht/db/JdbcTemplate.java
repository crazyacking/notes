package com.ht.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class JdbcTemplate {
	/**
	 * 得到某个表符合条件的数据的总行数 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int query(String sql) throws Exception {
		int result = 0;
		PreparedStatement psta = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			 con = DBManager.getConnection();
			 psta = con.prepareStatement(sql);
			 rs = psta.executeQuery();
			 if(rs.next()) {
				result = rs.getInt(1);
			 }
			
		} finally {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(psta != null) {
				psta.close();
				psta = null;
			}
			if(con != null) {
				con.close();
			}
		}
		return result;
	}

	/**
	 * 用来执行insert update delete
	 * 
	 * @param sql
	 * @param args
	 *            使用可变参数,当不需要传来参数时,数组的长度为0
	 * @return
	 * @throws Exception
	 */
	public int update(String sql, Object... args) throws Exception {

		PreparedStatement psta = null;
		Connection con = null;
		int row = 0;
		try {
			con = DBManager.getConnection();
			psta = con.prepareStatement(sql);
			//给sql语句中的占位符赋值
			for (int i = 0; i < args.length; i++) {
				psta.setObject(i + 1, args[i]);
			}
			row = psta.executeUpdate();
		} finally {
			if (psta != null) {
				psta.close();
				psta = null;
			}
			if(con != null) {
				con.close();
			}
		}
		return row;
	}

	/**
	 *用来执行查询相关操作
	 * 
	 * @param sql
	 * @param mapping
	 *            将关系数据库中的结果集包装为对象
	 * @param values
	 *            可变参数必须放在参数列表最后
	 * @return
	 * @throws Exception
	 */
	public List query(String sql, IResutlSetMapping mapping,
			Object... values) throws Exception {

		PreparedStatement psta = null;
		ResultSet rs = null;
		Connection con = null;
		//使用Vector线程安全
		List<Object> list = new Vector<Object>();

		try {
			 con = DBManager.getConnection();
			 psta = con.prepareStatement(sql);
			 for (int i = 0; i < values.length; i++) {
				psta.setObject(i + 1, values[i]);
			 }
			 rs = psta.executeQuery();
			 while (rs.next()) {
				list.add(mapping.mapping(rs));
			 }
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (psta != null) {
				psta.close();
				psta = null;
			}
			if(con != null) {
				con.close();
				con = null;
			}
		}
		return list;
	}
}
