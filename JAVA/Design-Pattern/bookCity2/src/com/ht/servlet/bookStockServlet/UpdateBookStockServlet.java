package com.ht.servlet.bookStockServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookStockDAO;
import com.ht.dao.impl.BookStockDAOImpl;
import com.ht.entity.BookStock;

public class UpdateBookStockServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookStockDAO bookStockDAOImpl = new BookStockDAOImpl();
		int stockId = Integer.parseInt(request.getParameter("id"));
		String fd = request.getParameter("fd");
		int val = Integer.parseInt(request.getParameter("val"));
		BookStock bookStock = bookStockDAOImpl.findById(stockId);
		if(fd.equals("a")) {
			bookStock.setBookCount(val);
		} else {
			bookStock.setMinNum(val);
		}
		bookStockDAOImpl.update(bookStock);
		request.getRequestDispatcher("FindAllBookStockServlet").forward(request, response);
	}

}
