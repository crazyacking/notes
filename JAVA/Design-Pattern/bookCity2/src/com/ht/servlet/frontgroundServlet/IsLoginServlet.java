package com.ht.servlet.frontgroundServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.CustomerDetailInfoDAO;
import com.ht.dao.impl.CustomerDetailInfoDAOImpl;
import com.ht.entity.CustomerDetailInfo;
import com.ht.entity.CustomerInfo;

public class IsLoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//判断用户是否登录
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		
		if(customerInfo != null) {
			if(null == session.getAttribute("gwc")){
				out.print("<script type='text/javascript'>alert('请您先选购好商品');document.location.href='InitIndexServlet';</script>");
				out.close();
				return;
			}
			CustomerDetailInfoDAO customerDetailInfoDAOImpl = new CustomerDetailInfoDAOImpl();
			CustomerDetailInfo customerDetailInfo = customerDetailInfoDAOImpl.findById(customerInfo.getCustomerId());
			request.setAttribute("customerDetailInfo", customerDetailInfo);
			request.getRequestDispatcher("/orderForm.jsp").forward(request, response);
		} else {
			out.print("<script type='text/javascript'>alert('请您先登录');document.location.href='"+ request.getContextPath()+"/denglu.jsp';</script>");
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
