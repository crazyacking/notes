package com.ht.servlet.bookInfoServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.entity.BookInfo;

public class FindAllBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		List<BookInfo> bookInfos = null;
		
		//��pageCountҳ
		int pageCount = 0;
		//��nowPageҳ
		int nowPage = 1;
		//pageSizeÿҳ��ʾ������
		int pageSize = 20;
		
		int typeId    = 0;
		
		//��������
		
		String strStates = request.getParameter("states");
		String strNowPage = request.getParameter("nowPage");
		if(strStates == null) { //��ʾ����ͼ�� 
			strStates = "5";
		} 
		if(strNowPage == null) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(strNowPage);
		}
		int states = Integer.parseInt(strStates);
		
		
		pageCount = bookInfoDAOImpl.getPageCount(pageSize, states, typeId);
		bookInfos = bookInfoDAOImpl.getNowPageData(nowPage, pageSize, states, typeId);
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("bookInfos", bookInfos);
		request.setAttribute("states", states);
		
		request.getRequestDispatcher("background/bookInfo/BookInfoList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
