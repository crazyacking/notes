package com.ht.servlet.frontgroundServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookDiscussDAO;
import com.ht.dao.impl.BookDiscussDAOImpl;
import com.ht.entity.BookDiscuss;
import com.ht.entity.CustomerInfo;

public class SaveBookDiscussServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDiscussDAO bookDiscussDAOImpl  = new BookDiscussDAOImpl();
		CustomerInfo customerInfo = (CustomerInfo) request.getSession().getAttribute("customerInfo");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String context = request.getParameter("context");
		BookDiscuss bookDiscuss = new BookDiscuss(bookId, customerInfo.getCustomerId(), context, new Date(), 1);
		String msg = "成功";
		PrintWriter out = response.getWriter();
		if(bookDiscussDAOImpl.save(bookDiscuss)) {
			out.print("<script type='text/javascript'>alert('评论" + msg +"');document.location.href='ShowOneBookInfoServlet?opType=findDis&bookId="+ bookId +"';</script>");
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('评论" +msg +"');document.location.href='ShowOneBookInfoServlet?opType=saveDis&bookId="+ bookId +"';</script>");
		}
	}

}
