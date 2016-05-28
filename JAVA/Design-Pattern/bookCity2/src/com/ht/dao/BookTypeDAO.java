package com.ht.dao;

import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.BookType;

public interface BookTypeDAO extends GenericDAO<BookType> {
	/**
	 * 逻辑删除实体
	 * @param id
	 * @return
	 */
	public boolean updateStates(int id);
	
	/**
	 *查询父类别信息 
	 */
	public List<BookType> findByParentId(int id);
	
	/**
	 * 分页的数目
	 * @param pageSize
	 * @param states
	 * @return
	 */
	public int getPageCount(int pageSize, int states);
	
	/**
	 * 一页的图书类别的信息
	 * @param nowPage
	 * @param pageSize
	 * @param states
	 * @return
	 */
	public List<BookType> getNowPageData(int nowPage, int pageSize, int states);
	
	
	/**
	 *取得数据库中图书类别的总数 
	 */
	public int getRowCount(int states);
	
	/**
	 * 
	 * @param parentId
	 * @return
	 */
	public List<BookType> findChildBookType();
}
