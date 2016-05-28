package com.ht.servlet.order;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.CustomerInfoDAO;
import com.ht.dao.impl.CustomerInfoDAOImpl;
import com.ht.dao.impl.OrderMainDAOImpl;
import com.ht.entity.CustomerInfo;
import com.ht.entity.OrderMain;

/**
 * ∂©µ•¥¶¿Ì
 * @author ZERO
 *
 */
public class OrderMakeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderMainDAOImpl orderMainDAOImpl = new OrderMainDAOImpl();
		CustomerInfoDAO customerInfoDAOImpl = new CustomerInfoDAOImpl();
		
		List<OrderMain> orderMains = orderMainDAOImpl.findAll();
		List<CustomerInfo> customerInfos = customerInfoDAOImpl.findAll();
		
		request.setAttribute("customerInfos", customerInfos);
		request.setAttribute("orderMains", orderMains);
		
		request.getRequestDispatcher("/background/orderMake.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
