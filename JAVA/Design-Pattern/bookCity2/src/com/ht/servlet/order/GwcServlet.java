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
	 * ���ﳵ�������Ʒ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addBook(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//�õ�Ҫ��������Ʒ���
		int id = Integer.parseInt(request.getParameter("id"));
		BookInfoDAO bookInfoDAOImpl = new BookInfoDAOImpl();
		//������Ʒ��ŵõ�������Ϣ
		BookInfo bookInfo = bookInfoDAOImpl.findById(id);
		//����Ʒ��Ϣת��Ϊ���ﳵĳ��item
		GwcItem item = new GwcItem(id, bookInfo.getBookName(), bookInfo.getPrice(), bookInfo.getSpecialPrice(), bookInfo.getSmallImg());
		item.setNum(1);
		
		HttpSession session = request.getSession();
		Gwc gwc = null;//����һ�����ﳵ
		if(session.getAttribute("gwc") == null) {
			gwc = new Gwc();
		} else {
			gwc = (Gwc)session.getAttribute("gwc");
		}
		//�����ﳵ����Ʒ
		gwc.addBook(item);
		session.setAttribute("gwc", gwc);
	}
	
	
	/**
	 * ��չ��ﳵ 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void clear(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//�õ����ﳵ
		Gwc gwc = (Gwc)session.getAttribute("gwc");
		//��չ��ﳵ
		gwc.clear();
	}
	
	/**
	 * �Թ��ﳵ�����Ʒ����ɾ������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		//�õ�Ҫ��������Ʒ���
		int id = Integer.parseInt(request.getParameter("id"));
		
		//�õ����ﳵ
		HttpSession session = request.getSession();
		Gwc gwc = (Gwc)session.getAttribute("gwc");
		gwc.delete(id);
	}
	
	/**
	 * �Թ��ﳵ����Ʒ���������޸Ĳ���
	 * @param requeset
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void changeNum(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//�õ�Ҫ�޸�������ͼ��ID
		int id = Integer.parseInt(request.getParameter("id"));
		
		//�õ��ͻ���Ҫ�޸ĵ�����
		int num = Integer.parseInt(request.getParameter("n"));
		HttpSession session = request.getSession();
		Gwc gwc = (Gwc)session.getAttribute("gwc");
		gwc.updateNum(id, num);
	}
}
