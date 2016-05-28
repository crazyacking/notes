package com.ht.servlet.customerInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.CustomerInfoDAO;
import com.ht.dao.impl.CustomerInfoDAOImpl;
import com.ht.entity.CustomerInfo;

public class FindAllCustomerInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerInfoDAO customerInfoDAOImpl = new CustomerInfoDAOImpl();
		List<CustomerInfo> customerInfos = customerInfoDAOImpl.findAll();
		request.setAttribute("customerInfos", customerInfos);
		request.getRequestDispatcher("/background/customerInfo/findCustomerInfoList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
