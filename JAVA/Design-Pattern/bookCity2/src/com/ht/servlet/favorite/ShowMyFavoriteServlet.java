package com.ht.servlet.favorite;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.FavoriteDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.dao.impl.FavoriteDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.entity.CustomerInfo;
import com.ht.entity.Favorite;

public class ShowMyFavoriteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		FavoriteDAO favoriteDAOImpl = new FavoriteDAOImpl();
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		if(customerInfo != null) {
			List<Favorite> favorites = favoriteDAOImpl.findByCustomerId(customerInfo.getCustomerId());
			for(Favorite favorite: favorites) {
				bookInfos.add(bookInfoDAOImpl.findById(favorite.getBookId()));
			}
			request.setAttribute("favorites", favorites);
			request.setAttribute("bookInfos", bookInfos);
		}
		request.getRequestDispatcher("/customerOrderForm.jsp?mode=3").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
