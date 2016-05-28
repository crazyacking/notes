package com.ht.dao.base;
import java.util.List;

import com.ht.db.JdbcTemplate;

public interface GenericDAO<T> {
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	/**
	 * 保存实体
	 * @param o
	 * @return
	 */
	public boolean save(T o);
	
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	
	
	/**
	 * 修改实体
	 * @param o
	 * @return
	 */
	public boolean update(T o);
	
	/**
	 * 查询所有实体
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public T findById(int id);
}
