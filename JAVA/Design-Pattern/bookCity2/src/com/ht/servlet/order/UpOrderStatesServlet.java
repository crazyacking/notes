package com.ht.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.CustomerInfoDAO;
import com.ht.dao.OrderMainDAO;
import com.ht.dao.impl.CustomerInfoDAOImpl;
import com.ht.dao.impl.OrderMainDAOImpl;
import com.ht.entity.CustomerInfo;
import com.ht.entity.OrderMain;
import com.ht.util.Mail;

public class UpOrderStatesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		OrderMainDAO OrderMainDAOImpl = new OrderMainDAOImpl();
		CustomerInfoDAO customerInfoDAOImpl = new CustomerInfoDAOImpl();
		
		String oid = request.getParameter("oid");
		int states = Integer.parseInt(request.getParameter("states"));
		OrderMain orderMain = new OrderMain();
		orderMain.setOid(oid);
		orderMain.setStates(states);
		CustomerInfo customerInfo = customerInfoDAOImpl.findById(orderMain.getCustomerId());
		
		String msg = "成功";
		if(OrderMainDAOImpl.update(orderMain)) {
			if(orderMain.getStates() == 3) {
				try {
					Mail.send(customerInfo.getEmail());
				} catch (Exception e) {
					System.out.println("发送失败");
				}
			}
			out.print("<script type='text/javascript'>alert('订单处理" + msg +"');document.location.href='OrderMakeServlet';</script>");
			
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('订单处理" +msg +"');document.location.href='OrderMakeServlet';</script>");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
