package com.ht.servlet.sysAdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ht.dao.SysAdminDAO;
import com.ht.dao.impl.SysAdminDAOImpl;
import com.ht.entity.SysAdmin;

public class SysAdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name =  request.getParameter("name").trim();
		String pwd = request.getParameter("pwd").trim();
		SysAdminDAO sysAdminDAOImpl = new SysAdminDAOImpl();
		SysAdmin sysAdmin = sysAdminDAOImpl.findNameAndPwd(name, pwd);
 		if(null != sysAdmin) {
 			HttpSession session =request.getSession();
 			session.setAttribute("sysAdmin", sysAdmin);
 			response.getWriter().print("1");
 			
		} else {
			response.getWriter().print("0");
		}
	}
}
