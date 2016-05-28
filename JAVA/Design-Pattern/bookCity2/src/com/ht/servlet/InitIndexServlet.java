package com.ht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.entity.BookType;

public class InitIndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookInfo> ztBooks = null;
		List<BookType> bookTypes = null;
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		
		
		ztBooks = bookInfoDAOImpl.findAll(2);
		
		
		bookTypes = bookTypeDAOImpl.findAll();
		
		
		List<BookType> typeList = bookTypeDAOImpl.findByParentId(0);
		
		request.setAttribute("bookTypes", bookTypes);
		request.setAttribute("books", ztBooks);
		request.setAttribute("typeList", typeList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
