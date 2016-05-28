package com.ht.servlet.favorite;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.FavoriteDAO;
import com.ht.dao.impl.FavoriteDAOImpl;

public class DeleteFavoriteByListIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String ids = request.getParameter("list_id");
		FavoriteDAO favoriteDAOImpl = new FavoriteDAOImpl();
		
		if(favoriteDAOImpl.delete(ids)) {
			out.print("101");
		} else {
			out.print("100");
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
