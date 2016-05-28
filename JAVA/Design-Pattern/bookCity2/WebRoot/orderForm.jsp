<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单结算|瑞购网</title>
<link href="css/shopping_confirm.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function check() {
		if(myform.name.value.length == 0) {
			alert('收货人姓名不能为空！请填写收货人姓名。');
			myform.name.focus();
			return false;
		}
		if(myform.email.value.length == 0) {
			alert('email不能为空！请填写email地址。');
			myform.email.focus();
			return false;
		}
		if(myform.address.value.length == 0) {
			alert('收货地址不能为空!请填写详细的收货地址。');
			myform.address.focus();
			return false;
		}
		if(myform.tel.value.length == 0) {
			alert('请填写您的联系方式,方便我们与您取得联系。');
			myform.tel.focus();
			return false;
		}
		myform.submit();
		
	}
</script>
</head>
<body>
<div class="cen">
<div style="border-bottom:1px solid #666; height:75px;">
<div class="left" style="height:70px; overflow:hidden;"><a href="http://www.readgoal.com/"><img src="images/logo.jpg" style="border:none;"></a></div>
<div class="right" style="padding-top:50px;">帮助</div>
</div>
<div class="zhanwei"></div>
<div>&nbsp;&nbsp;&nbsp;结算步骤: 1.登录注册 &gt;&gt;<span class="hong"><strong> 2.填写核对订单信息</strong></span> &gt;&gt; 3.提交订单 <span style=" margin-right:10px;float:right;"><a href="<%=request.getContextPath()%>/gwc.jsp" target="_self">返回购物车</a></span></div>
<div class="zhanwei"></div>
<div class="bb h400">
<div class="topb">请正确填写<strong class="f14">如下信息，以便我们及时准确地处理订单（*号为必填信息）。</strong></div>
<div class="paddtb">
<form action="<%=request.getContextPath() %>/ShoppingConfirmServlet" name="myform" method="post" id="myform">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
  <c:if test="${empty requestScope.customerDetailInfo}" var ="re">	
  <tr>
    <td width="18%" height="35" align="right">收货人姓名：</td>
    <td width="82%"><input type="text" name="name" class="input" style="width:100px;" id="member_name"><input name="operate_insert" type="hidden" value="0" id="operate_insert">
      <span class="hong">*</span>   请准确填写真实姓名，以便确保商品准确无误送达。</td>
  </tr>
  <tr>
    <td height="35" align="right">Email：</td>
    <td>   
		<input type="text" name="email" class="input"><span class="hong">*</span>
	</td>
  </tr>
  <tr>
    <td height="35" align="right">详细地址：</td>
    <td><input type="text" name="address" class="input" style="width:400px;" id="member_address"><span class="hong">*</span></td>
  </tr>
  <tr>
    <td height="35" align="right">联系电话：</td>
    <td><input type="text" name="tel" class="input" id="member_telephone"><span class="hong">*</span></td>
  </tr>
  <tr>
    <td height="35" align="right">QQ：</td>
    <td><input type="text" name="qq" class="input" id="member_mobile"></td>
  </tr>
  </c:if>
  
  
   <c:if test="${!re}">	
  <tr>
    <td width="18%" height="35" align="right">收货人姓名：</td>
    <td width="82%">
    				<input type="text" name="name" class="input" style="width:100px;" id="member_name" value="${customerDetailInfo.realname}">
    				<input name="operate_insert" type="hidden" value="0" id="operate_insert">
      <span class="hong">*</span>   请准确填写真实姓名，以便确保商品准确无误送达。</td>
  </tr>
  <tr>
    <td height="35" align="right">Email：</td>
    <td>   
		<input type="text" name="email" class="input"><span class="hong">*</span>
	</td>
  </tr>
  <tr>
    <td height="35" align="right">详细地址：</td>
    <td><input type="text" name="address" class="input" style="width:400px;" id="member_address" value="${customerDetailInfo.address }"><span class="hong">*</span></td>
  </tr>
  <tr>
    <td height="35" align="right">联系电话：</td>
    <td><input type="text" name="tel" class="input" id="member_telephone" value="${customerDetailInfo.tel}"><span class="hong">*</span></td>
  </tr>
  <tr>
    <td height="35" align="right">QQ：</td>
    <td><input type="text" name="qq" class="input" id="member_mobile" value="${customerDetailInfo.qq}"></td>
  </tr>
  </c:if>
  
 
</tbody>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
  <tr>
    <td height="60" align="center">
    	<img src="images/ps.gif" border="0" id="" onclick="check()" style="cursor: pointer"/>
    </td>
  </tr>
 </tbody>
</table>
 </form>
</div>
</div>
<div style="height:60px; line-height:50px; text-align:center;">版权所有2011<span style="font-size:16px">? </span>瑞购网 www.readgoal.com</div>
</div>

</body></html>