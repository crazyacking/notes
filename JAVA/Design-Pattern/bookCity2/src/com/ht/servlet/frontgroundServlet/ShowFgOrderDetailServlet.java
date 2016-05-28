package com.ht.servlet.frontgroundServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.OrderDetailDAO;
import com.ht.dao.OrderMainDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.OrderDetailDAOImpl;
import com.ht.dao.impl.OrderMainDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.entity.OrderDetail;
import com.ht.entity.OrderMain;

public class ShowFgOrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		OrderMainDAO orderMainDAOImpl =  new OrderMainDAOImpl();
		OrderDetailDAO orderDetailDAOImpl = new OrderDetailDAOImpl();
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		
		List<BookInfo> books = new ArrayList<BookInfo>();
		OrderMain orderMain = orderMainDAOImpl.findByOId(oid);
		List<OrderDetail> orderDetails = orderDetailDAOImpl.findByOId(orderMain.getOid());
		for(OrderDetail orderDetail : orderDetails) {
			books.add(bookInfoDAOImpl.findById(orderDetail.getBookId()));
		}
		request.setAttribute("bookss", books);
		request.setAttribute("orderDetails", orderDetails);
		request.setAttribute("orderMain", orderMain);
		
		request.getRequestDispatcher("/customerOrderForm.jsp?mode=5").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
