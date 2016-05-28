package com.ht.servlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.BookInfoDAO;
import com.ht.dao.impl.BookInfoDAOImpl;
import com.ht.entity.BookInfo;
import com.ht.gwc.Gwc;
import com.ht.gwc.GwcItem;

public class GwcServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opType = request.getParameter("opType");
		if("addBook".equals(opType)) {
			this.addBook(request, response);
		} else if("clear".equals(opType)){
			this.clear(request, response);
		} else if("delete".equals(opType)) {
			this.delete(request, response);
		} else if("changeNum".equals(opType)) {
			this.changeNum(request, response);
		} else {
			response.sendRedirect("InitIndexServlet");
		}
		response.sendRedirect(request.getContextPath() + "/gwc.jsp");
	}
	
	
	/**
	 * 向购物车中添加商品信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addBook(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//得到要新增的商品编号
		int id = Integer.parseInt(request.getParameter("id"));
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		//根据商品编号得到具体信息
		BookInfo bookInfo = bookInfoDAOImpl.findById(id);
		//把商品信息转换为购物车某个item
		GwcItem item = new GwcItem(id, bookInfo.getBookName(), bookInfo.getPrice(), bookInfo.getSpecialPrice(), bookInfo.getSmallImg());
		item.setNum(1);
		
		HttpSession session = request.getSession();
		Gwc gwc = null;//声明一个购物车
		if(session.getAttribute("gwc") == null) {
			gwc = new Gwc();
		} else {
			gwc = (Gwc)session.getAttribute("gwc");
		}
		//往购物车加商品
		gwc.addBook(item);
		session.setAttribute("gwc", gwc);
	}
	
	
	/**
	 * 清空购物车 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void clear(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//得到购物车
		Gwc gwc = (Gwc)session.getAttribute("gwc");
		//清空购物车
		gwc.clear();
	}
	
	/**
	 * 对购物车里的商品进行删除操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		//得到要新增的商品编号
		int id = Integer.parseInt(request.getParameter("id"));
		
		//得到购物车
		HttpSession session = request.getSession();
		Gwc gwc = (Gwc)session.getAttribute("gwc");
		gwc.delete(id);
	}
	
	/**
	 * 对购物车的商品数量进行修改操作
	 * @param requeset
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void changeNum(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//得到要修改数量的图书ID
		int id = Integer.parseInt(request.getParameter("id"));
		
		//得到客户端要修改的数量
		int num = Integer.parseInt(request.getParameter("n"));
		HttpSession session = request.getSession();
		Gwc gwc = (Gwc)session.getAttribute("gwc");
		gwc.updateNum(id, num);
	}
}
