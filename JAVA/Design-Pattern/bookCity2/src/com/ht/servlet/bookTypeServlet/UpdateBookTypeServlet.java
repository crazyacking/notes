package com.ht.servlet.bookTypeServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.BookTypeDAO;
import com.ht.dao.impl.BookTypeDAOImpl;
import com.ht.entity.BookType;

public class UpdateBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
			
			int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
			int parentId = Integer.parseInt(request.getParameter("parentId"));
			String bookTypeName = request.getParameter("bookTypeName");
			int isDelete = Integer.parseInt(request.getParameter("isDelete"));
			String context = request.getParameter("context");
			
			
			BookTypeDAO bookTypeDAOImpl = new BookTypeDAOImpl();
			BookType bookType = new BookType(bookTypeId, parentId, bookTypeName, isDelete, context.trim());
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			String msg = "成功";
			if(bookTypeDAOImpl.update(bookType)) {
				out.print("<script type='text/javascript'>alert('修改数据" + msg +"');document.location.href='FindAllBookTypeServlet';</script>");
			} else {
				msg = "失败";
				out.print("<script type='text/javascript'>alert('修改数据" +msg +"');document.location.href='FindBookTypeByIdServlet?bookTypeId=" + bookTypeId + "';</script>");
			}
	}
}
