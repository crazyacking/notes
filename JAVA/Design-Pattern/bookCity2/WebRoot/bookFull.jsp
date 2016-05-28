<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//将相应图书信息拿出显示
	BookInfo bookInfo = (BookInfo)request.getAttribute("bookInfo");
	List<BookDiscuss> discuss = (List<BookDiscuss>)request.getAttribute("discuss");
	List<BookInfo> books = (List<BookInfo>)request.getAttribute("books");
	BookType bookType = (BookType)request.getAttribute("bookType");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/thickbox.min.js"></script>
<link href="css/login_box.css" rel="stylesheet" type="text/css">
<link href="css/thickbox.css" rel="stylesheet" type="text/css">
<%--<script type="text/javascript">
	$(document).ready(function(){$('#visit_list_box').append('<img src="/readgoal/tommy/views/images/ajax_loading_small.gif" id="tommy_ajax_loading_image"/>');var left=parseInt(($('#visit_list_box').width()-$('#tommy_ajax_loading_image').width())/2);var top=parseInt(($('#visit_list_box').height()-$('#tommy_ajax_loading_image').height())/2);$('#tommy_ajax_loading_image').css({'margin-top':top+'px','margin-left':left+'px'});$('#visit_list_box').load('/readgoal/index.php/product/ajax_cookie_display/id/1737778/time/1309443882',function(){$('#tommy_ajax_loading_image').remove()})});
</script>
<script type="text/javascript">
	$(document).ready(function(){$('#hotsell_list_box').append('<img src="/readgoal/tommy/views/images/ajax_loading_small.gif" id="tommy_ajax_loading_image"/>');var left=parseInt(($('#hotsell_list_box').width()-$('#tommy_ajax_loading_image').width())/2);var top=parseInt(($('#hotsell_list_box').height()-$('#tommy_ajax_loading_image').height())/2);$('#tommy_ajax_loading_image').css({'margin-top':top+'px','margin-left':left+'px'});$('#hotsell_list_box').load('/readgoal/index.php/product/ajax_hotsell_display/class_01/6/class_02/256/time/1309443882',function(){$('#tommy_ajax_loading_image').remove()})});
</script>
<script type="text/javascript">
	$(document).ready(function(){$('#ajax_similar_tags_box').append('<img src="/readgoal/tommy/views/images/ajax_loading_small.gif" id="tommy_ajax_loading_image"/>');var left=parseInt(($('#ajax_similar_tags_box').width()-$('#tommy_ajax_loading_image').width())/2);var top=parseInt(($('#ajax_similar_tags_box').height()-$('#tommy_ajax_loading_image').height())/2);$('#tommy_ajax_loading_image').css({'margin-top':top+'px','margin-left':left+'px'});$('#ajax_similar_tags_box').load('/readgoal/index.php/product/ajax_similar_tags/class_01/6/time/1309443882',function(){$('#tommy_ajax_loading_image').remove()})});
</script>
--%>
<script type="text/javascript">
window.onload = function() {
		$('#member_login_button').click(function(){
				var member_name = $('#member_username').val();
				var password = $('#member_password').val();
				$('#error_message').hide();
				$('#member_username').css('border', '1px solid #666');
				$('#member_password').css('border', '1px solid #666');
				
				if(member_name==''){
					$('#error_message').text('错误信息：用户登陆邮箱不能为空！请输入登陆邮箱');
					$('#error_message').show();
					$('#member_username').css('border', '1px solid #c00');
					$('#member_username').focus();
					return false;
				}
				if(password==''){
					$('#error_message').text('错误信息：用户登陆密码不能为空！请输入密码');
					$('#error_message').show();
					$('#member_password').css('border', '1px solid #c00');
					$('#member_password').focus();
					return false;
				}
				$.post('CusDengluServlet', {'userName':member_name, 'pwd':password}, function(data){
					switch(data){
							case '301':
								location.reload();
								break;
							case '302':
								$('#error_message').text('错误信息：'+member_name+' 该用户名不存在！');
								$('#error_message').show();
								break;
							case '303':
								$('#error_message').text('错误信息：用户名或登陆密码错误! 请重新输入！');
								$('#error_message').show();
								break;
						}
				});
		});
		$('#member_regesiter_button').click(function(){
			top.location.href = 'zhuce.jsp';
		});
}

