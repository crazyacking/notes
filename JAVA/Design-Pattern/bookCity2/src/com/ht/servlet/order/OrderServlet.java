package com.ht.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.OrderDetailDAO;
import com.ht.dao.OrderMainDAO;
import com.ht.dao.impl.CustomerDetailInfoDAOImpl;
import com.ht.dao.impl.OrderDetailDAOImpl;
import com.ht.dao.impl.OrderMainDAOImpl;
import com.ht.entity.CustomerDetailInfo;
import com.ht.entity.CustomerInfo;
import com.ht.entity.OrderDetail;
import com.ht.entity.OrderMain;
import com.ht.gwc.Gwc;
import com.ht.gwc.GwcItem;

/**
 * 下订单
 * @author ZERO
 *
 */
public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name").trim();
		String tel = request.getParameter("tel").trim();
		String address = request.getParameter("address").trim();
		String qq = null;
		if(null != request.getParameter("qq")){
			qq = request.getParameter("qq").trim();
		} 
		
		HttpSession session = request.getSession();
		Gwc gwc = (Gwc) session.getAttribute("gwc");
		float countMoney = (float) gwc.getSumPrice()[1];
		
		//以年月日时分秒的格式格式化订单的id
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String oid = df.format(new Date());
		
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		
		CustomerDetailInfoDAOImpl customerDetailInfoDAOImpl = new CustomerDetailInfoDAOImpl();
		
		//订单主表的DAO
		OrderMainDAO orderMainDAOImpl = new OrderMainDAOImpl();
		//订单详情表的DAO
		OrderDetailDAO orderDetailDAOImpl = new OrderDetailDAOImpl();
		
		//购物车中商品的详细信息
		Collection<GwcItem> gwcItems = gwc.getItems();
		
		CustomerDetailInfo customerDetailInfo = customerDetailInfoDAOImpl.findById(customerInfo.getCustomerId());
		if(customerDetailInfo == null) {
			customerDetailInfo = new CustomerDetailInfo(customerInfo.getCustomerId(), name, tel, address, countMoney, qq);
			if(!customerDetailInfoDAOImpl.save(customerDetailInfo)) {
				out.print("<script type='text/javascript'>alert('客户信息出错');document.location.href='"+ request.getContextPath()+"/gwc.jsp';</script>");
				return;
			}
		}
		
		OrderMain orderMain = new OrderMain(oid, customerInfo.getCustomerId(), countMoney, 1, name, tel, address);
		try
			{
				if(!orderMainDAOImpl.save(orderMain)) {
					out.print("<script type='text/javascript'>alert('下订单出错');document.location.href='"+ request.getContextPath()+"/gwc.jsp';</script>");
					return;
				}
				for(GwcItem item : gwcItems) {
					OrderDetail detail = new OrderDetail(oid, item.getBookId(), item.getBookName(), (float)item.getSpecialPrice(), item.getNum());
					orderDetailDAOImpl.save(detail);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		session.removeAttribute("gwc");
		out.print("<script type='text/javascript'>alert('祝您购物愉快！您的订单已在处理中，请注意查收货物！');document.location.href='InitIndexServlet';</script>");
	}
}
