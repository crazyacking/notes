<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息列表</title>
<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
</head>
<body>
		<table>
			<caption>客户信息列表</caption>
			<tr>
				<th>客户编号</th>
				<th>客户名称 </th>
				<th>邮箱</th>
				<th>不可用</th>
			</tr>
			<c:forEach items = "${requestScope.customerInfos}" var="customerInfo">
				<tr onmouseover="this.bgColor='#5e92e7'" onmouseout="this.bgColor='white'">
					<td>${customerInfo.customerId}</td>
					<td>${customerInfo.customerName}</td>
					<td>${customerInfo.email}</td>
					<c:if test="${sessionScope.sysAdmin.adminType < 3}" var="result">
						<td><a href="${pageContext.request.contextPath}/DeleteCustomerInfoServlet?customerId=${customerInfo.customerId}" onclick="return confirm('是否${customerInfo.customerName}删除')">删除</a></td>
					</c:if>
					<c:if test="${!result}">
						<td>无权限</td>
						<td>无权限</td>
					</c:if>
				</tr>	
			</c:forEach>
		</table>	
</body>
</html>