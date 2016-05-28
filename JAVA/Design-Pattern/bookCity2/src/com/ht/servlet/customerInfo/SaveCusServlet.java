package com.ht.servlet.customerInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.CustomerInfoDAO;
import com.ht.dao.impl.CustomerInfoDAOImpl;
import com.ht.entity.CustomerInfo;

public class SaveCusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerInfoDAO customerInfoDAOImpl = new CustomerInfoDAOImpl();
		String email = request.getParameter("member_email");
		String userName = request.getParameter("username");
		String pwd = request.getParameter("member_password");
		CustomerInfo customerInfo = new CustomerInfo(userName, pwd, email);
	
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		if(customerInfoDAOImpl.save(customerInfo)) {
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", customerInfo);
			out.print("402");
		} else {
			out.print("403");
		}

	}
}
