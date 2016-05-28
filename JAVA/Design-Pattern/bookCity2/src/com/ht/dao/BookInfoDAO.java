package com.ht.dao;

import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.BookInfo;

public interface BookInfoDAO extends GenericDAO<BookInfo> {
	/**
	 * ����ȫ��
	 * @param states
	 * @return
	 */
	public List<BookInfo> findAll(int states);
	/**
	 * �߼�ɾ��ʵ��
	 * @param id
	 * @return
	 */
	public boolean updateStates(int states, int id);
	
	/**
	 * ��ҳ����Ŀ
	 * @param pageSize
	 * @param states
	 * @param bookTypeId
	 * @return
	 */
	public int getPageCount(int pageSize, int states, int bookTypeId);
	
	/**
	 * һҳ������
	 * @param nowPage
	 * @param pageSize
	 * @param states
	 * @param bookTypeId
	 * @return
	 */
	public List<BookInfo> getNowPageData(int nowPage, int pageSize, int states, int bookTypeId);
	
	
	/**
	 * �������ڸ�ͼ������ͼ����Ϣ
	 * @param bookTypeId
	 * @return
	 */
	public List<BookInfo> findByTypeId(int bookTypeId);
	
	/**
	 * ȡ�����ݿ���ͼ����Ϣ������
	 * @param states
	 * @param type
	 * @return
	 */
	public int getRowCount(int states, int type);

	/**
	 * ȡ�÷�ҳ����Ŀ
	 * @param bookName
	 * @param author
	 * @param pageSize
	 * @param bookStates
	 * @return
	 */
	public int getPageCountByIndex(String bookName, String author, int pageSize, int bookStates);
	
	/**
	 * ģ����ѯ��һҳ����
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
