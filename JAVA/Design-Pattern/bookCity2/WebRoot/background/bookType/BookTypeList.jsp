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
    <title>网上书城</title>
	<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
  </head>
  <body onload="init()">
		<table>
			<caption>图书类别信息列表</caption>
			<tr>
				<th>图书类别ID</th>
				<th>parentId</th>
				<th>图书类别名称</th>
				<th>是否可用</th>
				<th>图书类别描述</th>
				<th>修改</th>
			</tr>
			<c:forEach items="${requestScope.bookTypes}" var="bookType">
			<tr onmouseover="this.bgColor='#5e92e7'" onmouseout="this.bgColor='white'">
				<td>${bookType.bookTypeId}</td>
				<td>${bookType.parentId}</td>
				<td>${bookType.bookTypeName}</td>
				<td>${bookType.isDelete}</td>
				<td>${bookType.context}</td>
				<td><a href="FindBookTypeByIdServlet?bookTypeId=${bookType.bookTypeId}">修改</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="1">
					<a href="InitParentIdServlet">新增</a>
				</td> 
				<td colspan="2">
					<a id="keyong" href="#" onclick="changeStates(1, this)">可用</a>　
					<a id="bukeyong" href="#" onclick="changeStates(2, this)">不可用</a>　
					<a id="quanbu" href="#" onclick="changeStates(3, this)">所有</a>
				</td>
				<td colspan="3">
					共${pageCount}页　 
					第${nowPage}页　
					<%if(nowPage == 1 || pageCount == 0) {%>
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
  		var url = "${pageContext.request.contextPath}/FindAllBookTypeServlet?nowPage=" + nowPage + "&states="+states;
  		pointer.href=url;
   }
   
   function goNowPage(nowPage) {
  		var url = "${pageContext.request.contextPath}/FindAllBookTypeServlet?nowPage=" + nowPage + "&states="+states;
  		window.location=url;
   } 
   
   	function changeStates(myStates, pointer1){
  		states = myStates;
  		gotoNowPage(1, pointer1);
  	}
   	function init() {
   		var tag = "quanbu";
		if(states == '1') {
			tag = "keyong";
		} else if(states == '2') {
			tag = "bukeyong";
		} 
		document.getElementById(tag).style.backgroundColor = 'yellow';
		document.getElementById("selectNowPage").value = "<%=nowPage%>";
   	}
</script>
  
</html>
