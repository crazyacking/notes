package com.ht.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.OrderDetailDAO;
import com.ht.dao.OrderMainDAO;
import com.ht.dao.impl.OrderDetailDAOImpl;
import com.ht.dao.impl.OrderMainDAOImpl;

public class DeleteMyOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		OrderMainDAO orderMainDAOImpl = new OrderMainDAOImpl();
		OrderDetailDAO orderDetailDAOImpl = new OrderDetailDAOImpl();
		String oid = request.getParameter("oid");
		String msg = "成功";
		if(orderMainDAOImpl.delete(oid) && orderDetailDAOImpl.deleteByOid(oid)) {
			out.print("<script type='text/javascript'>alert('取消订单" + msg +"');document.location.href='ShowMyOrderServlet';</script>");
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('取消订单" +msg +"');document.location.href='ShowMyOrderServlet';</script>");
		}
	}

}
