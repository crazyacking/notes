<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>图书类别的新增</title>
	<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
  </head>
  <body>
 		<form action="<%=request.getContextPath()%>/SaveBookTypeServlet" name="saveBookType" method="post">
		<table>
			<caption>新增图书类别信息</caption>
			<tr>
				<td>父ID</td>
				<td>
				<select name="parentId">
					<c:forEach items="${bookTypes}" var="bookType">
						<option value="${bookType.bookTypeId}">${bookType.bookTypeName}</option>
					</c:forEach>
						<option value="0">无</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>图书类别名称</td>
				<td><input type="text" class="text" name="bookTypeName"/></td>
			</tr>
			<tr>
				<td>是否可用</td>
				<td><input type="radio" name="isDelete" value="1" checked/>可用
					<input type="radio" name="isDelete" value="2"/>不可用
				</td>
			</tr>
			<tr>
				<td>图书类别描述</td>
				<td>
					<textarea rows="7" cols="33" name="context"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit"/></td><td><input type="reset"/></td>
			</tr>
		</table>
		</form>
  </body>
</html>
