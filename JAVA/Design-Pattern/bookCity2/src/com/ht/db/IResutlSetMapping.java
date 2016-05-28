package com.ht.db;

import java.sql.ResultSet;

public interface IResutlSetMapping {
	
	/**
	 * 把rs当前行数据转换为一个实体对象
	 * @param rs
	 * @return 具体实体类
	 * @throws Exception
	 */
	public Object mapping(ResultSet rs) throws Exception;
}
