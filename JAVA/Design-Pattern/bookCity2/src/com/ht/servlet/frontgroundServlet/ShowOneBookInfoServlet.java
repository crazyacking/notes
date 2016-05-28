package com.ht.servlet.frontgroundServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookDiscussDAO;
import com.ht.dao.BookInfoDAO;
import com.ht.dao.BookTypeDAO;
import com.ht.dao.CustomerInfoDAO;
import com.ht.dao.impl.BookDiscussDAOImpl;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.dao.impl.CustomerInfoDAOImpl;
import com.ht.entity.BookDiscuss;
import com.ht.entity.BookInfo;
import com.ht.entity.BookType;
import com.ht.entity.CustomerInfo;

public class ShowOneBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		BookDiscussDAO bookDiscussDAOImpl = new BookDiscussDAOImpl();
		CustomerInfoDAO customerInfoDAOImpl = new CustomerInfoDAOImpl();
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		//得到操作的类别
		String opType = request.getParameter("opType");
		
		//得到客户端的图书编号
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		//根据图书ID查询该图书的信息
		BookInfo bookInfo = bookInfoDAOImpl.findById(bookId);
		
		//得到图书的类别名称
		BookType bookType = bookTypeDAOImpl.findById(bookInfo.getBookTypeId());
		
		List<BookInfo> books = bookInfoDAOImpl.findByTypeId(bookInfo.getBookTypeId());
		
		//根据图书编号查找对该图书的评论
		List<BookDiscuss> discuss = bookDiscussDAOImpl.findDiscussByBookId(bookId);
		
		//查询客户信息
		List<CustomerInfo> customerInfos = customerInfoDAOImpl.findAll();
		
		request.setAttribute("discuss", discuss);
		request.setAttribute("customerInfos", customerInfos);
		request.setAttribute("bookInfo", bookInfo);
		request.setAttribute("books", books);
		request.setAttribute("bookType", bookType);
		
		if("findDis".equals(opType)) {
			request.getRequestDispatcher("/findDis.jsp").forward(request, response);
		} else if("saveDis".equals(opType)) {
			request.getRequestDispatcher("/saveDis.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/bookFull.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
