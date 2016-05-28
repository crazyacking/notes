<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%@page import="com.ht.gwc.*" %>

<div class="weizhi">
 	<!-- 网站头部 -->
<div style="height:76px;">
		<!-- logo区 -->
		<div class="logo"> <img src="images/logo.jpg" /> </div>
		<!-- 导航区 -->
		<div class="daohang">
			<ul class="top1" style="width:100%;">
					<li class="top">
					<%
						CustomerInfo cus = (CustomerInfo)session.getAttribute("customerInfo");
						if(cus == null) {
					%>
					<a href="<%=request.getContextPath()%>/denglu.jsp">[ 请登录 ]</a> &nbsp;
					<a href="zhuce.jsp">[ 免费注册 ]</a> &nbsp;
					<a href="<%=request.getContextPath()%>/gwc.jsp">购物车</a>
					<a href="denglu.jsp">我的订单</a>
					<%
						} else {
					%>
					<font color="blue" size="5"><%=cus.getCustomerName()%></font>您好，欢迎光临 &nbsp;
					<a href="ShowMyOrderServlet">我的订单</a>
					<a href="<%=request.getContextPath()%>/gwc.jsp">购物车</a>
					<a href="InvalidateServlet?opType=exit" onclick="return confirm('你确定退出')">退出</a>
					<% 
						}
					%>
					</li>
			</ul>

			<!-- 购物车 -->

		</div>

	</div>
	
	<div>
	<ul>
	<li class="daoshou"><a href="InitIndexServlet">Home</a><br><span class="xiaod">首页</span></li>
	<li class="daodao"><a href="#">Literature</a><br><span class="xiaod">文学馆</span></li>
	<li class="daodao"><a href="#">Art</a><br><span class="xiaod">艺术馆</span></li>
	<li class="daodao"><a href="#">Business</a><br><span class="xiaod">商业馆</span></li>
	<li class="daodao"><a href="#">Life</a><br><span class="xiaod">生活馆</span></li>
	<li class="daodao"><a href="#">Children</a><br><span class="xiaod">少儿馆</span></li>
	<li class="daodao"><a href="#">Entertainment</a><br><span class="xiaod">娱乐馆</span></li>
	</ul>
	</div>
	
	
	<div class="xindao">
<form method="post" name="search_product" action="#">
		<div class="seck1">
			<input name="search_keyword" type="text" class="index_input1">
		</div>
		<div class="selet">

			<select name="search_product_class" class="index_select1">

				<option value="0">All</option>

				
				<option value="1">Arts &amp; Photography</option>

				
				<option value="3">Biographies &amp; Memoirs</option>

				
				<option value="4">Business &amp; Investing</option>

				
				<option value="6">Children's Books</option>

				
				<option value="8">Comics &amp; Graphic Novels</option>

				
				<option value="9">Computers &amp; Internet</option>

				
				<option value="10">Cooking, Food &amp; Wine</option>

				
				<option value="12">Entertainment</option>

				
				<option value="13">Families &amp; Parenting</option>

				
				<option value="14">Health, Mind &amp; Body</option>

				
				<option value="15">History</option>

				
				<option value="16">Home &amp; Garden</option>

				
				<option value="17">Literature &amp; Fiction</option>

				
				<option value="19">Nonfiction</option>

				
				<option value="20">Outdoors &amp; Nature</option>

				
				<option value="22">Professional &amp; Technical</option>

				
				<option value="24">Reference</option>

				
				<option value="27">Science</option>

				
				<option value="30">Sports</option>

				
				<option value="32">Textbooks</option>

				
				<option value="33">Travel</option>

				
				<option value="34">General</option>

						

			</select>

		</div>

		<div class="secbtn1">

			<input name="submit" type="image" src="images/sousuoanniu.jpg">

		</div>

	  </form>
	<div class="che1">

				<table width="100%" border="0" cellspacing="0" cellpadding="0">

				  <tbody><tr>

					<td width="18%" align="right"><img src="images/gouwuche1.gif"></td>
					
					<td width="50%" align="left">
						<%
							Object objGwc = session.getAttribute("gwc");
							if(objGwc == null || ((Gwc)objGwc).getItems().size() == 0) {
						%>
							您还没有购买商品
						<%} else {
							Gwc gwc = (Gwc)session.getAttribute("gwc");
							Collection<GwcItem> items = gwc.getItems();
							double[] sum = gwc.getSumPrice();
						%>
							<a href="">购物车中有</a>&nbsp;<%=gwc.getNum()%>件商品
						<%} %>
					</td>
					
					<td width="32%">
						<c:if test="${empty sessionScope.customerInfo}" var="result" >
							<a href="denglu.jsp"><img src="images/gouniu.jpg"></a>
						</c:if >
						<c:if test="${!result}">
         					<a href="gwc.jsp"><img src="images/gouniu.jpg"></a>
         				</c:if>
					</td>

				  </tr>

				</tbody></table>

			</div>
</div>
	<!-- 导航变化区域 -->
	<div style="CLEAR: both"></div>
</div>