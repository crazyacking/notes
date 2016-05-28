package com.ht.servlet.sysAdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.SysAdminDAO;
import com.ht.dao.impl.SysAdminDAOImpl;
import com.ht.entity.SysAdmin;

public class SaveSysAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SysAdminDAO sysAdminDAOImpl = new SysAdminDAOImpl();
		String adminName = request.getParameter("adminName");
		String pwd = request.getParameter("pwd");
		int adminType = Integer.parseInt(request.getParameter("adminType"));
		SysAdmin sysAdmin = new SysAdmin(adminName, pwd , adminType);
		String msg = "成功";
		if(sysAdminDAOImpl.save(sysAdmin)) {
			out.print("<script type='text/javascript'>alert('新增数据" + msg +"');document.location.href='ShowSysAdminServlet';</script>");
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('新增数据" +msg +"');document.location.href='"+ request.getContextPath()+"/background/sysAdmin/saveSysAdmin.jsp';</script>");
		}
	}

}
