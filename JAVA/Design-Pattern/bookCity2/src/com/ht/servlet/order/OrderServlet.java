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
 * �¶���
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
		
		//��������ʱ����ĸ�ʽ��ʽ��������id
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String oid = df.format(new Date());
		
		CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("customerInfo");
		
		CustomerDetailInfoDAOImpl customerDetailInfoDAOImpl = new CustomerDetailInfoDAOImpl();
		
		//���������DAO
		OrderMainDAO orderMainDAOImpl = new OrderMainDAOImpl();
		//����������DAO
		OrderDetailDAO orderDetailDAOImpl = new OrderDetailDAOImpl();
		
		//���ﳵ����Ʒ����ϸ��Ϣ
		Collection<GwcItem> gwcItems = gwc.getItems();
		
		CustomerDetailInfo customerDetailInfo = customerDetailInfoDAOImpl.findById(customerInfo.getCustomerId());
		if(customerDetailInfo == null) {
			customerDetailInfo = new CustomerDetailInfo(customerInfo.getCustomerId(), name, tel, address, countMoney, qq);
			if(!customerDetailInfoDAOImpl.save(customerDetailInfo)) {
				out.print("<script type='text/javascript'>alert('�ͻ���Ϣ����');document.location.href='"+ request.getContextPath()+"/gwc.jsp';</script>");
				return;
			}
		}
		
		OrderMain orderMain = new OrderMain(oid, customerInfo.getCustomerId(), countMoney, 1, name, tel, address);
		try
			{
				if(!orderMainDAOImpl.save(orderMain)) {
					out.print("<script type='text/javascript'>alert('�¶�������');document.location.href='"+ request.getContextPath()+"/gwc.jsp';</script>");
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
		out.print("<script type='text/javascript'>alert('ף��������죡���Ķ������ڴ����У���ע����ջ��');document.location.href='InitIndexServlet';</script>");
	}
}
