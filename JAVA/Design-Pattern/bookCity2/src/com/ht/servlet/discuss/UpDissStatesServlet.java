package com.ht.servlet.discuss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookDiscussDAO;
import com.ht.dao.impl.BookDiscussDAOImpl;
import com.ht.entity.BookDiscuss;

public class UpDissStatesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BookDiscussDAO bookDiscussDAOImpl = new BookDiscussDAOImpl();
		int id = Integer.parseInt(request.getParameter("disId"));
		int states = Integer.parseInt(request.getParameter("states"));
		BookDiscuss bookDiscuss = bookDiscussDAOImpl.findById(id);
		bookDiscuss.setStates(states);
		String msg = "成功";
		if(bookDiscussDAOImpl.update(bookDiscuss)) {
			out.print("<script type='text/javascript'>alert('修改状态" +msg +"');document.location.href='ShowDiscussServlet';</script>");
		} else {
			out.print("<script type='text/javascript'>alert('修改状态" +msg +"');document.location.href='ShowDiscussServlet';</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
