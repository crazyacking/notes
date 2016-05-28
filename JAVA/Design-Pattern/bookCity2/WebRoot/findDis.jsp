<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<BookDiscuss> dis = (List<BookDiscuss>)request.getAttribute("discuss");
	List<CustomerInfo> customerInfos = (List<CustomerInfo>)request.getAttribute("customerInfos");
	BookInfo bookInfo = (BookInfo)request.getAttribute("bookInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="css/login_box.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/thickbox.min.js"></script>
<link href="css/thickbox.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="css/Global.css">
<link rel="stylesheet" type="text/css" href="css/user_pl(1).css">
<jsp:include page="includes.jsp"></jsp:include>
</head>
<body>
 
<div class="weizhi">
<!-- 网站头部 -->
<div class="toudi">
        <jsp:include page="header.inc.jsp"></jsp:include>
</div>
  <div class="zhanwei2"></div>

<!-- 主体的上部 -->
<div class="maintop">
  <!-- 左侧分类 -->
  <div class="ttr">

    <div class="zhanwei2"></div>
      	
	    <div class="zhanwei2"></div>
	
	   <div class="zhanwei2"></div>
  </div>
  <!-- 主体上部右边大的部分 -->
  
				<div class="page990">
   <div class="pl_spinfo">
      <h3 style="width:955px;"><a href="#"><%=bookInfo.getBookName()%></a></h3>
     <div class="pl_spinfo_div">
      <ul>
            <li><%=bookInfo.getContext()%></li>
            <li class="clear space10px"></li>
            <p>
            <span><a href="ShowOneBookInfoServlet?bookId=${requestScope.bookInfo.bookId}">
            		<img src="images/note_009.jpg" width="77" height="22">
            	  </a>
            	  <a href="GwcServlet?opType=addBook&id=<%=bookInfo.getBookId()%>" >
            	  	<img src="images/shopping4.gif" width="55" height="20">
            	  </a> 
            	  <a href="#" >
            	  	<img src="images/shopping5.jpg" width="55" height="21">
            	  </a>
             </span> 原价：￥<%=bookInfo.getPrice()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现价：<font class="font_red"><strong>￥<%=bookInfo.getSpecialPrice()%></strong></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;折扣：69折</p>
        </ul>
        <div class="pl_spinfo_div_rit"><img src="<%=basePath%>upload/images/<%=bookInfo.getBigImg()%>"></div>
        <div class="clear"></div>
       </div>
   <!-- /pl_spinfo --></div>
<div id="pleft"> 
      <div class="space10px"></div>
  <div class="ztpl">
  	<%
  		for(int i = 0; i <dis.size(); i++) {
		if(i == 0) {  				
  	%>
         <div class="ztpl_tit"><img src="images/p1_abouit.jpg" /></div>
         <h3 style="background:url(images/tit_bggry.jpg) repeat-x;"><img src="images/pl_wyx.jpg" class="floatrit" 
				<%
						/*
						 *如果客户没有登录则跳转到登录界面
						 *如果客户登录了则对该书进行评论
						 */
						CustomerInfo user = (CustomerInfo)session.getAttribute("customerInfo");
						if(user == null) {
					%>
						onclick="location.href='denglu.jsp'"
					<%} else { %>		
						
					 	onclick="location.href='ShowOneBookInfoServlet?opType=saveDis&bookId=<%=bookInfo.getBookId()%>'"
					 <%
					 	}
					 %>
		 
		 ></h3>
         <dl>
            <dt><img src="images/guest.jpg" width="50" height="50" alt="头像"><br><span class="fong_blue">
			<%
            	for(CustomerInfo customerInfo : customerInfos) {
            		if(customerInfo.getCustomerId() == dis.get(i).getCustomerId()) {
            %>
            		<%=customerInfo.getCustomerName()%>
            <%			
            			break;
            		}	
            	}
            %>
			</span></dt>
            
            <dd>
              <h4><%=dis.get(i).getContext()%></h4>
              <!-- 这里是主题评论标题，不包含任何标签 -->
            <span><%=dis.get(i).getWriteDate()%></span>
            </dd>            
         </dl>

         <div class="clearfloat space10px"></div>
         <div class="clear space10px"></div>
         <div class="clear space10px"></div>
         <div id="pageNav" class="pagebreak"><li>共有&nbsp;<%=dis.size()%>&nbsp;条记录　第<%=i+1%>条</li></div>
        <div class="clear space10px"></div>
  <!--/主题评论结束--></div>
  	<%}else { %>	
  		  <div class="ztpl">
         <div class="ztpl_tit"></div>
         <h3 style="background:url(images/tit_bggry.jpg) repeat-x;"><img src="images/pl_wyx.jpg" class="floatrit" 
        		   <%
						/*
						 *如果客户没有登录则跳转到登录界面
						 *如果客户登录了则对该书进行评论
						 */
						CustomerInfo user = (CustomerInfo)session.getAttribute("customerInfo");
						if(user == null) {
					%>
						onclick="location.href='denglu.jsp'"
					<%} else { %>		
						
					 	onclick="location.href='ShowOneBookInfoServlet?opType=saveDis&bookId=<%=bookInfo.getBookId()%>'"
					 <%
					 	}
					 %>
         ></h3>
         <dl>
            <dt><img src="images/guest.jpg" width="50" height="50" alt="头像"><br><span class="fong_blue">
            <%
            	for(CustomerInfo customerInfo : customerInfos) {
            		if(customerInfo.getCustomerId() == dis.get(i).getCustomerId()) {
            %>
            		<%=customerInfo.getCustomerName()%>
            <%			
            			break;
            		}	
            	}
            %>
            </span></dt>
            <dd>
              <h4><%=dis.get(i).getContext()%></h4>
              <!-- 这里是主题评论标题，不包含任何标签 -->
            <span><%=dis.get(i).getWriteDate() %></span>
            </dd>            
         </dl>

         <div class="clearfloat space10px"></div>
         <div class="clear space10px"></div>
         <div class="clear space10px"></div>
         <div id="pageNav" class="pagebreak"><li>共有&nbsp;<%=dis.size()%>&nbsp;条记录　第<%=i+1%>条</li></div>
        <div class="clear space10px"></div>
  <!--/主题评论结束--></div>
  <% } 
		}%>
      <div class="clearfloat space10px"></div>
    <!--/左侧结束 pleft-->
</div>
   
   <div id="pright">
     <div class="space10px"></div>
      <div class="user_jcpl">
        <h3></h3>
			
      </div>
   <!--/右侧结束 pright--></div>
   
  <!-- /page990 -->
</div>  		

	
<!-- /用户登陆-->
<div style="clear:both; height:3px; overflow:hidden;"></div>
<div class="zuidi">
    <div class="dibu">
</div>

<div class="pdd">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 <tbody><tr>
   <td align="center"></td>
  </tr>
</tbody></table>
</div>
</div>
</div></div></body></html>