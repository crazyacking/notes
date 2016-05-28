package com.ht.servlet.favorite;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.FavoriteDAO;
import com.ht.dao.impl.FavoriteDAOImpl;
import com.ht.entity.CustomerInfo;
import com.ht.entity.Favorite;
import com.ht.util.Tool;

public class AddFavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		FavoriteDAO favoriteDAOImpl = new FavoriteDAOImpl();
		if(customerInfo != null) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			if(favoriteDAOImpl.findByBookId(bookId, customerInfo.getCustomerId()) != null) {
				out.print("<script type='text/javascript'>alert('您已收藏过此商品');document.location.href='"+ request.getContextPath()+"/ShowOneBookInfoServlet?bookId="+ bookId +"';</script>");
			} else {
				Favorite favorite = new Favorite(bookId, customerInfo.getCustomerId(), new Date());
				if(favoriteDAOImpl.save(favorite)) {
					out.print("<script type='text/javascript'>alert('收藏商品成功');document.location.href='"+ request.getContextPath()+"/ShowOneBookInfoServlet?bookId="+ bookId +"';</script>");
				} else {
					out.print("<script type='text/javascript'>alert('收藏商品失败');document.location.href='"+ request.getContextPath()+"/ShowOneBookInfoServlet?bookId="+ bookId +"';</script>");
				}
			}
		} else {
			response.sendRedirect("denglu.jsp");
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
