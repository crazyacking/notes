<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
%>
<script>
		function check_oldpassword() {
			if(document.getElementById("old_password").value.length != 0) {
				if(document.getElementById("old_password").value != <%=customerInfo.getPwd()%>) {
					document.getElementById("info").innerHTML="原始密码错误";
					document.getElementById("checkResult").value = 1;
				} else {
					document.getElementById("checkResult").value = 2;
					document.getElementById("info").innerHTML="";
				}
			}
		}
		function change_password() {
			if(document.getElementById("old_password").value.length == 0) {
				alert('原始密码不能为空');
				document.getElementById("old_password").focus();
				return false;
			}
				
			if(document.getElementById("new_password").value.length == 0) {
				alert('新密码不能为空');
				document.getElementById("new_password").focus();
				return false;
			}
			if(document.getElementById("new_password").value.length < 6) {
				alert('新密码不能低于6位');
				document.getElementById("new_password").focus();
				document.getElementById("new_password").value = "";
				return false;
			}
			if(document.getElementById("repeat_new_password").value.length == 0) {
				alert('确认密码不能为空');
				document.getElementById("repeat_new_password").focus();
				return false;
			}
			if(document.getElementById("new_password").value != document.getElementById("repeat_new_password").value) {
				alert('确认密码与新密码不相同');
				document.getElementById("repeat_new_password").focus();
				document.getElementById("repeat_new_password").value = "";
				return false;
			}
			if(document.getElementById("checkResult").value == 1) {
				return false;
			}
			myform.submit();			
		}
	
</script>
<div class="bhui bian rt2 bbn" style="margin-top:50px;">
<form action="ChangeCustomerInfoPwdServlet" name="myform" method="post"> 
<table width="100%" border="0" cellspacing="0" cellpadding="0"> 
    <tr> 
      <td width="5%" height="27">&nbsp;</td> 
      <td width="42%" class="bai">修改密码</td> 
      <td width="53%" align="center" class="shenhui">操作</td> 
    </tr> 
    <tr> 
      <td height="60" align="center" >&nbsp;</td> 
      <td valign="middle" >输入原密码：<input type="password" name="textfield" id="old_password" class="password" onblur="check_oldpassword()"/></td> 
      <td align="center" id="info">&nbsp;</td>
      <input type="hidden" id="checkResult" value="1"/> 
    </tr> 
  <tr> 
      <td height="150" align="center" class="biandi">&nbsp;</td> 
      <td valign="middle" class="biandi padding"> 
      输入新密码：<input type="password" name="newPassword" id="new_password" class="password" /><br /> 
      确认新密码：<input type="password" name="textfield" id="repeat_new_password" class="password" /> 
      </td> 
      <td align="center" class="biandi shenhui"><a href="#" onclick="change_password()"><img src="images/yes.jpg" width="95" height="27" /></a></td> 
    </tr> 
</table>
</form>  
</div> 