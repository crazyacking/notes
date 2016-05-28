package com.ht.servlet.discuss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookDiscussDAO;
import com.ht.dao.impl.BookDiscussDAOImpl;
import com.ht.entity.BookDiscuss;

public class ShowDiscussServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDiscussDAO bookDiscussDAOImpl = new BookDiscussDAOImpl();
		List<BookDiscuss> discusses = bookDiscussDAOImpl.findAll();
		request.setAttribute("discusses", discusses);
		request.getRequestDispatcher("background/discuss/showDiscuss.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