function clear_visited_cookie(){
	$.post('/readgoal/index.php/product/ajax_clear_visited_cookie', function(data){if(data==101){$('#visit_list_box').remove();}});	
}
</script>
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
    <div>
<a href="#" target="_blank"><img src="images/children.jpg"></a>
</div>

    <div class="zhanwei2"></div>
      	<table width="260" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
      <tbody><tr>
        <td height="30" align="center" bgcolor="#FFFFFF"><span class="da">同类热销</span></td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="padding:8px 0;">
        <div id="hotsell_list_box">
        	<% 
        			for(int i = 0; i < books.size(); i++) { 
        				BookInfo book = books.get(i);
        				if(i > 4){
        					break;
        				}
        	%>
        		
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
        		<tbody>
        			<tr>
        				<td width="30%" align="right">
        					<a href="ShowOneBookInfoServlet?bookId=<%=book.getBookId()%>">
        						<img src="<%=basePath%>upload/images/<%=book.getSmallImg()%>" width="50" border="0">
        					</a>
        				</td>
        				<td width="70%" style="padding-right:20px;vertical-align:top;padding-left:10px;">
        					<a href="ShowOneBookInfoServlet?bookId=<%=book.getBookId()%>"><%=book.getBookName()%></a>
							<div class="sn"></div>
								<span class="huaxian">￥<%=book.getPrice()%></span>&nbsp;&nbsp;<span class="hong">￥<%=book.getSpecialPrice() %></span> 
						</td>
					</tr>
				</tbody>
			</table>
			<div class="zhanwei10"></div>
			<% 		
					} 
			%>
		</div>
		</td>
      </tr>
    </tbody></table>
	    <div class="zhanwei2"></div>
	<table width="260" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
      <tbody><tr>
        <td height="30" align="center" bgcolor="#FFFFFF"><span class="da">您的浏览记录</span></td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><div id="visit_list_box"><ul class="liulan"><li style="width:230px;">1.<a href="images/Gulliver's Travels Movie Novelization_瑞购网_中国最大的外文原版图书销售平台.htm">Gulliver's Travels Movie Novelization</a></li><li style="width:230px;text-align:center;" onclick="return clear_visited_cookie();"><a href="javascript:void(0)" style="color:#A10000;">清空浏览记录</a></li></ul></div></td>
      </tr>
    </tbody></table>
	   <div class="zhanwei2"></div>
  </div>
  <!-- 主体上部右边大的部分 -->
  <div class="ttl">
    <!-- 主体上部右边大的部分左边部分 -->
    	<!-- 产品页右上左边部分 -->
	<div style="padding:5px 0 15px 0;font-family:Verdana;">    
	<h1><%=bookInfo.getBookName()%></h1>
	</div>
    <div class="protl1"> <a href="<%=basePath%>upload/images/<%=bookInfo.getBigImg()%>" title="<%=bookInfo.getBookName()%>" target="_blank" class="thickbox"><img src="<%=basePath%>upload/images/<%=bookInfo.getBigImg()%>"></a> </div>
    <!-- 产品页右上中间部分 -->
    <div class="protm">
	<div></div>
    		  
            <!-- 产品信息显示的次要部分 -->
      <div class="pdi">
        <h3>BookId：<%=bookInfo.getBookId()%></h3>
        <h3>Author: <%=bookInfo.getAuthor()%></h3>
        <h3>Publish Time：<%=bookInfo.getPublishDate()%></h3>
        <h3>Publisher：<%=bookInfo.getPublishName()%></h3>
                <h3>Binding and Layout ：Paperback</h3>
                      </div>
      <!-- 产品的价格显示 -->
      <div class="pdi">
	  <h2>List Price：<span class="huaxian" style="padding:0 7px;">￥<%=bookInfo.getPrice()%></span></h2>
        <h2>
		售价：<span class="hong dada"><%=bookInfo.getSpecialPrice()%></span>&nbsp;&nbsp;
		为您节省了：￥<%=bookInfo.getPrice() - bookInfo.getSpecialPrice() %>			
		(<span class="hong">7.5折</span>)</h2>           
		  <div style="padding-top:4px;color:#959595;">本价格为包含国外运费，关税等的最终价格</div>
      </div>
	<div class="product_addshop">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td width="55%">
    	<span class="floatleft">
    	               <a href="GwcServlet?opType=addBook&id=<%=bookInfo.getBookId()%>">
                         <img src="images/product_addshop.jpg" border="0">
                       </a> 
		</span></td>
    <td valign="bottom">
    
    				<%
    					CustomerInfo u = (CustomerInfo)session.getAttribute("customerInfo");
						if(u == null) {
					%>
						<a href="#TB_inline?&width=400&height=160&inlineId=login_box" class="thickbox" title="用户登陆">收藏本产品</a>
						
					<%
						} else { 
					%>		
						<a href="AddFavoriteServlet?bookId=<%=bookInfo.getBookId()%>" title="用户登陆">收藏本产品</a>
					<%
						}
					%>
    </td>
  </tr>
