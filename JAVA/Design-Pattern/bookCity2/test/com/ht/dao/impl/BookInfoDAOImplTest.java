package com.ht.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ht.dao.BookInfoDAO;
import com.ht.entity.BookInfo;
import com.ht.util.Tool;
import com.sun.faces.util.ToolsUtil;

public class BookInfoDAOImplTest {
	private BookInfoDAO bookInfoDAOImpl = null;

	@Before
	public void setUp() throws Exception {
		bookInfoDAOImpl = new BookInfoDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookName("藏地密码9");
		bookInfo.setBookTypeId(2);
		bookInfo.setPublishName("重庆出版社");
		bookInfo.setAuthor("何马");
		bookInfo.setContext("揭开藏传佛教灵魂转世之谜！");
		bookInfo.setPrice(29.80f);
		try {
			bookInfo.setPublishDate(Tool.convertStringToDate("2010-9-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		bookInfo.setBookStates(1);
		bookInfo.setSpecialPrice(19.40f);
		bookInfoDAOImpl.save(bookInfo);
	}

	@Test
	public void testDelete() {

	}

	@Test
	public void testFindAll() {
		//System.out.println(bookInfoDAOImpl.findAll());
	}

	@Test
	public void testFindById() {
		//System.out.println(bookInfoDAOImpl.findById(1));
	}

	@Test
	public void testUpDelete() {

	}

	@Test
	public void testUpdate() {

	}
}
