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
		
		/** ���ݷ��ʶ���start**/
				//����ͼ������dao
				BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
				//����ͼ����Ϣ��dao
				BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		/** ���ݷ��ʶ���end**/

		
		
		/**��ʼ������start**/
				int size = 0;
				int pageCount = 0;
				int nowPage = 1;
				int pageSize = 16;
				List<BookInfo> bookInfos = null;
				List<BookType> typeList = null;
		/**��ʼ������end**/
		
				
				
		/**�ͻ��˴����Ĳ���start**/
			
			//���ܿͻ���Ҫ������ͼ��������Ϣ
			String bookName = request.getParameter("bookName");
			
			//���ܿͻ���Ҫ������������Ϣ
			String author = request.getParameter("author");
			
			//��ǰҳ
			if(request.getParameter("nowPage") != null) {
				nowPage = Integer.parseInt(request.getParameter("nowPage").trim());
			}
		/**�ͻ��˴����Ĳ���end**/
		
		
		
		
		
		/** �������� start**/
		
			//��ҳ��ҳ��
			pageCount = bookInfoDAOImpl.getPageCountByIndex(bookName, author, pageSize, 2);
	
			// ģ����ѯ��һҳ����Ϣ
			bookInfos = bookInfoDAOImpl.getNowPageByAuthorBookName(bookName, author, nowPage, pageSize, 2);
			
			//�õ������������Ϣ
			typeList = bookTypeDAOImpl.findByParentId(0);
			
			if(bookInfoDAOImpl.getPageSizeByAuthorBookName(bookName, author, 2) != null) {
				size = bookInfoDAOImpl.getPageSizeByAuthorBookName(bookName, author, 2).size();
			}
			
		/** �������� end**/
		
		
		/**׼��ת�������� start*/
			request.setAttribute("typeList", typeList);
			request.setAttribute("bookInfos", bookInfos);
			
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("size", size);
		 /**׼��ת�������� end**/
		
		request.getRequestDispatcher("/findView.jsp").forward(request, response);
	}
}
