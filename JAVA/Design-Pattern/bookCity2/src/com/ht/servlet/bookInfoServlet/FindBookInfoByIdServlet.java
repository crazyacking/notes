package com.ht.servlet.bookInfoServlet;

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

public class FindBookInfoByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		BookInfo bookInfo = bookInfoDAOImpl.findById(bookId);
		request.setAttribute("bookInfo", bookInfo);
		
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		List<BookType> bookTypes = bookTypeDAOImpl.findAll();
		request.setAttribute("initBooTypes", bookTypes);
			
		request.getRequestDispatcher("/background/bookInfo/UpdateBookInfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
