package com.ht.servlet.bookStockServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.BookStockDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.BookStockDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.entity.BookStock;

public class FindAllBookStockServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookStockDAO bookStockDAOImpl = new BookStockDAOImpl();
		BookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		List<BookInfo> bookInfos = bookInfoDAO.findAll();
		List<BookStock> bookStocks = bookStockDAOImpl.findAll();
		request.setAttribute("bookStocks", bookStocks);
		request.setAttribute("bookInfos", bookInfos);
		request.getRequestDispatcher("/background/bookStock/BookStockList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
