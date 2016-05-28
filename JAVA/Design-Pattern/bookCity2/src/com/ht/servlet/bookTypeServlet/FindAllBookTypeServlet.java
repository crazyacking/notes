package com.ht.servlet.bookTypeServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookType;

public class FindAllBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
		List<BookType> bookTypes = null;
		//��pageCountҳ
		int pageCount = 0;
		//��nowPageҳ
		int nowPage = 1;
		//pageSizeÿҳ��ʾ������
		int pageSize = 20;
		
		//��������
		
		String strStates = request.getParameter("states");
		String strNowPage = request.getParameter("nowPage");
		if(strStates == null) {
			strStates = "3";
		}
		if(strNowPage == null) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(strNowPage);
		}
		int states = Integer.parseInt(strStates);
		
		pageCount = bookTypeDAOImpl.getPageCount(pageSize, states);
		bookTypes = bookTypeDAOImpl.getNowPageData(nowPage, pageSize, states);
		
		request.setAttribute("bookTypes", bookTypes);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("states", states);
		
		request.getRequestDispatcher("/background/bookType/BookTypeList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
