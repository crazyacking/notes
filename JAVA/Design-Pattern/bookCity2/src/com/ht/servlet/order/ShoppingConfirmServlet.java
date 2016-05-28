package com.ht.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingConfirmServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name = request.getParameter("name").trim();
			String email = request.getParameter("email").trim();
			String tel = request.getParameter("tel").trim();
			String address = request.getParameter("address").trim();
			String qq = null;
			if(null != request.getParameter("qq")){
				qq = request.getParameter("qq").trim();
			}
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("tel", tel);
			request.setAttribute("address", address);
			request.setAttribute("qq", qq);
			
			request.getRequestDispatcher("/shopping_confirm.jsp").forward(request, response);
	}

}
