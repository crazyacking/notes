<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
.input {background-image:url(images/login_20.gif)}
.topbg {background:url(images/login_08.gif)}
.input280 {background-image:url(images/input280.jpg)}
.lt {background-image:url(images/reg_03.gif)}
.lm{background-image:url(images/reg_09.gif)}
.lb{background-image:url(images/reg_15.gif)}
</style>
<%--<script type="text/javascript" async="" src="js/ga.js"></script>
<link href="css/thickbox.css" rel="stylesheet" type="text/css" />--%>
<link href="css/reg.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//$('#login_submit')给id为login_submit的组件绑定了一个click事件
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
		
		$('#member_reg_button').click(function() {
			var member_email = $('#member_reg_email').val();
			var member_password = $('#member_reg_password').val();
			var member_password2 = $('#member_reg_password2').val();
			var member_username = $('#member_reg_username').val();

			//验证email
			if(member_email=='') {
				alert('注册邮箱地址不能为空! 请输入注册邮箱地址');
				$('#member_reg_email').focus();
				return false;
			} else {
				if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(member_email)) {
					alert('输入的邮箱格式不正确,请重新输入');	
					return false;
				} else {
						$.get('CheckEmailServlet', {'member_email':member_email}, function(data){
							if(data=='401'){
								alert('输入的邮箱已经被注册,请更换注册邮箱!');
								return false;
							}
						});
				}			
			}
			//验证密码
			if(member_password=='') {
				alert('密码不用为空!请输入密码');
				$('#member_reg_password').focus();
				return false;
			} else {
				if(member_password.length<6) {
					alert('输入的密码过于简单,密码长度至少6位');
					$('#member_password').focus();
					return false;
				}
			}
			if(member_password2=='') {
				alert('确认密码不能为空! 请输入确认密码');
				$('#member_reg_password2').focus();
				return false;	
			} else {
				if(member_password!=member_password2) {
					alert('输入的密码和确认密码不一致,请重新输入');
					$('#member_reg_password2').focus();
					return false;
				}
			}
			if(member_username=='') {
				alert('用户名不能为空');
				$('#member_reg_username').focus();
				return false;
			} else  if(member_username.length<2 || member_username.length > 20) {
				alert('用户名不得小于2位或者大于20位');
				$('#member_reg_username').focus();
				return false;
			} else if(/[(\[)(\<)(\>)(\')(\")(\ )(\])]+/.test(member_username)) {
				alert('用户名不得包含非法字符');
				$('#member_reg_username').focus();
				return false;
			}
			//注册,处理输入数据
			$.post('SaveCusServlet', {'member_email':member_email, 'member_password':member_password, 'username':member_username}, function(data){
				if(data == '402') {
					alert('注册成功,现在跳转到网站首页');
					setTimeout("location.href='InitIndexServlet'",3000);
				}
				if(data == '403') {
					alert('注册失败,请重提交');
				}
			});
		});
		$('#member_reg_email').blur(function(){
				var email = $(this).val();
				if(email) {
					if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email)){
						alert('输入的邮箱格式不正确,请重新输入');
						$('#member_reg_email').focus();
						return false;
					}
					else{
						$.get('CheckEmailServlet', {'member_email':email}, function(data){
							if(data=='401'){
								alert('输入的邮箱已经被注册,请更换注册邮箱!');
								$('#member_reg_email').focus();
								return false;
							}
						});
					}
				}	
		});
		$('#member_reg_password').blur(function(){
		var password = $(this).val();
		if(password){
			if(password.length<6){
				alert('输入的密码过于简单,密码长度至少6位');	
				$('#member_reg_password').focus();
				return false;
			}
		}		
	});
	$('#member_reg_password2').blur(function(){
		var password = $('#member_reg_password').val();
		var password2 = $(this).val();		
		if(password2){
			if(password!=password2){
				alert('输入的密码和确认密码不一致,请重新输入');
				$('#member_reg_password2').focus();
				return false;
			}
		}
	});
});
</script>
</head>
<body>
<div class="center">
<div class="left w542">
  <div style="height:70px; padding-top:10px; overflow:hidden;"><a href="/bookCity2/InitIndexServlet"><img src="images/logo.jpg" border="0"></a></div>
  <div style="background-image:url(images/reg_04.gif); background-repeat:no-repeat; background-position:327px; margin-top:30px;">
  <div class="lt"></div>
  <div class="lm">
  <form action="SaveCusServlet" method="post" name="zhuce">
  <table width="270" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td><div style="background-image:url(images/reg_06.gif); height:40px; background-position:-20px; background-repeat:no-repeat;"></div></td>
  </tr>
  <tr>
    <td height="20">注册用Email地址：</td>
  </tr>
  <tr>
    <td height="40" valign="top">
    	<input type="text" name="member_reg_email" class="input280" id="member_reg_email">
    </td>
  </tr>
  <tr>
    <td height="20">输入密码：</td>
  </tr>
  <tr>
    <td height="40" valign="top">
    	<input type="password" name="member_reg_password" class="input280" id="member_reg_password">
    </td>
  </tr>
  <tr>
    <td height="20">确认输入密码：</td>
  </tr>
  <tr>
    <td height="40" valign="top">
    	<input type="password" name="member_reg_password2" class="input280" id="member_reg_password2">
    </td>
  </tr>
  <tr>
    <td height="20">输入您想用的用户名：</td>
  </tr>
  <tr>
    <td height="40" valign="top">
    	<input type="text" name="member_username" class="input280" id="member_reg_username">
    </td>
  </tr>
  <tr>
    <td align="right">
    	<div style="padding-right:2px;">
    		<a href="javascript:void(0);">
    			<img src="images/reg_12.gif" style="border:none;" id="member_reg_button">
    		</a>
    	</div>
    </td>
  </tr>
</tbody></table></form>
  </div>
  <div class="lb"></div>
  </div>
</div>
<div class="left w336">
<div style="height:80px;"></div>
<div class="topbg" style="margin-top:30px;">
<div><img src="images/login_04.gif"></div>
<div class="bor1 topbg">
<div style=" padding-top:12px;"><img src="images/login_12.gif"></div>
<div style="padding-top:20px; padding-left:33px; padding-bottom:15px;">
<form method="post" name="myform" action="InitIndexServlet">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td height="50">用户名:</td>
    <td><input type="text" name="member_name" class="input" id="member_name"></td>
  </tr>
  <tr>
    <td height="35">密 码:</td>
    <td><input type="password" name="memmber_password" class="input" id="member_password"></td>
  </tr>
  <tr>
    <td height="40">&nbsp;</td>
    <td><img src="images/login_23.gif" width="59" height="20" border="0" id="login_submit" style="cursor:pointer">&nbsp;&nbsp;</td>
  </tr>
</tbody></table>
</form>
</div>
<div style="padding:10px 0;"><img src="images/login_29.gif"></div>
<div style="padding-bottom:20px; padding-top:15px;">
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
    <td></td>
  </tr>
</tbody></table>

</div>

</div>
<div><img src="images/login_37.gif"></div>
</div>
</div>
<div style="border-bottom:1px solid #E4E4E4; clear:both; margin-top:45px;">&nbsp;</div>
<div style="padding:15px 0 0 95px;;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td><a href="http://www.cibtc.com.cn/"></a></td>
    <td><span class="STYLE3"></span></td>
  </tr>
</tbody></table>
</div>
</div>
</body></html>