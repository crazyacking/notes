<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/background/js/jquery-1.5.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#admin_submit').click( function() {
			var adminName = $("#adminName").val();
			var pwd = $("#pwd").val();
			if(adminName.length == 0) {
				alert("请输入管理员姓名");
				return false;
			} else {
			  if(pwd == '') {
					alert("密码不能为空");
					return false;
			  } else {
				  	return true;
			  }
		    }
	    });
	});
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/SaveSysAdminServlet" method="post" name="myform">
	<table>
		<caption>新增管理员</caption>
		<tr>
			<td>管理员名称</td> 
			<td><input type="text" name="adminName" id="adminName"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="pwd" id="pwd"/></td>
		</tr>
		<tr>
			<td>管理员权限</td>
			<td>超级管理员<input type="radio" name="adminType" value="1" checked/> 
				普通管理员<input type="radio" name="adminType" value="2"/> 
				来宾管理员<input type="radio" name="adminType" value="3"/>
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="提交" id="admin_submit"/></td>
			<td><input type="reset" name="reset" value="重置"/></td>
		</tr>
	</table>
	</form>
</body>
</html>