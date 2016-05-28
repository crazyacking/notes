<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书评论表</title>
<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
</head>
<body>
	<table>
		<caption>图书评论表</caption>
		<tr>
			<th>评论编号</th>
			<th>图书编号</th>
			<th>客户编号</th>
			<th>查看评论</th>
			<th>发表时间</th>
			<th>状态</th>
			<th>通过</th>
			<th>删除</th>
		</tr>
		<c:forEach var ="discuss" items="${requestScope.discusses}">
				<tr>
					<td>${discuss.disId}</td>
					<td>${discuss.bookId}</td>
					<td>${discuss.customerId}</td>
					<td><a href="ShowDiscussDetailServlet?disId=${discuss.disId}">查看详细评论</a></td>
					<td>${discuss.writeDate}</td>
					<c:if test="${discuss.states == 1}">
							<td>通过</td>
					</c:if>
					<c:if test="${discuss.states == 2}">
							<td>未通过</td>		
					</c:if>
					<c:if test="${sessionScope.sysAdmin.adminType < 3}" var="result">
						<td><a href="${pageContext.request.contextPath}/UpDissStatesServlet?disId=${discuss.disId}&states=2">不通过</a></td>
						<td><a href="${pageContext.request.contextPath}/DeleteDisServlet?disId=${discuss.disId}" onclick="return confirm('确定删除本条评论吗')">删除</a></td>
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