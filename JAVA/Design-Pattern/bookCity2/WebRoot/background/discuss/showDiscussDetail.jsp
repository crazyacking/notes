<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String context = (String)request.getAttribute("context");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
</head>
<body>
		<table>
			<caption>评论详细</caption>
			<tr>
				<td>评论内容</td>
			</tr>
			<tr>
				<td><textarea cols="100" rows ="18"><%=context%></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="返回" onclick="history.go(-1)"/></td>
			</tr>
		</table>
</body>
</html>