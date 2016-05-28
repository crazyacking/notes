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


public class FindBookInfoByBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BookInfo> bookInfos = null;
		List<BookType> bookTypes = null;
		BookType bookType = null;
		int size = 0;
		int nowPage = 1;
		int pageCount = 0;
		int pageSize = 16;
		int bookStates = 2;
		
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		
		//当前页
		if(request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage").trim());
		}
		/**
		 * 得到客户点击的子类别ID
		 */
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		
		bookType = bookTypeDAOImpl.findById(bookTypeId);
		
		/**
		 * 属于该类别的 一页的图书信息 
		 */
		bookInfos = bookInfoDAOImpl.getNowPageData(nowPage, pageSize, bookStates, bookTypeId);

		/**
		 * 得到当前位置的根类别的子类信息
		 */
		HttpSession session = request.getSession();
		BookType rootBookType = (BookType) session.getAttribute("rootBookType");
		if(rootBookType == null) {
			rootBookType = bookTypeDAOImpl.findById(bookType.getParentId());
		} 
		bookTypes= bookTypeDAOImpl.findByParentId(rootBookType.getBookTypeId());
		BookType bType = bookTypeDAOImpl.findById(bookTypeId);
		
		/**
		 * 分页的页数
		 */
		pageCount = bookInfoDAOImpl.getPageCount(pageSize, bookStates, bookTypeId);
		
		
		
		/**
		 * 查询该图书类别下的图书的数目
		 */
		size = bookInfoDAOImpl.getRowCount(bookStates, bookTypeId);
		
		
		request.setAttribute("bookTypes", bookTypes);
		request.setAttribute("bookInfos", bookInfos);
		request.setAttribute("bType", bType);
		request.setAttribute("rootBookType", rootBookType);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("size", size);
		
		if(Integer.parseInt(request.getParameter("mode")) == 1) {
			request.getRequestDispatcher("/showTitleOne.jsp").forward(request, response);
		} else if(Integer.parseInt(request.getParameter("mode")) == 2) {
			request.getRequestDispatcher("/showBookInfoByBookTypeId.jsp").forward(request, response);
		} else if(Integer.parseInt(request.getParameter("mode")) == 3) {
			request.getRequestDispatcher("/showBookInfoMode3.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
