<%@ page import="com.ht.entity.SysAdmin" %>
<%
	Object admin = session.getAttribute("sysAdmin");
	SysAdmin user = null;
	if(admin == null) {
		response.sendRedirect(request.getContextPath() + "/background/sysAdmin/login.jsp");
		return;
	} else {
		user = (SysAdmin)admin;
	}
%>
