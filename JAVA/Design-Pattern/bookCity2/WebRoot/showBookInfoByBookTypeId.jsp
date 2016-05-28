<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<BookInfo> bookInfos = (List<BookInfo>)request.getAttribute("bookInfos");
	
	int size = (Integer)request.getAttribute("size");
	int nowPage = (Integer)request.getAttribute("nowPage");
	int pageCount = (Integer)request.getAttribute("pageCount");
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
  <div class="tl"> 
    <div class="ml"> 
	<div class="zuopaihang"><span class="da d666">图书分类&nbsp;Categories</span></div> 
      <div class="daoz" style="height:100%;"> 
        <div class="zhanwei2"></div> 
	  <c:forEach items="${bookTypes}" var="bookType">      	   
      <div class="tushus" id=tabap16_div_0 > 
            <div class="daod">
            	<a href="FindBookInfoByBookTypeServlet?bookTypeId=${bookType.bookTypeId}&mode=2" target="_self">${bookType.context}<br/> <span class="daox5">${bookType.bookTypeName}</span> </a> 
            </div> 
            <div class="zhanwei3"><img src="images/in_94.gif" /></div> 
        </div>	
      </c:forEach>
      	
        </div> 
      </div> 
    <div class="zhanwei2"></div> 
    <%--<table width="187" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC"> 
  <tr> 
    <td height="30" align="center" bgcolor="#FFFFFF"><span class="da"><a href="javascript:void(0);">您浏览过的记录</a></span></td> 
  </tr> 
  <tr> 
    <td bgcolor="#FFFFFF"> 
    <div id="visit_list_box"></div> 
    </td> 
  </tr> 
</table> 
  --%></div> 
 </div> 
   
  <!-- 主体上部右边大的部分 --> 
  <div class="maintopr"> 
    <!-- 主体上部右边大的部分左边部分 --> 
	<div class="line20">当前位置：<a href="InitIndexServlet">首页</a>
            &nbsp;&gt;&nbsp;${rootBookType.context}${rootBookType.bookTypeName} <c:if test="${!empty bType}">&gt;&nbsp;${bType.context} ${bType.bookTypeName}</c:if>                    
    </div>
    
    <table width="100%" height="32" border="0" cellpadding="0" cellspacing="0" bgcolor="#F0F0F0"> 
      <tr> 
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#F0F0F0"> 
          <tr> 
            <td width="4" height="20" bgcolor="#F0F0F0">&nbsp;</td> 
            <td width="85" valign="middle" bgcolor="#FFFFFF"><div class="line20">&nbsp;显示方式：</div></td> 
            <td width="109" valign="bottom" bgcolor="#FFFFFF" class="xiaotu"> 
 <a href="ChangeShowModeServlet?bookTypeId=${bType.bookTypeId}&nowPage=<%=nowPage%>&mode=1"><img src="images/tupianxiaotubiao.jpg" alt="列表模式" width="18" height="15" border="0"/></a> 
<img src="images/liebiaoxiaotubiaoxuanzhong.jpg" alt="图文模式" width="18" height="15" border="0"/> 
<a href="ChangeShowModeServlet?bookTypeId=${bType.bookTypeId}&nowPage=<%=nowPage%>&mode=3"><img src="images/wenzixiaotubiao.jpg" alt="文章列表模式" width="18" height="15" border="0"/></a> 
 </td> 
            <td width="84" bgcolor="#FFFFFF">&nbsp;</td> 
            <td width="242" bgcolor="#FFFFFF" class="xiaotu">&nbsp;</td> 
            <td width="450" bgcolor="#FFFFFF"></td> 
            <td width="4"></td> 
          </tr> 
        </table></td> 
      </tr> 
    </table> 
    </table> 
    <div> 
			<div class="liebiaobian1" id="li_b"> 
	<ul> 
	<%for(BookInfo bookInfo : bookInfos){%>
	<div class="dibian" > 
		<span class="s1"><a href="http://www.readgoal.com/readgoal/index.php/product/index/?id=5909"><img src="<%=basePath%>upload/images/<%=bookInfo.getSmallImg()%>" class="mimg"/></a></span> 
        <ul> 
          <li class="l1"><a href="http://www.readgoal.com/readgoal/index.php/product/index/?id=5909"><%=bookInfo.getBookName()%></a></li> 
          <li class="l2">作者：<%=bookInfo.getAuthor()%></li> 
          <li class="l2">出版社：<%=bookInfo.getPublishName()%> 出版时间:<%=bookInfo.getPublishDate()%></li> 
          <li class="l3"></li> 
          <li class="l4"> 定价：<span class="huaxian">￥144.00</span> <span class="whith">会员价：</span><span class="hong da">￥108.00</span> <span class="leftwidth"><a href="GwcServlet?opType=addBook&id=<%=bookInfo.getBookId()%>"> 
		        <img src="images/addshopxiao.jpg" border="0" />        		</a></span><span> 
		 <a href="http://www.readgoal.com/search/shoucang.php?id=5909"><img src="images/addlovexiao.jpg" border="0" /></a></span></li> 
        </ul> 
      </div> 
    <%} %>
	 
	</ul>      
	</div> 
		 
<div class="tommy_pagelist_box">
	<ul>
					<li style="text-align:right;clear:both">
						共有<%=size%>条数目,现在第 <%=nowPage%>页/共<%=pageCount%>页
						<% if(nowPage == 1 || pageCount == 0) { %>
								 [第一页]&nbsp;
								 [上一页]&nbsp;
						<% } else { %>		 	
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByBookTypeServlet?nowPage=1&bookTypeId=${bType.bookTypeId}&mode=2">[第一页]</a>　
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByBookTypeServlet?nowPage=<%=(nowPage-1)%>&bookTypeId=${bType.bookTypeId}&mode=2">[上一页]</a>
						<% }%>
						
						<%if(nowPage == pageCount || pageCount == 0) {%>
								[下一页]&nbsp;
								[最末页]
						<%} else { %>
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByBookTypeServlet?nowPage=<%=(nowPage+1)%>&bookTypeId=${bType.bookTypeId}&mode=2">[下一页]</a>　
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByBookTypeServlet?nowPage=<%=pageCount%>&bookTypeId=${bType.bookTypeId}&mode=2">[最末页]</a>
						<%}%>				
						　
						　
					</li>
				</ul>
</div>    </div> 
  </div> 
  <div class="zhanwei2"></div> 
 <div>    
		<jsp:include page="footer.inc.jsp"></jsp:include>
</div>  
</div> 
</body> 
</html>