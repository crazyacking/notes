package com.ht.servlet.discuss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookDiscussDAO;
import com.ht.dao.impl.BookDiscussDAOImpl;
import com.ht.entity.BookDiscuss;

public class ShowDiscussDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int disId = Integer.parseInt(request.getParameter("disId"));
		BookDiscussDAO bookDiscussDAOImpl = new BookDiscussDAOImpl();
		BookDiscuss bookDiscuss = bookDiscussDAOImpl.findById(disId);
		request.setAttribute("context", bookDiscuss.getContext());
		request.getRequestDispatcher("background/discuss/showDiscussDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