</tbody></table>
	</div>
    </div>
   
<div style="clear:both; height:1px;"></div>
	    <!-- 作者简介 -->
    	<div class="pfenlei">Product Description 内容简介
	<div class="product_padding" style="font-size:13px;">
<ul>
	<li>
		<strong><span style="font-size: 14px"></span></strong></li>
	<li>
		<%=bookInfo.getContext()%>
	</li>
	
	<li>
		<strong><span style="font-size: 14px"><br>读者评论：</span></strong></li>
		<%if(discuss.size() == 0) {%>
				<li>【还没有来人发表书评，快来做第一个吧！】</li>
				<li><h3>
					<%
						/*
						 *如果客户没有登录则跳转到登录界面
						 *如果客户登录了则对该书进行评论
						 */
						 CustomerInfo user = (CustomerInfo)session.getAttribute("customerInfo"); 
						if(user == null) {
					%>
						<a href="#TB_inline?&width=400&height=160&inlineId=login_box" class="thickbox" title="用户登陆">
					<%} else { %>		
						
					 	<a href="ShowOneBookInfoServlet?opType=saveDis&bookId=<%=bookInfo.getBookId()%>">
					 <%
					 	}
					 %>
					【我也来说说】</a></h3></li> 
		<% } else {
			 			CustomerInfo user = (CustomerInfo)session.getAttribute("customerInfo");
				   		if(user == null) {
				   	 %>
				   		<a href="#TB_inline?&width=400&height=160&inlineId=login_box" class="thickbox" title="用户登陆">
				   	 <% 		
				   		} else {
				   	 %>
				   	 	<a href="ShowOneBookInfoServlet?opType=saveDis&bookId=<%=bookInfo.getBookId()%>">
				   	 <%}%>
				   	【我也来说说】</a></li>
			
			<%
				//图书评论不为空,显示2条评论
             	int j = discuss.size() ;
            	if (j > 3) {
          	  		j = 3;
          	  	}
          	  	
          	   //显示图书评论
          	   for (int i = 0; i < j; i++) {
          	  	 BookDiscuss dis =  discuss.get(i);
          	  	 //得到所有客户信息
          	  	 List<CustomerInfo> customerInfos = (List<CustomerInfo>)request.getAttribute("customerInfos");
          	  	 for(CustomerInfo customerInfo : customerInfos) {
          	  	 	if(customerInfo.getCustomerId() == dis.getCustomerId()) {
          	 %>	 		
          	  	 		<li><font size = 2 color="red"><strong>用户名</strong></font>:<font color="green"><strong><%=customerInfo.getCustomerName()%></strong></font></li>
          	 <%	 		
          	  	 	}
			          	  		 	
          	  	 }
             %>
			   
			 	<li style="background:#f3f3f3;font-weight:bold">内容：</li>
			 	<li><%=dis.getContext()%></li>	
		<%}}%>	
		
		
		<%if(discuss.size() > 2) {%>
			<li>
				<a href="ShowOneBookInfoServlet?opType=findDis&bookId=<%=bookInfo.getBookId()%>">【查看更多】</a>
			</li>
		<%} %>
	<li>
		<strong><span style="font-size: 14px"><br>关于发货时间：</span></strong></li>
	<li>
		工作日每天下午发货一次；法定节假日、周六、周日暂不发货。</li>
	<li>
		一般情况下：</li>
	<li>
		● 工作日当天上午11点前的订单，当天下午统一发出；</li>
	<li>
		● 工作日当天下午11点后的订单，次日下午统一发出；</li>
	<li>
		● 由于周末不发货，每周五上午11点后的订单，将在下一个工作日（周一）的下午发出，下单时请留意；</li>
	<li>
		● 需要开具发票的客户，发货时间将在上述基础上再延后1-2个工作日；</li>
	<li>
		● 如遇其他特殊原因，对发货时间有影响的，我们会第一时间在网站公告，敬请留意。</li>
	<li>
		<strong><span style="font-size: 14px"><br>关于到货时间：</span></strong></li>
	<li>
		由于都是委托第三方快递发货，所以我们只能保证在规定时间内发出，但无法为您保证确切的到货时间。</li>
	<li>
		● 主要城市一般2-4天</li>
	<li>
		● 偏远地区一般4-7天</li>
	<li>
		<strong><span style="font-size: 14px"><br>关于接听咨询电话的时间：</span></strong></li>
	<li>
		周一至周五上午8：30～下午5：00，周六日及法定节假日休息，敬请谅解。</li>
	<li>
		其它时间您也可以通过邮件联系我们：<a href="mailto:readgoal@mail.cibtc.com.cn">readgoal@mail.cibtc.com.cn</a>。</li>
	<li>
		<strong><span style="font-size: 14px"><br>关于快递：</span></strong></li>
	<li>
		我们暂时只与邮政EMS、宅急送快递合作，由于宅急送快递有派送区域限制，请确保您的收货地址宅急送能正常派送，可自行在网站<a href="http://www.zjs.com.cn/">www.zjs.com.cn</a>查询或咨询我们的客服。</li>
