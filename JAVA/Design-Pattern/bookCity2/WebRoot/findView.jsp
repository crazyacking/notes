<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	List<BookType>	typeList = (List<BookType>)request.getAttribute("typeList");
	
	int pageCount = (Integer)request.getAttribute("pageCount");
	List<BookInfo> bookInfos = (List<BookInfo>)request.getAttribute("bookInfos");
	int size = (Integer)request.getAttribute("size");
	int nowPage = (Integer)request.getAttribute("nowPage");
	String bookName = request.getParameter("bookName");
	String author = request.getParameter("author");
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
  <div class="ttr">

    <div class="zhanwei2"></div>
      	
	    <div class="zhanwei2"></div>
	
	   <div class="zhanwei2"></div>
  </div>
  <!-- 左侧分类信息-->
  	<div class="ml">
    <div class="zuopaihang"><span class="da d666">图书分类&nbsp;Categories</span></div>
      <div class="daoz" style="height:100%;">
        <div class="zhanwei2"></div>
            <div class="tushus" id="tabap16_div_0">
               <%for(BookType bookType : typeList) {%>
						<div class="daod"><a href="ShowTitleOneServlet?bookTypeId=<%=bookType.getBookTypeId()%>"><%=bookType.getContext()%><br/> 
						<span class="daox5"><%=bookType.getBookTypeName()%></span> </a> 
					</div> 
					<div class="zhanwei3"><img src="images/in_94.gif" /></div> 
			  <%}%>
				</div>
        </div>
      </div>
      <!-- 左侧分类信息end -->
			  <div class="maintopr">
			  <div class="search_line20">
					搜索
				<span class="da hong">“
					<% 
						if(author != null) {
					%>
						<%=author%>&nbsp;
					<%
						}
					%>
					
					<%
						if(bookName != null) {
					%>
						<%=bookName%>
					<% 		
						}
					%>
				”</span>
					结果:
			  </div>
			  <div id="search_result_list" class="liebiaobian">
			  <%
					if(size != 0) {			  
			  			for(BookInfo book :bookInfos) {
			  
			  %>
			 
			  <div class="dibian">
				<span class="s1">
					<a href="ShowOneBookInfoServlet?bookId=<%=book.getBookId()%>"> 
						<img width="85" border="0" src="<%=basePath%>upload/images/<%=book.getSmallImg()%>">
					</a>
				</span>
				<ul>
					<li class="l1"> 
						<a href="">
							<%=book.getBookName()%>
						</a>
					</li>
					<li class="l2">作者:<%=book.getAuthor()%></li>
					<li class="l2">图书编号:<%=book.getBookId()%></li>
					<li class="l2">出版社:<%=book.getPublishName()%>&nbsp;&nbsp;&nbsp;出版时间:<%=book.getPublishDate()%></li>
					<li class="l4">
						定价：
						<span class="huaxian">￥<%=book.getPrice()%></span>
						<span class="whith">会员价：</span>
						<span class="hong da">￥<%=book.getSpecialPrice()%></span>
						<span class="leftwidth">
							<a target="_blank" href="GwcServlet?opType=addBook&id=<%=book.getBookId()%>">
								<img border="0" alt="购买" src="images/addshopxiao.jpg">
							</a>
						</span>
						<span>
							<a target="_blank" href="#">
								<img border="0" alt="收藏" src="images/addlovexiao.jpg">
							</a>
						</span>
					</li>
				</ul>
			</div>
			<%}
				}%>
			
            <div>
            	<ul>
					<li style="text-align:right;">
						共有<%=size%>条数目,现在第 <%=nowPage%>页/共<%=pageCount%>页
						<% if(nowPage == 1 || pageCount == 0) { %>
								 [第一页]&nbsp;
								 [上一页]&nbsp;
						<% } else { %>		 	
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByIndexServlet?nowPage=1&author=<%=author%>&bookName=<%=bookName%>">[第一页]</a>　
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByIndexServlet?nowPage=<%=(nowPage-1)%>&author=<%=author%>&bookName=<%=bookName%>" onclick="goNowPage(<%=(nowPage-1)%>)">[上一页]</a>
						<% }%>
						
						<%if(nowPage == pageCount || pageCount == 0) {%>
								[下一页]&nbsp;
								[最末页]
						<%} else { %>
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByIndexServlet?nowPage=<%=(nowPage+1)%>&author=<%=author%>&bookName=<%=bookName%>">[下一页]</a>　
								<a target="_self" href="<%=request.getContextPath()%>/FindBookInfoByIndexServlet?nowPage=<%=pageCount%>&author=<%=author%>&bookName=<%=bookName%>">[最末页]</a>
						<%}%>				
						　
						　
					</li>
				</ul>	
            </div>
			</div>
			</div>
<!-- /用户登陆-->
<div style="clear:both; height:3px; overflow:hidden;"></div>
<div class="zuidi">
    <div class="dibu">
</div>

<div class="pdd">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 <tbody><tr>
   <td align="center"> </td>
  </tr>
</tbody></table>
</div>
</div>
</div>
</div>
</body>
</html>