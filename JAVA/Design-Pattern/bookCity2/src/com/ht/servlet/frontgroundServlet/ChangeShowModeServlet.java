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

/**
 * 前台改变图书的显示样式
 * @author ZERO
 *
 */
public class ChangeShowModeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**数据访问对象 start**/
			//操作图书类别的dao
			BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
			//操作图书信息的dao
			BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		/**数据访问对象 end**/
		
			
		/**初始化数据  start**/
			int nowPage = 1;
			int pageCount = 0;
			int pageSize = 16;
			int bookStates = 2;
			int size = 0;
			List<BookInfo> bookInfos = null;
			List<BookType> bookTypes = null;
			BookType bookType = null;
			int bookTypeId = 0;
		/**初始化数据  end**/
		
		/**接受客户端参数 start**/
			bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
			
			//当前页
			if(request.getParameter("nowPage") != null) {
				nowPage = Integer.parseInt(request.getParameter("nowPage").trim());
			}
		/**接受客户端参数 end**/
			
		
		bookInfos = bookInfoDAOImpl.getNowPageData(nowPage, pageSize, bookStates, bookTypeId); 
		pageCount = bookInfoDAOImpl.getPageCount(pageSize, bookStates, bookTypeId);
		size = bookInfoDAOImpl.getRowCount(bookStates, bookTypeId);
		bookType = bookTypeDAOImpl.findById(bookTypeId);
		
		HttpSession session = request.getSession();
		BookType rootBookType = (BookType) session.getAttribute("rootBookType");
		if(rootBookType == null) {
			rootBookType = bookTypeDAOImpl.findById(bookType.getParentId());
		}
		bookTypes = bookTypeDAOImpl.findByParentId(rootBookType.getBookTypeId());
		BookType bType = bookTypeDAOImpl.findById(bookTypeId);

		/**准备转发的数据 start*/
		request.setAttribute("bookTypes", bookTypes);
		request.setAttribute("bookInfos", bookInfos);
		request.setAttribute("bType", bType);
		request.setAttribute("rootBookType", rootBookType);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("size", size);
		/**准备转发的数据 end*/
		
		
		/**转发到对应地址 start**/
		if(Integer.parseInt(request.getParameter("mode")) == 1) {
			request.getRequestDispatcher("showTitleOne.jsp").forward(request, response);
		} else if(Integer.parseInt(request.getParameter("mode")) == 2) {
			request.getRequestDispatcher("showBookInfoByBookTypeId.jsp").forward(request, response);
		} else if(Integer.parseInt(request.getParameter("mode")) == 3) {
			request.getRequestDispatcher("showBookInfoMode3.jsp").forward(request, response);
		}
		/**转发到对应地址 end**/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
