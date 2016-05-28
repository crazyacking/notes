package com.ht.dao.base;
import java.util.List;

import com.ht.db.JdbcTemplate;

public interface GenericDAO<T> {
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	/**
	 * ����ʵ��
	 * @param o
	 * @return
	 */
	public boolean save(T o);
	
	/**
	 * ����ɾ��ʵ��
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	
	
	/**
	 * �޸�ʵ��
	 * @param o
	 * @return
	 */
	public boolean update(T o);
	
	/**
	 * ��ѯ����ʵ��
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * ����ID��ѯʵ��
	 * @param id
	 * @return
	 */
	public T findById(int id);
}
