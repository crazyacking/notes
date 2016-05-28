<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.gwc.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<BookInfo> books = (List<BookInfo>)request.getAttribute("books");
	if(books == null) {
		response.sendRedirect("InitIndexServlet");
		return;
	}
	//拿到所有类别的集合
	List<BookType> bookTypes = (List<BookType>)request.getAttribute("bookTypes");
	//拿到所有根类别的集合
	List<BookType> typeList = (List<BookType>)request.getAttribute("typeList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书销售平台</title>
<link type="text/css" rel="stylesheet" href="css/ajax_css.css">
<script language="javascript" src="js/ajax_left_menu.js" type="text/javascript"> </script>
<script language="javascript" src="js/ajax_elements.js" type="text/javascript"> </script>
<script language="javascript" src="js/elements_book_kind.js" type="text/javascript"> </script>
<script src="js/jquery-1.4a2.min.js" type="text/javascript"></script>
<script src="js/jquery.KinSlideshow-1.1.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$("#KinSlideshow").KinSlideshow({
			moveStyle:"down",
			intervalTime:8,
			mouseEvent:"mouseover",
			titleFont:{TitleFont_size:14,TitleFont_color:"#FF0000"}
	});
	$("#find").click(function() {
		if($("#bookName").val() == '' && $("#author").val() == '') {
			alert('请输入一个查询条件');
			return false;
		} else {
			return true;
		}
	});
})

