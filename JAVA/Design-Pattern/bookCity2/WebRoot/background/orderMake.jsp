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
				<th>订单编号</th>
				<th>客户名称</th>
				<th>金额</th>
				<th>订单状态</th>
				<th>收货方名称</th>
				<th>收货方电话</th>
				<th>收货方地址</th>
				<th>查看详细</th>
				<th>处理中</th>
				<th>处理完毕</th>
			</tr>
			<c:forEach items="${requestScope.orderMains}" var="orderMain">
				<tr onmouseover="this.bgColor='#5e92e7'" onmouseout="this.bgColor='white'">
					<td>${orderMain.oid}</td>
					<td>
						<c:forEach items="${requestScope.customerInfos}" var="customerInfo"> 
							<c:if test="${customerInfo.customerId == orderMain.customerId}">
								${customerInfo.customerName}
							</c:if>
						</c:forEach></td>
					<td>${orderMain.moneyCount}</td>
					
					<c:if test="${orderMain.states == 1}">
						<td>未处理</td>
					</c:if>
					
					<c:if test="${orderMain.states == 2}">
						<td>正在处理...</td>
					</c:if>
					
					<c:if test="${orderMain.states == 3}">
						<td>已处理</td>
					</c:if>
						<td>${orderMain.shouName}</td>
						<td>${orderMain.shouTel}</td>
						<td>${orderMain.shouAddress}</td>
						
						<td><a href="ShowOrderDetailServlet?oid=${orderMain.oid}">查看详细</a></td>
						
					<c:if test="${sysAdmin.adminType == 1}" var="result">
						<td><a href="${pageContext.request.contextPath}/UpOrderStatesServlet?oid=${orderMain.oid}&states=2" onclick="return confirm('是否改为处理..')">处理...</a></td>
						<td><a href="${pageContext.request.contextPath}/UpOrderStatesServlet?oid=${orderMain.oid}&states=3" onclick="return confirm('是否改为处理完毕')">处理完毕</a></td>
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
