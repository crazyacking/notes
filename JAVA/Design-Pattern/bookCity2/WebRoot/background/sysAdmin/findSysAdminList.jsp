<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.ht.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息</title>
<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
</head>
<body>
	<table>
		<caption>管理员信息列表</caption>
		<tr>
			<th>管理员编号</th>
			<th>管理员名称</th>
			<th>权限</th>
			<th>更改权限</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.sysAdmins}" var="sysAdmin">
		<tr onmouseover="this.bgColor='#5e92e7'" onmouseout="this.bgColor='white'">
					<td>${sysAdmin.adminId}</td>
					<td>${sysAdmin.adminName}</td>
					<td>${sysAdmin.adminType}</td>
					<c:if test="${sessionScope.sysAdmin.adminType == 1}" var="result">
						<td><a href="${pageContext.request.contextPath}/FindByIdSysAdminServlet?adminId=${sysAdmin.adminId}">权限设置</a></td>
						<td><a href="${pageContext.request.contextPath}/DeleteSysAdminServlet?adminId=${sysAdmin.adminId}" onclick="return confirm('是否${sysAdmin.adminName}删除')">删除</a></td>
					</c:if>
					<c:if test="${!result}">
						<td>无权限</td>
						<td>无权限</td>
					</c:if>	
				</tr>
		</c:forEach>
				<tr>
					<c:if test="${sessionScope.sysAdmin.adminType == 1}" var ="res">
						<td>
							<a href="${pageContext.request.contextPath}/background/sysAdmin/saveSysAdmin.jsp">新增</a>
						</td>					
					</c:if>
					<c:if test="${!res}">
							<td>无新增权限</td>					
					</c:if>
					<td colspan="4"></td>
				</tr>
				
	</table>
</body>
</html>