</script>
<style type="text/css">
		h1.title{ font-family:"微软雅黑",Verdana; font-weight:normal}
		.code{ height:auto; padding:20px; border:1px solid #9EC9FE; background:#ECF3FD;}
		.code pre{ font-family:"Courier New";font-size:14px;}
		.code pre code.note{ color:#999}
		.code2{border:1px solid #FEB0B0; background:#FFF1F1; margin-top:10px;}
		.code2 pre{ margin-left:20px; font-size:12px;}
		.info{ font-size:12px; color:#666666; font-family:Verdana; margin:20px 0 50px 0;}
		.info p{ margin:0; padding:0; line-height:22px; text-indent:40px;}
		h2.title{ margin:0; padding:0; margin-top:50px; font-size:18px; font-family:"微软雅黑",Verdana;}
		h2.title span.titleInfo{ font-size:12px; color:#333; margin-left:10px;font-family:Verdana;}
		h3.title{ font-size:16px; font-family:"微软雅黑",Verdana;}
		.importInfo{ font-family:Verdana; font-size:14px;}
</style>
<jsp:include page="includes.jsp"></jsp:include>
</head>
<body>
<div style="width:950px; margin-left:auto; margin-right:auto;">
<div class="weizhi">
<div>   
	<div class="weizhi">
 	<!-- 网站头部 -->
  		<jsp:include page="header.inc.jsp"></jsp:include>
  		

	<!-- 导航变化区域 -->

	<div style="CLEAR: both"></div>
</div>
</div>
<div style="padding-bottom:4px;">
<a href="#" target="_blank"><img width="950" src="images/kid2.jpg"></a>
<div>
</div>
</div>
<div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td valign="top">
    <div class="mrl_copy">
			<!--图像轮播器-->
				<div id="KinSlideshow" style="visibility:hidden;">
        			<a href="" target="_blank"><img src="images/1.jpg" alt="" width="680" height="300" /></a>
        			<a href="" target="_blank"><img src="images/2.jpg" alt="" width="680" height="300" /></a>
        			<a href="" target="_blank"><img src="images/3.jpg" alt="" width="680" height="300" /></a>
        			<a href="" target="_blank"><img src="images/4.jpg" alt="" width="680" height="300" /></a>
        			<a href="" target="_blank"><img src="images/5.jpg" alt="" width="680" height="300" /></a>
        			<a href="" target="_blank"><img src="images/6.jpg" alt="" width="680" height="300" /></a>
				</div>
	</div>
     <div class="zhanwei2"></div>
       <div style="padding:0px 3px 0 5px; clear:both;">
    <a href="#"><img src="images/y11.jpg"></a><a href=""><img src="images/t11.jpg"></a></div>
    </td>
    <td width="260" valign="top">
    <table width="260" border="0" cellpadding="0" cellspacing="0">
      <tbody><tr>
        <td height="30">
        <div class="paihang"><span class="da">图书搜索&nbsp;News</span></div></td>
      </tr>

	   <tr>
        <td>
		<div class="paihangdi">
				<ul>
						<form action="<%=request.getContextPath()%>/FindBookInfoByIndexServlet" method="post" name="findForm">	
						<li class="gonggao">&nbsp;</li>
						<li class="gonggao"><font color="blue">书名:</font><input type="text" name="bookName" id="bookName"/></li>
						<li class="gonggao">&nbsp;</li>
			          	<li class="gonggao"><font color="blue">作者:</font><input type="text" name="author" id="author"/></li>
			          	<li class="gonggao">&nbsp;</li>
			          	<li class="gonggao">
			          		<input type="submit" value="搜索"  style="cursor:pointer;width:70px;height:18px;border:none;background:#3360a1;color:white"  id="find"/>
			          		<input type="submit" value="组合搜索"  style="cursor:pointer;width:70px;height:18px;border:none;background:#3360a1;color:white"/>
			          	</form>
			          	</li>
        		</ul>
		  </div>
		  </td>
      </tr>
    </tbody></table>
    <div class="zhanwei2"></div>
    <a href="#" target="_blank"><img src="images/index_sina_microblog.jpg">
      <div class="zhanwei2"></div>
      </a><a href="#"><img src="images/tuijian3.jpg" border="0"></a> </td>
  </tr>
</tbody></table>

</div>
  <div class="zhanwei2"></div>
  <!-- 主体的上部 --> 	
  	<!-- 一个大分类 -->
	<div class="maintop">
    <div class="tl">
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
      <div class="zhanwei2"></div>
	  <div style="margin-top:5px;">
	    <a href="http://www.readgoal.com/readgoal/index.php/recommend_theme/dictionary" target="_blank"><img src="images/x9.jpg" border="0"></a> </div>

		 <div style="margin-top:5px;">
	       <a href="http://www.readgoal.com/readgoal/index.php/recommend_theme/eng" target="_blank"><img src="images/x11.jpg" border="0"></a> </div>
		 

    <div style="margin-top:5px;">
	       <a href="#" target="_blank"><img src="images/xt7.jpg" border="0"></a> </div>	
           	<div class="zhanwei2"></div>
	</div>
    <div class="maintopr">
	<div class="ttz">
 <div class="ttz biankuangp ttrh1">
	<div class="da paaddingzi d5803d" style="margin-bottom:15px;"><span class="">编辑推荐&nbsp;Editor Recommends</span> </div>
	 <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
	  	
    <td width="56%" valign="top" style="padding-left:12px;">
    	<a href="ShowOneBookInfoServlet?bookId=<%=books.get(21).getBookId()%>" style="padding-right:8px;"><img src="<%=basePath%>upload/images/<%=books.get(21).getSmallImg()%>" width="80"></a><a href="ShowOneBookInfoServlet?bookId=<%=books.get(22).getBookId()%>" style="padding-right:8px;"><img src="<%=basePath%>upload/images/<%=books.get(22).getSmallImg()%>" width="80"></a><a href="ShowOneBookInfoServlet?bookId=<%=books.get(23).getBookId()%>"><img src="<%=basePath%>upload/images/<%=books.get(23).getSmallImg()%>" width="80"></a></td>
    <td width="44%" valign="top" style="line-height:18px; padding-left:10px; padding-bottom:20px;">
   	 <b style="font-size:12px;"><a href="#">1.<%=books.get(21).getBookName()%></a></b><br>&nbsp;&nbsp;姐姐的守护者<br>
   <div class="zhanwei2" style="border-top:dashed 1px #bcbcbc; margin-top:4px;"></div>
     <b style="font-size:12px;"><a href="#">2.<%=books.get(22).getBookName()%></a></b><br>&nbsp;&nbsp;心尘往事<br>
    <div class="zhanwei2" style="border-top:dashed 1px #bcbcbc;margin-top:4px;"></div>
    <b style="font-size:12px;"><a href="#">3.<%=books.get(23).getBookName()%></a></b><br>&nbsp;&nbsp;小心安放
    </td>
    
  </tr>
</tbody></table>
<table>
 <tbody><tr>
  <td>
    <a href="#"><img src="images/55.jpg" width="480" height="103"></a></td>
  </tr>
  </tbody></table>
<div class="zhanweio"></div>
	</div>
     <div class="zhanwei2"></div>
    <div class="zhanwei2"></div>
	<div class="zhanwei2"></div>
<div class="ttz biankuangp ttrh1">
	<div class="da paaddingzi d5803d">新书上架&nbsp;New Releases </div>
	<% for(int i = 0; i < 6; i++) {
		BookInfo book = books.get(i);
	%>
	<li class="mainbookzhan3w mleft">
	<div class="zhengfang" style="height:120px;">
		<span class="zhengfang" style="height:120px;">
			<a target="_parent" href="ShowOneBookInfoServlet?bookId=<%=book.getBookId()%>">
				<img src="<%=basePath%>upload/images/<%=book.getSmallImg()%>" height="120">
			</a>
		</span>
	</div>
	<a class="ilanse xiahua" target="_parent" href="ShowOneBookInfoServlet?bookId=<%=book.getBookId()%>"><%=book.getBookName()%>
	</a><br><br>
		<span class="ihuaxian">￥<%=book.getPrice()%></span><span class="hong">￥<%=book.getSpecialPrice()%></span><br>
	</li>
	<%}%>
	
<div class="zhanweio"></div>
	</div>	
	
	<div class="zhanwei2"></div>
	<a href="http://www.readgoal.com/readgoal/index.php/recommend_theme/year100"><img src="images/ad31.jpg"></a>
	<div class="zhanwei2"></div>
	<div class="ttz biankuangp ttrh1" style="height:300px;">
	<div class="da paaddingzi d5803d">本周特价&nbsp;Offer This Week  </div>
	<%
		for(int i = 6; i < 9; i++) {
			BookInfo bookInfo = books.get(i);
		
	%>
	<li class="mainbookzhan3w mleft">
	<div class="zhengfang" style="height:120px;"><span class="zhengfang" style="height:120px;">
		<a target="_parent" href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>">
			<img src="<%=basePath%>upload/images/<%=bookInfo.getSmallImg()%>" height="120">
		</a></span></div>
	<a class="ilanse xiahua" target="_parent" href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName()%></a><br><br>
	<span class="ihuaxian">￥<%=bookInfo.getPrice()%></span><span class="hong">￥<%=bookInfo.getSpecialPrice()%></span>
	</li>
	<%
		}
	%>
	
	
<div class="zhanweio"></div>
	</div>
	
<!-- command -->	
<div class="ttz biankuangp ttrh1">
	<div class="da paaddingzi d5803d">本周推荐&nbsp;Commend This Week  </div>
	<%
		for(int i = 9; i < 15; i++) {
			BookInfo bookInfo = books.get(i); 
	%>
	<li class="mainbookzhan3w mleft">
	<div class="zhengfang" style="height:120px;">
		<span class="zhengfang" style="height:120px;">
		<a target="_parent" href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>">
			<img src="<%=basePath%>upload/images/<%=bookInfo.getSmallImg()%>" height="120">
		</a></span>
	</div>
	<a class="ilanse xiahua" target="_parent" href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName()%></a><br><br>
	<span class="ihuaxian">￥<%=bookInfo.getPrice()%></span><span class="hong">￥<%=bookInfo.getSpecialPrice()%></span>
	</li>
	<%
		}
	%>
	<div class="zhanweio"></div>
</div>
</div>
	
	<div class="ttr">
       <table width="260" border="0" cellpadding="0" cellspacing="0">
      <tbody>
      <tr>
        <td height="30">
        <div class="paihang"><span class="da">销售排行&nbsp;Bestsellers</span></div></td>
      </tr>
	   <tr>
        <td>
		<div class="paihangdi">
		<% 
			for(int i = 0; i < 10; i++) {
				BookInfo bookInfo = books.get(i);
		%>
		 		 <table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tbody><tr>
				<td width="29%" align="center">
				<a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>">
				<img src="<%=basePath%>upload/images/<%=bookInfo.getSmallImg()%>" width="50"></a>				
				</td>
				<td width="71%" valign="top" style="padding-right:5px;">
				<span class="hong dada"><%=i+1%>.</span><a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>">
				<%=bookInfo.getBookName()%></a> 
				<div class="sn">
				 	Best Book:
				</div>
				<span class="huaxian ">￥<%=bookInfo.getPrice() %></span>
				<span class="hong">￥<%=bookInfo.getSpecialPrice()%></span>
				</td>
			  </tr>
		  </tbody></table>
		  <div class="zhanwei10"></div>
	  <%}%>
		  		  </div>
		  </td>
      </tr>
	
    </tbody></table>  		
	   <div class="zhanwei2"></div>
	   <table width="260" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
	   <tbody>
		<%for(int k = books.size(); k > books.size() - 3; k--) { 
			BookInfo bookInfo = books.get(k - 1);
		%>
			   	
	<tr>
        <td bgcolor="#FFFFFF" style="padding:8px 0;">
		<div class="da" style="padding-left:12px; padding-bottom:8px;"> <a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>"><%=bookInfo.getBookName()%></a></div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tbody><tr>
				<td width="38%" class="bujuk">
				<a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>"><img src="<%=basePath%>upload/images/<%=bookInfo.getSmallImg()%>" width="75" border="0"> </a>			
				<span><% 	String str = bookInfo.getContext();
							if(str.length() > 300) {
								str = bookInfo.getContext().substring(0, 260);
							}
							out.print(str);
					  %>
.... </span>
</td>
			  </tr>
		  </tbody>
		  </table>
		  </td>
      </tr>	
      <% } %>
    </tbody>
    </table>
	<div class="zhanwei2"></div>
	
  </div>
	</div>
    </div>

	<div class="zhanwei2" style="height:2px;"></div>
  <div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="dibei">
      <tbody><tr>
        <td width="4%" height="20">&nbsp;</td>
        <td width="18%" height="32"><br>
          <span class="ti">新手上路</span></td>
        <td width="19%" height="32"><br>
          <span class="ti">付款方式</span></td>
        <td width="21%" height="32"><br>
          <span class="ti">配送方式</span></td>
        <td width="19%" height="32"><br>
          <span class="ti">售后服务</span></td>
        <td width="19%"><br>
         <span class="ti">退换货流程</span></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="20" class="width_1"><a href="http://www.readgoal.com/help/help.php?article_id=607">· 新用户注册</a></td>
        <td height="20" class="b_middle"><a href="http://www.readgoal.com/help/help.php?article_id=605">· 支付方式</a></td>
        <td height="20" class="b_middle"><a href="http://www.readgoal.com/help/help.php?article_id=604">· 运费收取标准</a></td>
        <td height="20" class="b_middle"><a href="http://www.readgoal.com/help/help.php?article_id=604">· 服务保障承诺</a></td>
        <td class="b_middle"><a href="http://www.readgoal.com/help/help.php?article_id=604">· 服务保障承诺</a></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="20" class="width_1"><a href="http://www.readgoal.com/help/help.php?article_id=608">· 怎样下订单</a></td>
        <td height="20" class="b_middle"><a href="http://www.readgoal.com/help/help.php?article_id=606">· 网上支付常见问题</a></td>
        <td height="20" class="b_middle"><a href="http://www.readgoal.com/help/help.php?article_id=613">· 配送时间和配送范围</a></td>
        <td height="20" class="b_middle">&nbsp;</td>
        <td class="b_middle">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="20" class="width_1">&nbsp;</td>
        <td height="20" class="b_middle">&nbsp;</td>
        <td height="20">&nbsp;</td>
        <td height="20" class="b_middle">&nbsp;</td>
        <td class="b_middle">&nbsp;</td>
      </tr>
    </tbody></table>
    
	<jsp:include page="footer.inc.jsp"></jsp:include>
	
</div>
<!-- ShareTo Button BEGIN -->
<script type="text/javascript" src="images/shareto_float.js" charset="utf-8"></script> 
<!-- ShareTo Button END -->		
</div>
</div>
</body>
</html>