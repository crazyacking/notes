package com.ht.servlet.bookInfoServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.impl.BookInfoDAOImpl;

public class DeleteBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		bookInfoDAOImpl.updateStates(3, bookId);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String msg = "成功";
		if(bookInfoDAOImpl.updateStates(3, bookId)) {
			out.print("<script type='text/javascript'>alert('删除数据" + msg +"');document.location.href='FindAllBookInfoServlet';</script>");
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('删除数据" +msg +"');document.location.href='FindAllBookInfoServlet';</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
