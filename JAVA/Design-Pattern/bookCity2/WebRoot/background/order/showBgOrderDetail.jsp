<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单处理</title>
<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
</head>
<body>
		<table>
			<caption>订单处理</caption>
			<tr>
				<th>序号</th>
				<th>订单编号</th>
				<th>图书编号</th>
				<th>数量(本)</th>
				<th>单价(元)</th>
			</tr>
			<c:forEach items="${requestScope.orderDetails}" var="orderDetail">
				<tr onmouseover="this.bgColor='#5e92e7'" onmouseout="this.bgColor='white'">
					<td>${orderDetail.did}</td>
					<td>${orderDetail.oid}</td>
					<td>${orderDetail.bookId}</td>
					<td>${orderDetail.num}</td>
					<td>${orderDetail.specialPrice}</td>
				</tr>
			</c:forEach>
			   <tr>
			   		<td colspan="5"><input type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
			   </tr>
		</table>
</body>
</html>
