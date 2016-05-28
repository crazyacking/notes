<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	if(session.getAttribute("customerInfo") == null) {
		response.sendRedirect("InitIndexServlet");
		return;
	}
	int mode =Integer.parseInt(request.getParameter("mode"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/css.css">
<link type="text/css" rel="stylesheet" href="css/help.css">
<link type="text/css" rel="stylesheet" href="css/user_center.css">
<style>
	.navtop{background-image:url(images/yonghu_03.gif);}
	.navtop1{background-image:url(images/yonghu_11.gif);}
	.height1 {background-image:url(images/height1.jpg);}
	.nav1 a:hover {background-image:url(images/yonghu_08.gif);}
	.rt1 {background-image:url(images/yonghu_06.gif);}
	.rt2 {background-image:url(images/yonghu_20.gif);}
	.tanhao {background-image:url(images/warning.png);}
	.nnav {background-image:url(images/yonghu_13.gif);}
	.bnav {background-image:url(images/yonghu_133.gif);}
	.button, .button:visited {background-image:url(images/yonghu_16.gif);}
	
</style>
<jsp:include page="includes.jsp"></jsp:include>
</head>
<body>
<div class="weizhi">
<!-- 网站头部 -->
<div class="toudi">
		<jsp:include page="header.inc.jsp"></jsp:include>
        <!--/网页头部-->
			<div class="center" style="margin-top:15px;">
			<!--网站左面 -->
			<div class="left w171" style="margin:0px; padding:0px;">
			<div class="w171 bian bshui tcenter">
			<div class="navtop"></div>
			<div class="nav1">
			<a href="ShowMyOrderServlet" class="nav">所有订单</a>
			</div>
			<div class="height1"></div>
			<div class="nav1">
			<a href="ShowMyOrderServlet?states=1" class="nav">等待确认的订单</a>
			</div>
			<div class="height1"></div>
			<div class="nav1">
			<a href="ShowMyOrderServlet?states=2" class="nav">处理中的订单</a>
			</div>
			<div class="height1"></div>
			<div class="nav1">
			<a href="ShowMyOrderServlet?states=3" class="nav">已完成的订单</a>
			</div>
			<div class="zhanwei2"></div>
			</div>
			<div class="zhanwei"></div>
			<div class="w171 bian bshui tcenter">
			<div class="navtop1"></div>
			<div class="nav1">
			<a href="ShowMyFavoriteServlet" class="nav">收藏夹</a>
			</div>
			<div class="height1"></div>
			<div class="nav1">
			<a href="customerOrderForm.jsp?mode=4" class="nav">帐户余额</a>
			</div>
			<div class="height1"></div>
			<div class="nav1">
			<a href="customerOrderForm.jsp?mode=2" class="nav">修改密码</a>
			</div>
			<div class="height1"></div>
			<div class="nav1">
			<a href="InvalidateServlet?opType=exit" class="nav" onclick="return confirm('你确定退出')">退出系统</a>
			</div>
			<div class="zhanwei2"></div>
			</div>
			</div><!--网站右面 -->
			<div class="right w762">
			<div class="daohang100">
			<!--所有订单 -->
			<div class="left top3" style="margin:0px; padding:0px; text-align:left;"><a href="InitIndexServlet">首页</a> &gt; <a href="#">我的帐户</a> &gt; <a href="ShowMyOrderServlet">订单信息</a> &gt; 
			<%if(mode == 1) {
				  out.print("所有订单");
			  } else if(mode == 2) {
				  out.print("修改密码"); 
			  } else if(mode == 3) {
				  out.print("收藏夹");
			  } else if(mode == 4) {
				  out.print("账户余额");  
			  } else if(mode == 5) {
				  out.print("订单详细信息"); 
			  }
			%></div>
			<div class="right tanhao qianhui">客服工作时间：周一至周五 8:30-17:00 &nbsp;&nbsp;</div>
			</div>
			<%if(mode == 1) { %>
					<jsp:include page="rightOrder.inc.jsp"></jsp:include>
			<%} else if(mode == 2) {  %>  
					<jsp:include page="change_password.inc.jsp"></jsp:include>
			<%} else if(mode == 3) {  %>
					<jsp:include page="favorite.inc.jsp"></jsp:include>
			<%
			  } else if(mode == 4) {  %>
					<jsp:include page="chongzhi.inc.jsp"></jsp:include>				
			<%
			  } else if(mode == 5) { %>
			  		<jsp:include page="showFgOrderDetail.inc.jsp"></jsp:include>
			<% 
			  }
			%>	
			
			</div>
			</div>
			<div style="clear:both; width:0px; height:0px;"></div>
			 <div style="margin-top:15px;">
			 <table width="100%" border="0" cellspacing="0" cellpadding="0"><tbody><tr><td> 
				<div class="dibu" style="clear:both;"></div>
			<div style="padding:15px 0 20px 0px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			 <tbody><tr>
			   <td align="center"></td>
			  </tr>
			</tbody></table>
			</div>
			</td></tr></tbody></table>  
			</div>
			</body>
		</html>