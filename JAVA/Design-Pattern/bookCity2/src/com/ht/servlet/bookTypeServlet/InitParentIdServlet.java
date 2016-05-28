package com.ht.servlet.bookTypeServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookType;

public class InitParentIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		List<BookType> bookTypes = bookTypeDAOImpl.findAll();
		request.setAttribute("bookTypes", bookTypes);
		request.getRequestDispatcher("/background/bookType/SaveBookType.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
