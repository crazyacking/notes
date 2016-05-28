package com.ht.servlet.sysAdminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.SysAdminDAO;
import com.ht.dao.impl.SysAdminDAOImpl;
import com.ht.entity.SysAdmin;

public class ShowSysAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SysAdminDAO sysAdminDAOImpl = new SysAdminDAOImpl();
		List<SysAdmin> sysAdmins = sysAdminDAOImpl.findAll();
		request.setAttribute("sysAdmins", sysAdmins);
		request.getRequestDispatcher("/background/sysAdmin/findSysAdminList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
