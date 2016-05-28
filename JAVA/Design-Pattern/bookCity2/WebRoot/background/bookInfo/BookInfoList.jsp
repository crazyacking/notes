<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int pageCount = (Integer)request.getAttribute("pageCount");
int nowPage = (Integer)request.getAttribute("nowPage");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>图书信息列表-网上书城</title>
	<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
  </head>
  <body onload="init()">
		<table>
			<caption>图书信息列表</caption>
			<tr>
				<th>图书ID</th>
				<th>图书名称</th>
				<th>图书类别ID</th>
				<th>出版社</th>
				<th>作者</th>
				<th>价格</th>
				<th>出版日期</th>
				<th>图书状态</th>
				<th>特价</th>
				<th>修改</th>
				<th>不可用</th>
			</tr>
			<c:forEach items="${requestScope.bookInfos}" var="bookInfo">
			<tr onmouseover="this.bgColor='#5e92e7'" onmouseout="this.bgColor='white'">
				<td>${bookInfo.bookId}</td>
				<td>${bookInfo.bookName}</td>
				<td>${bookInfo.bookTypeId}</td>
				<td>${bookInfo.publishName}</td>
				<td>${bookInfo.author}</td>
				<td>${bookInfo.price}</td>
				<td>${bookInfo.publishDate}</td>
				<td>${bookInfo.bookStates}</td>
				<td>${bookInfo.specialPrice}</td>
			<c:if test="${sessionScope.sysAdmin.adminType < 3}" var="result">	
				<td><a href="FindBookInfoByIdServlet?bookId=${bookInfo.bookId}">修改</a></td>
				<td><a href="DeleteBookInfoServlet?bookId=${bookInfo.bookId}" onclick="return confirm('是否删除[${bookInfo.bookName}]')">不可用</a></td>
			</c:if>	
			<c:if test="${!result}">
				<td>无权限 </td>
				<td>无权限 </td>
			</c:if>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="1">
					<a href="InitBookTypeServlet">新增</a>
				</td> 
				<td colspan="2">
					<a id="weishangjia" href="#" onclick="changeStates(1, this)" >未上架</a>　
					<a id="yishangjia" href="#" onclick="changeStates(2, this)">已上架</a>　
					<a id="bukeyong" href="#" onclick="changeStates(3, this)">不可用</a>　	
					<a id="quanbu" href="#" onclick="changeStates(5, this)">所有</a>
				</td>
				<td colspan="8">
				共${pageCount}页　
				第${nowPage}页　
				<% if(nowPage == 1 || pageCount == 0) {%>
					第一页　上一页　
				<%} else {%>
					<a href="#" onclick="gotoNowPage(1, this)">第一页 </a>　
					<a href="#" onclick="gotoNowPage('${nowPage - 1}',this)">上一页</a>　
				<% }%>
				
				<%  if(nowPage == pageCount || pageCount == 0) {%>
					下一页　最后页　
				<%} else {%>
					<a id="nextPage" href="#" onclick="gotoNowPage('${nowPage + 1}',this)">下一页</a> 　
					<a id="end" href="#" onclick="gotoNowPage('${pageCount}',this)">最后页</a>
				<% }%>　
				<select id="selectNowPage" onchange="goNowPage(this.value)">
					<%
						for(int i = 1; i <= pageCount; i++) {
					%>
							<option value="<%=i%>">第<%=i%>页</option>
					<%	
						}
					%>
				</select>
				</td>
			</tr>	
		</table>
 </body>
<script type="text/javascript">
   var states = <%=request.getAttribute("states")%>;
   function gotoNowPage(nowPage,pointer) {
  		var url = "${pageContext.request.contextPath}/FindAllBookInfoServlet?nowPage=" + nowPage + "&states="+states;
  		pointer.href=url;
   }
   
   function goNowPage(nowPage) {
  		var url = "${pageContext.request.contextPath}/FindAllBookInfoServlet?nowPage=" + nowPage + "&states="+states;
  		window.location=url;
   } 
   
   	function changeStates(myStates, pointer1){
  		states = myStates;
  		gotoNowPage(1, pointer1);
  	}
   	function init() {
   		var tag = "quanbu";
		if(states == '1') {
			tag = "weishangjia";
		} else if(states == '2') {
			tag = "yishangjia";
		} else if(states == '3') {
			tag = "bukeyong";
		}
		document.getElementById(tag).style.backgroundColor = 'yellow';
		document.getElementById("selectNowPage").value = "<%=nowPage%>";
   	}
</script>
</html>
