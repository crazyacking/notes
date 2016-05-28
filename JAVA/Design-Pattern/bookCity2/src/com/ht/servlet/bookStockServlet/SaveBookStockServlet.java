package com.ht.servlet.bookStockServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookStockDAO;
import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookStockDAOImpl;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookStock;
import com.ht.entity.BookType;

public class SaveBookStockServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int bookCount = Integer.parseInt(request.getParameter("bookCount"));
		int minNum = Integer.parseInt(request.getParameter("minNum"));

		BookStockDAO bookStockDAOImpl = new BookStockDAOImpl();
		BookStock bookStock= new BookStock(bookId, bookCount, minNum);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		String msg = "成功";
		if(bookStockDAOImpl.save(bookStock)) {
			out.print("<script type='text/javascript'>alert('新增数据" + msg +"');document.location.href='FindAllBookStockServlet';</script>");
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('新增数据" +msg +"');document.location.href='InitBookNameServlet';</script>");
		}
	}

}
