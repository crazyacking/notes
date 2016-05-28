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
		/*�õ��ͻ��˴������û���������*/
		String userName = request.getParameter("userName").trim();
		String pwd = request.getParameter("pwd");

		/*����dao������֤�������û�����ѯ���û�����Ȼ������֤�����Ƿ�һ�£��Ӷ��ж��Ƿ��¼*/
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
