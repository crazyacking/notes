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

public class UpSysAdminStatesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("adminId"));
		int states = Integer.parseInt(request.getParameter("states"));
		SysAdminDAO sysAdminDAOImpl = new SysAdminDAOImpl();
		SysAdmin sysAdmin = new SysAdmin();
		sysAdmin.setAdminId(id);
		sysAdmin.setAdminType(states);
		String msg = "成功";
		if(sysAdminDAOImpl.update(sysAdmin)) {
			out.print("<script type='text/javascript'>alert('修改数据" + msg +"');document.location.href='ShowSysAdminServlet';</script>");
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('修改数据" +msg +"');document.location.href=FindByIdSysAdminServlet?id=" + id + "';</script>");
		}
	}

}
