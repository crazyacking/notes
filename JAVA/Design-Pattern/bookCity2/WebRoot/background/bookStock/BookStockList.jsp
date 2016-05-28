<%@ page language="java" import="java.util.*,com.ht.entity.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<BookStock> bookStocks = (List<BookStock>)request.getAttribute("bookStocks");
	List<BookInfo> bookInfos = (List<BookInfo>)request.getAttribute("bookInfos");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>网上书城</title>
	<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
	<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
				$(".info>.enable").dblclick(function() {
					var inval = $(this).html();
					var infd = $(this).attr("fd");
					var inid = $(this).parents().attr("id");
					$(this).html("<input id='edit"+inid+"' value='" + inval + "' style='height:17px;'/>");
					$("#edit" + inid).focus().live("blur", function() {
						var editval = $(this).val();
						if(editval == '') {
							alert('数量不能为空');
						}
						else if(isNaN(editval)) { 
							alert('请输入数字');	
						} else if(!(/^(\+|-)?\d+$/.test(editval))|| editval<0) {
							alert("数量中请输入正整数!");	
						} else if(editval > 100000) {
							alert("你输入的数量太大!");
						} else {
							$(this).parents("td").html(editval);
							$.post("UpdateBookStockServlet", {id:inid, fd:infd, val:editval});
						}
					});
				});
		});
	</script>
  </head>
  <body>
		<table>
			<caption>图书库存列表</caption>
			<tr>
				<th>图书库存ID</th>
				<th>图书名称</th>
				<th>图书库存</th>
				<th>最小数量</th>				
			</tr>
			<%
				for(BookStock bookStock : bookStocks) {
			%>
			<tr onmouseover="this.bgColor='#5e92e7'" onmouseout="this.bgColor='white'" class="info" id="<%=bookStock.getStockId()%>">
				<td><%=bookStock.getStockId()%></td>
				<% for(BookInfo bookInfo : bookInfos) {
				 		if(bookStock.getBookId() == bookInfo.getBookId()) {
				%>
							<td><%=bookInfo.getBookName()%></td>	
				<%		
							break;
				 		}
				   }
				%>
				<td fd="a" class="enable"><%=bookStock.getBookCount()%></td>
				<td fd="b" class="enable"><%=bookStock.getMinNum()%></td>
			</tr>
			<%	
				 
			   }
			%>
			<tr>
				<td colspan="1">
					<a href="InitBookNameServlet">新增</a>
				</td> 
				<td colspan="2">
					&nbsp;
				</td>
				<td colspan="2">
					&nbsp;
				</td>
			</tr>
		</table>
  </body>
</html>