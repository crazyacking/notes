package com.ht.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.OrderMainDAO;
import com.ht.dao.impl.OrderMainDAOImpl;
import com.ht.entity.CustomerInfo;
import com.ht.entity.OrderMain;

public class ShowMyOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int states = 4;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		String temp = request.getParameter("states");
		if(null == temp) {
			states = 4;
		} else {
			states = Integer.parseInt(temp);
		}
		OrderMainDAO orderMainDAOImpl = new OrderMainDAOImpl();
		List<OrderMain> orderMains = orderMainDAOImpl.findOrder(customerInfo.getCustomerId(), states);	
		request.setAttribute("orderMains", orderMains);
		request.getRequestDispatcher("customerOrderForm.jsp?mode=1").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
