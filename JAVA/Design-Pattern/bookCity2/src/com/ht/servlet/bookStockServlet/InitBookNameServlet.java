package com.ht.servlet.bookStockServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.BookStockDAO;
import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.BookStockDAOImpl;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.entity.BookStock;
import com.ht.entity.BookType;

public class InitBookNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		BookStockDAO bookStockDAOImpl = new BookStockDAOImpl();
		
		List<BookStock> bookStocks = bookStockDAOImpl.findAll(); 
		List<BookInfo> books = bookInfoDAOImpl.findAll();
		List<BookInfo> bookInfos = new ArrayList<BookInfo>();
		int flag = 0;
		for(BookInfo bookInfo : books) {
			flag = 0;
			for(BookStock bookStock : bookStocks) {
				if(bookInfo.getBookId() == bookStock.getBookId()) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				bookInfos.add(bookInfo);
			}
		}
		request.setAttribute("bookInfos", bookInfos);
		request.getRequestDispatcher("/background/bookStock/SaveBookStock.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
