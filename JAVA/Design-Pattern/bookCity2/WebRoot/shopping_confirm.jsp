<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/shopping_confirm.css" rel="stylesheet" type="text/css" />
</head>
<body> 
<div class="cen"> 
<div style="border-bottom:1px solid #666; height:75px;"> 
<div class="left" style="height:70px; overflow:hidden;"><a href="http://www.readgoal.com/"><img src="http://www.readgoal.com/images/logo.jpg" style="border:none;"/></a></div> 
<div class="right" style="padding-top:50px;">帮助</div> 
</div> 
<div class="zhanwei"></div> 
<div>&nbsp;&nbsp;&nbsp;结算步骤: 1.登录注册 >><span class="hong"><strong> 2.填写核对订单信息</strong></span> >> 3.提交订单 <span style=" margin-right:10px;float:right;"><a href="<%=request.getContextPath()%>/gwc.jsp" target="_self">返回购物车</a></span></div> 
<div class="zhanwei"></div> 
<div class="bb h500"> 
<div class="kongtop"> 
<span class="left f16">收货人信息：</span><span class="hong right"><a href="IsLoginServlet">修改</a></span></div> 
<div class="paddlr"> 
<form action="OrderServlet" method="post" name="myform">
<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
  <tr> 
    <td width="12%" height="28" align="right">收 货 人：</td> 
    <td width="88%">${requestScope.name}</td>
    <input type="hidden" name="name" value="${requestScope.name}"/> 
  </tr> 
  <tr>
  	<td height="28" align="right">Email：</td> 
    <td>${requestScope.email}</td>
  </tr> 
  <tr> 
    <td height="28" align="right">收货地址：</td> 
    <td>${requestScope.address}</td>
    <input type="hidden" name="address" value="${requestScope.address}"/> 
  </tr>  
  <tr> 
    <td height="28" align="right">联系电话：</td> 
    <td>${requestScope.tel}</td>
    <input type="hidden" name="tel" value="${requestScope.tel}"/> 
  </tr> 
  <tr> 
    <td height="28" align="right">QQ：</td> 
    <td>${requestScope.qq}</td>
    <input type="hidden" name="qq" value="${requestScope.qq}"/> 
  </tr>
</table>
</form> 
</div> 
<div class="topb h40">请选择<span class="f14"><strong>配送方式</strong></span> </div> 
<div class="paddtb"> 
<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
  <tr> 
    <td width="9%" height="30">&nbsp;</td> 
    <td width="91%"><input name="carry_name" type="radio" value="16" checked="checked"/> 
		普通快递－支持货到付款－免运费<br><br>&nbsp;&nbsp;&nbsp;&nbsp;发货地点：北京<br><br>&nbsp;&nbsp;&nbsp;&nbsp;到货时间：订单确认后的2-7天<br><br> 
	
      </td> 
  </tr> 
  <tr> 
    <td height="30">&nbsp;</td> 
    <td><br><br><input type="radio" name="carry_name" value="5" /> 
    邮政EMS－不支持货到付款－运费10元/本<br><br>&nbsp;&nbsp;&nbsp;&nbsp;发货地点：北京<br><br>&nbsp;&nbsp;&nbsp;&nbsp;到货时间：订单确认后的3-8天
	</td> 
  </tr> 
  </table> 
<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
  <tr> 
    <td height="60" align="center"><img src="images/fangshi.gif" width="117" height="25" border="0" id="carrage_style_button" onclick="myform.submit()"/></td> 
  </tr> 
</table> 
</div> 
 
 
 
 
</div> 
<div style="height:60px; line-height:50px; text-align:center;"></div> 
</div> 
</body> 
</html>