<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<title>登录</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link href="css/thickbox.css" rel="stylesheet" type="text/css">
<link href="css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
 	$(document).ready(function(){ 
		$('#login_submit').click(function() {
			var member_name = $('#member_name').val();
			var member_password = $('#member_password').val();
			
			if(member_name == '') {
				alert('登录用户名不能为空!');
				$('#member_name').focus();
				return false;
			}
			
			if(member_name < 2 || member_name > 20) {
				alert('用户名不得小于2位或者大于20位');
				$('#member_name').focus();
				return false;
			}
			
			if(/[(\[)(\<)(\>)(\')(\")(\ )(\])]+/.test(member_name)) {
				alert('用户名不得包含非法字符');
				$('#member_name').focus();
				return false;
			}
			
			if(member_password == '') {
				alert('密码不用为空!请输入密码');
				$('#member_password').focus();
				return false;	
			}
			if(member_password.length < 6) {
				alert('密码不得小于6位');
				$('#member_password').focus();
				return false;
			}
			$.post('CusDengluServlet', {'userName':member_name, 'pwd':member_password}, function(data){
				switch(data) {
					case '301':alert('login successful');location.href='InitIndexServlet';break;
					case '302':alert('输入的登陆用户名不存在!');break;
					case '303':alert('输入的登陆用户名或密码错误!');break;
				}
			});
		});
 	});
</script>
<style>
.topbg{	background-image:url(images/login_08.gif);}
.input{background-image:url(images/login_20.gif);}
</style>
</head>
<body>
<div class="center">
<div class="left w542">
<div style="height:70px; padding-top:10px; overflow:hidden;"><a href="#"><img src="images/logo.jpg" border="0"></a></div>
<div style="margin-top:30px;"><img src="images/login_15.gif"></div>
</div>
<div class="left w336" style="margin-top:20px;">
<div style="height:50px;"></div>
<div class="topbg">
<div><img src="images/login_04.gif"></div>
<div class="bor1 topbg">
<div style=" padding-top:12px;"><img src="images/login_12.gif"></div>
<div style="padding-top:20px; padding-left:33px;">
<form method="post" name="myform" action="InitIndexServlet">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td height="50">用户名:</td>
    <td><input type="text" name="userName" class="input" id="member_name"></td>
  </tr>
  <tr>
    <td height="35">密 码:</td>
    <td><input type="password" name="pwd" class="input" id="member_password"></td>
  </tr>
  <tr>
    <td height="40">&nbsp;</td>
    <td><img src="images/login_23.gif" id="login_submit" style="cursor:pointer"/>&nbsp;&nbsp;<a href="zhuce.jsp" target="_self"><img src="images/login_25.gif" border="0"></a></td>
  </tr>
</tbody></table>
</form>
</div>
<div style="padding:10px 0;"><img src="images/login_29.gif"></div>
<div style="padding-bottom:20px;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td width="21%"><img src="images/login_34.gif" width="59" height="30"></td>
    <td width="79%" valign="middle"><span class="STYLE2"></span></td>
  </tr>
  <tr>
    <td height="18">&nbsp;</td>
    <td></td>
  </tr>
  <tr>
    <td height="18">&nbsp;</td>
    <td></td>
  </tr>
  <tr>
    <td height="18">&nbsp;</td>
    <td></span></td>
  </tr>
</tbody></table>

</div>

</div>
<div><img src="images/login_37.gif"></div>
</div>
</div>
<div class="left w41">
<div style="padding-top:80px;"></div>
<div style="margin-top:30px;"><img src="images/login_16.gif"></div>
</div>
<div style="border-bottom:1px solid #E4E4E4;margin-top:75px;clear:both;">&nbsp;</div>
<div style="padding:15px 0 0 95px;;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td align="center"></td>
  </tr>
</tbody></table>
</div>
</div>
</body>
</html>