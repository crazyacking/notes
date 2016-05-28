<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(null == request.getAttribute("bookInfos")) {
	out.print("<script type='text/javascript'>alert('无图书需添加库存');document.location.href='FindAllBookStockServlet';</script>");
	return;
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>图书库存的新增</title>
	<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
	<script>
			function check() {
				if(myform.bookCount.value == '') {
					alert('请输入图书数量');
					return false;
				}
				if(myform.minNum.value == '') {
					alert('请输入最小图书数量');
					return false;
				}
				return true;
			}
	</script>
  </head>
  <body>
 		<form action="<%=request.getContextPath()%>/SaveBookStockServlet" name="myform" method="post" onsubmit="return check()">
		<table>
			<caption>新增图书库存信息</caption>
			<tr>
				<td>图书名称</td>
				<td>
				<select name="bookId">
					<c:forEach items="${bookInfos}" var="bookInfo">
						<option value="${bookInfo.bookId}">${bookInfo.bookName}</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>图书库存</td>
				<td><input type="text" class="text" name="bookCount"/></td>
			</tr>
			<tr>
				<td>图书最小数量</td>
				<td><input type="text" class="text" name="minNum"/></td>
			</tr>
			<tr>
				<td><input type="submit"/></td><td><input type="reset"/></td>
			</tr>
		</table>
		</form>
  </body>
</html>
