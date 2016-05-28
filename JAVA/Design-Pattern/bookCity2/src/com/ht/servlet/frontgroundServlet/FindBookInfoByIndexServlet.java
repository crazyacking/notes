package com.ht.servlet.frontgroundServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.entity.BookType;

public class FindBookInfoByIndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/** 数据访问对象start**/
				//操作图书类别的dao
				BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
				//操作图书信息的dao
				BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		/** 数据访问对象end**/

		
		
		/**初始化数据start**/
				int size = 0;
				int pageCount = 0;
				int nowPage = 1;
				int pageSize = 16;
				List<BookInfo> bookInfos = null;
				List<BookType> typeList = null;
		/**初始化数据end**/
		
				
				
		/**客户端传来的参数start**/
			
			//接受客户端要搜索的图书名称信息
			String bookName = request.getParameter("bookName");
			
			//接受客户端要搜索的作者信息
			String author = request.getParameter("author");
			
			//当前页
			if(request.getParameter("nowPage") != null) {
				nowPage = Integer.parseInt(request.getParameter("nowPage").trim());
			}
		/**客户端传来的参数end**/
		
		
		
		
		
		/** 处理数据 start**/
		
			//分页的页数
			pageCount = bookInfoDAOImpl.getPageCountByIndex(bookName, author, pageSize, 2);
	
			// 模糊查询的一页的信息
			bookInfos = bookInfoDAOImpl.getNowPageByAuthorBookName(bookName, author, nowPage, pageSize, 2);
			
			//得到父类别的类别信息
			typeList = bookTypeDAOImpl.findByParentId(0);
			
			if(bookInfoDAOImpl.getPageSizeByAuthorBookName(bookName, author, 2) != null) {
				size = bookInfoDAOImpl.getPageSizeByAuthorBookName(bookName, author, 2).size();
			}
			
		/** 处理数据 end**/
		
		
		/**准备转发的数据 start*/
			request.setAttribute("typeList", typeList);
			request.setAttribute("bookInfos", bookInfos);
			
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("size", size);
		 /**准备转发的数据 end**/
		
		request.getRequestDispatcher("/findView.jsp").forward(request, response);
	}
}
