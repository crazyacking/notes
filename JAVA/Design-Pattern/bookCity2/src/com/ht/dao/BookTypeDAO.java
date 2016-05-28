package com.ht.dao;

import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.BookType;

public interface BookTypeDAO extends GenericDAO<BookType> {
	/**
	 * �߼�ɾ��ʵ��
	 * @param id
	 * @return
	 */
	public boolean updateStates(int id);
	
	/**
	 *��ѯ�������Ϣ 
	 */
	public List<BookType> findByParentId(int id);
	
	/**
	 * ��ҳ����Ŀ
	 * @param pageSize
	 * @param states
	 * @return
	 */
	public int getPageCount(int pageSize, int states);
	
	/**
	 * һҳ��ͼ��������Ϣ
	 * @param nowPage
	 * @param pageSize
	 * @param states
	 * @return
	 */
	public List<BookType> getNowPageData(int nowPage, int pageSize, int states);
	
	
	/**
	 *ȡ�����ݿ���ͼ���������� 
	 */
	public int getRowCount(int states);
	
	/**
	 * 
	 * @param parentId
	 * @return
	 */
	public List<BookType> findChildBookType();
}
