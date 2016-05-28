package com.ht.dao;

import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.BookInfo;

public interface BookInfoDAO extends GenericDAO<BookInfo> {
	/**
	 * 查找全部
	 * @param states
	 * @return
	 */
	public List<BookInfo> findAll(int states);
	/**
	 * 逻辑删除实体
	 * @param id
	 * @return
	 */
	public boolean updateStates(int states, int id);
	
	/**
	 * 分页的数目
	 * @param pageSize
	 * @param states
	 * @param bookTypeId
	 * @return
	 */
	public int getPageCount(int pageSize, int states, int bookTypeId);
	
	/**
	 * 一页的数据
	 * @param nowPage
	 * @param pageSize
	 * @param states
	 * @param bookTypeId
	 * @return
	 */
	public List<BookInfo> getNowPageData(int nowPage, int pageSize, int states, int bookTypeId);
	
	
	/**
	 * 查找属于该图书类别的图书信息
	 * @param bookTypeId
	 * @return
	 */
	public List<BookInfo> findByTypeId(int bookTypeId);
	
	/**
	 * 取得数据库中图书信息的总数
	 * @param states
	 * @param type
	 * @return
	 */
	public int getRowCount(int states, int type);

	/**
	 * 取得分页的数目
	 * @param bookName
	 * @param author
	 * @param pageSize
	 * @param bookStates
	 * @return
	 */
	public int getPageCountByIndex(String bookName, String author, int pageSize, int bookStates);
	
	/**
	 * 模糊查询的一页数据
	 * @param bookName
	 * @param author
	 * @param nowPage
	 * @param pageSize
	 * @param bookStates
	 * @return
	 */
	public List<BookInfo> getNowPageByAuthorBookName(String bookName, String author, int nowPage, int pageSize, int bookStates);
	
	public List<BookInfo> getPageSizeByAuthorBookName(String bookName, String author, int bookStates);
	
}
