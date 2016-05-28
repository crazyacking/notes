package com.ht.servlet.customerInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.CustomerInfoDAO;
import com.ht.dao.impl.CustomerInfoDAOImpl;
import com.ht.entity.CustomerInfo;

public class CusDengluServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerInfoDAO CustomerInfoDAOImpl = new CustomerInfoDAOImpl();
		/*得到客户端传来的用户名和密码*/
		String userName = request.getParameter("userName").trim();
		String pwd = request.getParameter("pwd");

		/*调用dao进行验证：根据用户名查询到用户对象，然后在验证密码是否一致，从而判断是否登录*/
		CustomerInfo customerInfo = CustomerInfoDAOImpl.getNameAndPwd(userName);
		if(customerInfo != null && customerInfo.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", customerInfo);
			response.getWriter().print("301");
		} else if(customerInfo != null && !customerInfo.getPwd().equals(pwd)) {
			response.getWriter().print("303");
		}
		else {
			response.getWriter().print("302");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
