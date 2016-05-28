package com.ht.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.OrderDetailDAO;
import com.ht.dao.impl.OrderDetailDAOImpl;
import com.ht.entity.OrderDetail;

public class ShowOrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDetailDAO orderDetailDAOImpl = new OrderDetailDAOImpl();
		String oid = request.getParameter("oid");
		List<OrderDetail> orderDetails = orderDetailDAOImpl.findByOId(oid);
		request.setAttribute("orderDetails", orderDetails);
		request.getRequestDispatcher("/background/order/showBgOrderDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
