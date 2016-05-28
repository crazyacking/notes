package com.ht.servlet.sysAdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.SysAdminDAO;
import com.ht.dao.impl.SysAdminDAOImpl;
import com.ht.entity.SysAdmin;

public class FindByIdSysAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		SysAdminDAO sysAdminDAOImpl = new SysAdminDAOImpl();
		SysAdmin sysAdmin = sysAdminDAOImpl.findById(adminId);
		request.setAttribute("sysAdmin", sysAdmin);
		request.getRequestDispatcher("/background/sysAdmin/upSysAdminStates.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
