package com.ht.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ht.dao.BookTypeDAO;
import com.ht.entity.BookType;

public class BookTypeDAOImplTest {
	BookTypeDAO bookTypeDAOImpl = null;

	@Before
	public void setUp() throws Exception {
		bookTypeDAOImpl = new BookTypeDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		bookTypeDAOImpl = new BookTypeDAOImpl();
		BookType bookType = new BookType(0, "����", 1, "����");
		bookTypeDAOImpl.save(bookType);
		 
	}

	@Test
	public void testDelete() {

	}

	@Test
	public void testUpdate() {
		/*BookType bookType = new BookType();
		bookType.setBookTypeId(9);
		bookType.setParentId(0);
		bookType.setBookTypeName("�ٶ�");
		bookType.setIsDelete(2);
		bookType.setContext("���ٶ�������");
		bookTypeDAOImpl.update(bookType);*/
	}

	@Test
	public void testFindAll() {
		//System.out.println(bookTypeDAOImpl.findAll());
	}

	@Test
	public void testFindById() {
		System.out.println(bookTypeDAOImpl.findById(1));
	}

	public void testUpDelete() {

	}

}
