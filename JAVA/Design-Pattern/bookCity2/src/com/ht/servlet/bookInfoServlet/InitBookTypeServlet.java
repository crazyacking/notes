package com.ht.servlet.bookInfoServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookType;

public class InitBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<BookType> bookTypes  = null;
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		bookTypes = bookTypeDAOImpl.findChildBookType();
		request.setAttribute("initBooTypes", bookTypes);
		request.getRequestDispatcher("/background/bookInfo/SaveBookInfo.jsp").forward(request, response);
	}

}
