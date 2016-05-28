package com.ht.servlet.discuss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookDiscussDAO;
import com.ht.dao.impl.BookDiscussDAOImpl;

public class DelDissServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		BookDiscussDAO bookDiscussDAOImpl = new BookDiscussDAOImpl();
		int disId = Integer.parseInt(request.getParameter("disId"));
		
		String msg = "�ɹ�";
		if(bookDiscussDAOImpl.delete(disId)) {
			out.print("<script type='text/javascript'>alert('�޸�״̬" +msg +"');document.location.href='ShowDiscussServlet';</script>");
		} else {
			out.print("<script type='text/javascript'>alert('�޸�״̬" +msg +"');document.location.href='ShowDiscussServlet';</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
