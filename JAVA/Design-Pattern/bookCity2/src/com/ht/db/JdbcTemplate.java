package com.ht.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class JdbcTemplate {
	/**
	 * �õ�ĳ����������������ݵ������� 
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
	 * ����ִ��insert update delete
	 * 
	 * @param sql
	 * @param args
	 *            ʹ�ÿɱ����,������Ҫ��������ʱ,����ĳ���Ϊ0
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
			//��sql����е�ռλ����ֵ
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
	 *����ִ�в�ѯ��ز���
	 * 
	 * @param sql
	 * @param mapping
	 *            ����ϵ���ݿ��еĽ������װΪ����
	 * @param values
	 *            �ɱ����������ڲ����б����
	 * @return
	 * @throws Exception
	 */
	public List query(String sql, IResutlSetMapping mapping,
			Object... values) throws Exception {

		PreparedStatement psta = null;
		ResultSet rs = null;
		Connection con = null;
		//ʹ��Vector�̰߳�ȫ
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