</ul>

</div>
	</div>
    <!-- 同意作者的其他作品 -->
    
	<!-- 商品导航 -->
    <div class="pfenlei">Popular in these Categories 所属分类
	<div class="product_padding">		
	<h3>按分类查找：<a href="FindBookInfoByBookTypeServlet?bookTypeId=<%=bookType.getBookTypeId()%>&mode=1"><%=bookType.getBookTypeName()%>　&　<%=bookType.getContext()%></a><br></h3>
	</div>
	</div>
	<div class="pfenlei">Customers Who Bought This Item Also Bought 购买本产品的顾客还买了
	<div class="product_jiahao" style="background-position:165px 60px;" id="ajax_similar_tags_box"><ul class="product_zuozhe" style="padding-left:20px; padding-top:15px;"><li class="product_booklist"> <a href="#"><img src="images/1453772_little.jpg" border="0" width="90" style="border:none; margin-bottom:5px;"></a><br><a href="#">Chinese Myths  中国神话</a> <br><span class="hong">￥86.00</span></li><li class="product_booklist"> <a href="#"><img src="images/1453776_little.jpg" border="0" width="90" style="border:none; margin-bottom:5px;"></a><br><a href="#">THE ART BOOK,CHILDREN ED</a> <br><span class="hong">￥180.00</span></li><li class="product_booklist"> <a href="#"><img src="images/1453788_little.jpg" border="0" width="90" style="border:none; margin-bottom:5px;"></a><br><a href="#">Take a bow babies</a> <br><span class="hong">￥15.00</span></li><li class="product_booklist"> <a href="#"><img src="images/1453803_little.jpg" border="0" width="90" style="border:none; margin-bottom:5px;"></a><br><a href="#">Q&amp;A EXPLORATION</a> <br><span class="hong">￥46.00</span></li><div style="clear:both; height:10px;"></div></ul></div>
	</div>
  </div>
<!-- 用户登陆--> 
<div id="login_box" style="display:none;"> 
<div id="total"> 
<table width="400" border="0" cellspacing="0" cellpadding="0"> 
  <tr> 
    <td height="30" colspan="2" align="center"><div id="error_message"></div></td> 
    </tr> 
  <tr> 
    <td width="120" height="40" align="right">用户名：</td>
    <td width="280" align="left"><input name="member_username" type="text" id="member_username" class="ip"/></td> 
  </tr> 
  <tr> 
 
    <td width="120" height="40" align="right">登陆密码：</td> 
    <td width="280" align="left"><input name="member_password" type="password" id="member_password" class="ip"/></td> 
  </tr> 
  <tr> 
    <td height="40" colspan="2" align="center"><input name="submit" type="button" value="登陆" id="member_login_button" class="button"/>&nbsp;&nbsp;<input name="regesiter" type="button" value="注册" id="member_regesiter_button" class="button"/></td> 
    </tr> 
</table> 
</div> 
</div>	
<!-- /用户登陆-->
<div style="clear:both; height:3px; overflow:hidden;"></div>
<jsp:include page="footer.inc.jsp"></jsp:include>
</div>
</div>
</body>
</html>