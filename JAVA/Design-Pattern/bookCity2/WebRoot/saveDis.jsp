<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<BookDiscuss> dis = (List<BookDiscuss>)request.getAttribute("discuss");
	List<CustomerInfo> customerInfos = (List<CustomerInfo>)request.getAttribute("customerInfos");
	BookInfo bookInfo = (BookInfo)request.getAttribute("bookInfo");
	if(bookInfo == null || session.getAttribute("customerInfo") == null) {
		response.sendRedirect("denglu.jsp");
		return;
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
	.button_w130red {background:url(images/button_w130red.jpg)
					 no-repeat; 
					 width:130px; 
					 height:30px; 
					 line-height:30px; 
					 font-size:14px; 
					 color:#FFF;
					 font-weight:600;
					 border:none;
					 cursor:pointer;}
	#tright .ztpl h3 {background:url(images/tit_bggry.jpg) repeat-x;}
</style>
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
  <form id="appraiseForm" method="post" action="SaveBookDiscussServlet" name="myform">
  <!-- 主体上部右边大的部分 -->
	  <div id="tright">
     <div class="ztpl">
     <h3 style="color:black;font-weight:bold;"><!--a href="#"-->我要对“<%=bookInfo.getBookName()%>”评论<!--/a--></h3>
     <p>&nbsp;</p>
     <div class="clearfloat"></div>
		<dl>
            <dt style="color:black;"><img src="images/guest.jpg" width="50" height="50" alt="头像"><br><%=((CustomerInfo)session.getAttribute("customerInfo")).getCustomerName()%></dt>
            <dd>
            <p style="color:black;"><strong >评论：</strong>(必填 5000字以内)</p>
             <textarea name="context" cols="" rows="12" style="width: 588px; margin-left: 0px; margin-right: 0px; margin-top: 0px; margin-bottom: 0px; height: 180px; "></textarea>
             
             <span style="font-size:14px;">
             <input id="btnPost" type="button" class="button_w130red" value="提 交" onclick="javascript:myform.submit()">
             </span><br/><br/></dd>            
        </dl>
      <div class="clearfloat space10px"></div>
      </div>
      
	<input type="hidden" name="bookId" value="<%=bookInfo.getBookId()%>">
	<input type="hidden" name="appraise.goodsNo" value="1200061203">
   <!--/左侧结束 pleft--></div>
   </form>
   
   
   <div id="tleft">
     <div class="user_jcpl">
      <h3><img src="images/spxx.jpg"/></h3>
        <dl>
         <dt><a href="#"><img src="<%=basePath%>upload/images/<%=bookInfo.getBigImg()%>" width="98" height="113"></a></dt>
           <dd><a href="#"><font class="fong_blue"><%=bookInfo.getBookName()%></font></a><br>
           原价：￥38.00<br>
           <span class="font_red">现价：￥26.60</span></dd>
           <dd><a href="" onclick="#"><img src="images/shopping5.jpg" alt="收藏" width="55" border="0"></a> <a href="GwcServlet?opType=addBook&id=<%=bookInfo.getBookId()%>" onclick=""><img src="images/shopping4.gif" alt="购买" width="55" height="20" border="0"></a> </dd>
         </dl>
      </div>
   <!--/右侧结束 pright--></div>
	
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