<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%@page import="com.ht.gwc.*"%>
<%@page import="java.util.Collection"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Object objgwc = session.getAttribute("gwc");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车|瑞购网--中国最专业的外文原版图书销售平台</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/thickbox.min.js"></script>
<link href="css/thickbox.css" rel="stylesheet" type="text/css">
<link href="css/login_box.css" rel="stylesheet" type="text/css">
<link href="css/zhengpin_box.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.tabs.min.js"></script>
<jsp:include page="includes.jsp"></jsp:include>
</head>
<body>
<jsp:include page="header.inc.jsp"></jsp:include>
 
  <div class="zhanwei2"></div>
<div class="weizhi">
 
<div class="Gorder_top1 da" style="padding-bottom:8px;"><img src="images/gouwuche.jpg"></div>
 
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="font-size: 12px;">
  <tbody><tr>
   <td width="2%" align="center" bgcolor="#E9E9E9" style="display:none">编号</td>
    <td width="14%" align="center" bgcolor="#E9E9E9"><strong>商品名</strong></td>
    <td width="49%" height="25" align="center" bgcolor="#E9E9E9">&nbsp;</td>
    <td width="10%" align="center" bgcolor="#E9E9E9"><strong>市场价</strong></td>
    <td width="7%" align="center" bgcolor="#E9E9E9"><strong>现价</strong></td>
    <td width="11%" align="center" bgcolor="#E9E9E9"><strong>数量</strong></td>
	<td width="7%" align="center" bgcolor="#E9E9E9"><strong>操作</strong></td>
  </tr>
  <%
  	
  	if(objgwc == null || ((Gwc)objgwc).getItems().size() == 0) {
  %>
  		<tr>
  			<td align="center" colspan="5" style="padding:10px 0;">您还没有购买商品,点<a href="<%=request.getContextPath()%>/InitIndexServlet">这里</a>购买</td>
  		</tr>
  		<tr>
    		<td>&nbsp;</td>
    		<td colspan="6">&nbsp;
				您的购物车中共有(<span class="da hong" id="good_total_num">0</span>)件商品&nbsp;&nbsp;&nbsp;&nbsp;
				订单总金额为：￥<span class="da hong" id="good_total_price">0.00</span>&nbsp;&nbsp;&nbsp;&nbsp;
				为您节约了：￥<span class="da hong" id="good_total_saving">0.00</span>&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
  		</tr>		
  	<%} else {
  		Gwc gwc = (Gwc)objgwc;
  		Collection<GwcItem> items = gwc.getItems();
  		for(GwcItem item: items) {
  	%>		
  		
   		<tr>   	  
    	<td align="center" valign="middle" class="zhhei" style="padding:8px;"><img src="<%=basePath%>upload/images/<%=item.getSmallImg()%>" border="0" width="85"></td>
    	<td valign="middle" class="zhhei" style="text-align:left;">
    		<a href="ShowOneBookInfoServlet?bookId=<%=item.getBookId()%>"><%=item.getBookName()%></a>        
    	</td>
    	<td class="zhhei">￥<%=(float)item.getPrice()%></td>
    	<td class="zhhei">￥<%=(float)item.getSpecialPrice()%></td>
    <td class="zhhei">
         	<img src="images/_.gif" style="cursor:pointer" onClick="subtractNum(<%=item.getBookId()%>)" >
			<input type="text" name="num" style="width:40px;" id="finally_purchase_num_<%=item.getBookId()%>" value="<%=item.getNum()%>"  onchange="changeNum('<%=item.getBookId()%>')">
			<img src="images/+.gif" style="cursor:pointer" onClick="addNum(<%=item.getBookId()%>)">
    </td>
	<td class="zhhei"><a href="<%=request.getContextPath()%>/GwcServlet?opType=delete&id=<%=item.getBookId()%>" onClick="return confirm('是否取消[<%=item.getBookName()%>]')">取消</a></td>
  </tr>
  	<%}%>
		<tr>
    		<td>&nbsp;</td>
    		<td colspan="6">&nbsp;
				您的购物车中共有(<span class="da hong" id="good_total_num"><%=gwc.getNum()%></span>)件商品&nbsp;&nbsp;&nbsp;&nbsp;
				订单总金额为：￥<span class="da hong" id="good_total_price"><%=(float)gwc.getSumPrice()[1]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
				为您节约了：￥<span class="da hong" id="good_total_saving"><%=(float)(gwc.getSumPrice()[0] - gwc.getSumPrice()[1])%></span>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/GwcServlet?opType=clear" onClick="return confirm('是否清空购物车')">清空购物车</a>
			</td>
  		</tr>  		
  <%}%>	
</tbody>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tbody><tr>
    <td width="1%">&nbsp;</td>
    <td width="59%"></td>
    <td width="32%"></td>
	<td width="8%">
      <span>
      	<a href="IsLoginServlet" title="用户登陆"><img src="images/jiesuan.jpg"></a>
      </span>
    </td>
  </tr>
</tbody>
</table>

<!--赠品区-->
<!--/赠品区-->
<div class="zuidi">
    <div class="dibu"> 
</div>

<div class="pdd">
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="font-size: 12px;">
 <tbody><tr>
   <td align="center"></td>
  </tr>
</tbody></table>
</div>
</div></div>
</body>
<script type="text/javascript">
		function changeNum(id) {
			num = document.getElementById("finally_purchase_num_" + id).value
			var n = parseInt(num);
			if(isNaN(n)) {
				alert("商品数量必须为数字");	
				document.getElementById("finally_purchase_num_" + id).value = 0;
				return;
			}
			else if(n <= 0) {
				alert("至少要一件商品");
				document.getElementById("finally_purchase_num_" + id).value = 1;
				return;
			} else {
				window.location = "<%=request.getContextPath()%>/GwcServlet?opType=changeNum&n=" + n + "&id=" + id;
			}
		}
	   function isInt(str) {
		   var reg = /^(-|\+)?\d$/;
		   return reg.test(str);
	   }
	   function addNum(id) {
		   document.getElementById("finally_purchase_num_" + id ).value =
		   parseInt(document.getElementById("finally_purchase_num_" + id).value) + 1;
		   changeNum(id);
	   }
	   function subtractNum(id) {
		   num = document.getElementById("finally_purchase_num_" + id).value;
		   if(parseInt(document.getElementById("finally_purchase_num_" + id).value)>0 ) {
			   document.getElementById("finally_purchase_num_" + id).value = parseInt(num) - 1;
			   changeNum(id);
		   }
	   }
</script>
</html>