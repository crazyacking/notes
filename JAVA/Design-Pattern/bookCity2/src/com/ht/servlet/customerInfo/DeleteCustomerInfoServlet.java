package com.ht.servlet.customerInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.CustomerDetailInfoDAO;
import com.ht.dao.CustomerInfoDAO;
import com.ht.dao.impl.CustomerDetailInfoDAOImpl;
import com.ht.dao.impl.CustomerInfoDAOImpl;

public class DeleteCustomerInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerInfoDAO customerInfoDAOImpl = new CustomerInfoDAOImpl();
		CustomerDetailInfoDAO customerDetailInfoDAOImpl = new CustomerDetailInfoDAOImpl();
		String msg = "成功";
		if(customerInfoDAOImpl.delete(customerId) && customerDetailInfoDAOImpl.delete(customerId)) {
			out.print("<script type='text/javascript'>alert('删除客户信息" +msg +"');document.location.href='"+ request.getContextPath()+"/FindAllCustomerInfoServlet';</script>");
		} else {
			msg= "失败";
			out.print("<script type='text/javascript'>alert('删除客户信息" +msg +"');document.location.href='"+ request.getContextPath()+"/FindAllCustomerInfoServlet';</script>");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
