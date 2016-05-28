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

public class ChangeCustomerInfoPwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CustomerInfoDAO customerInfoDAOImpl = new CustomerInfoDAOImpl();
		String newPassword = request.getParameter("newPassword");
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		customerInfo.setPwd(newPassword);
		if(customerInfoDAOImpl.update(customerInfo)) {
			session.invalidate();
			out.print("<script type='text/javascript'>alert('¹§Ï²Äú,ÃÜÂëÐÞ¸Ä³É¹¦');document.location.href='denglu.jsp';</script>");
			out.close();
		} else {
			out.print("<script type='text/javascript'>alert('ÃÜÂëÐÞ¸ÄÊ§°Ü');document.location.href='customerOrderForm.jsp?mode=2';</script>");
			out.close();
		}
	}
}
