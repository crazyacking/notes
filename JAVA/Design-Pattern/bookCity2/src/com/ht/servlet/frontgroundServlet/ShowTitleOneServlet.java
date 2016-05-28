package com.ht.servlet.frontgroundServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.entity.BookType;

public class ShowTitleOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int nowPage = 1;
		int pageCount = 0;
		int pageSize = 16;
		int bookStates = 2;
		int size = 0;
		
		List<BookInfo> bookInfos = null;
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		BookType rootBookType = bookTypeDAOImpl.findById(bookTypeId);
		
		
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		List<BookType> bookTypes  = bookTypeDAOImpl.findByParentId(bookTypeId);
		
		if(bookTypes == null || bookTypes.size() == 0) { 
			;
		} else {
			bookInfos = bookInfoDAOImpl.getNowPageData(nowPage, pageSize, bookStates, bookTypes.get(0).getBookTypeId());
			pageCount = bookInfoDAOImpl.getPageCount(pageSize, bookStates, bookTypes.get(0).getBookTypeId());
			size = bookInfoDAOImpl.getRowCount(bookStates, bookTypes.get(0).getBookTypeId());
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("rootBookType", rootBookType);
		request.setAttribute("bookTypes", bookTypes);
		request.setAttribute("bookInfos", bookInfos);
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("size", size);
		request.getRequestDispatcher("/showTitleOne.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
