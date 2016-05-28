package com.ht.servlet.sysAdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.SysAdminDAO;
import com.ht.dao.impl.SysAdminDAOImpl;

/**
 * 删除管理员
 * @author ZERO
 *
 */
public class DeleteSysAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("adminId"));
		SysAdminDAO sysAdminDAOImpl = new SysAdminDAOImpl();
		String msg = "成功 ";
		if(sysAdminDAOImpl.delete(id)) {
			out.print("<script type='text/javascript'>alert('删除数据" + msg +"');document.location.href='ShowSysAdminServlet';</script>");
		} else {
			msg = "失败";
			out.print("<script type='text/javascript'>alert('删除数据" +msg +"');document.location.href='ShowSysAdminServlet';</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
