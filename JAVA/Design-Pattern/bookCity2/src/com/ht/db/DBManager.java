package com.ht.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public final class DBManager {
	
	private static DataSource myDataSource = null;
	
	/**
	 * ���췽��˽��,�ⲿ���ܴ�������
	 **/
	private DBManager() {
		
	}
	
	static {
		try {
			Properties prop = new Properties();
			prop.setProperty("username", Config.USER);
			prop.setProperty("password", Config.PWD);
			prop.load(DBManager.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			myDataSource = BasicDataSourceFactory.createDataSource(prop);
			
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static DataSource getDataSource() {
		return myDataSource;
	}
	
	
	//���һ�����ݿ�����
	public static Connection getConnection() throws SQLException {
		return myDataSource.getConnection();
	}
	
	
	/*private static Connection con = null;
	
	
	public synchronized static Connection getConnection() throws Exception {
		if(con == null) {
			Class.forName(Config.DRIVER);
			con = DriverManager.getConnection(Config.URL + Config.DBNAME, Config.USER, Config.PWD);
		}
		return con;
	}*/
}
