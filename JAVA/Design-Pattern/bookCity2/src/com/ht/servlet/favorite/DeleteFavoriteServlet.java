package com.ht.servlet.favorite;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.FavoriteDAO;
import com.ht.dao.impl.FavoriteDAOImpl;

public class DeleteFavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		FavoriteDAO favoriteDAOImpl = new FavoriteDAOImpl();
		String msg = "失败"; 
		if(favoriteDAOImpl.delete(id)) {
			msg = "成功";
			out.print("<script type='text/javascript'>alert('操作" +msg +"');document.location.href='"+ request.getContextPath()+"/ShowMyFavoriteServlet';</script>");
		} else {
			out.print("<script type='text/javascript'>alert('操作" +msg +"');document.location.href='"+ request.getContextPath()+"/ShowMyFavoriteServlet';</script>");
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
