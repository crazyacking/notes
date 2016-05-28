<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员设置权限</title>
<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
</head>
<body>
	<form action="${pageContext.request.contextPath }/UpSysAdminStatesServlet" method="post">
	<table>
		<caption>管理员设置权限</caption>
		<tr>
			<td>管理员编号:</td>
			<td><input name="adminId" value="${requestScope.sysAdmin.adminId}"  readonly/></td>
		</tr>
		<tr>
			<td>管理员名称</td>
			<td><input name="adminName" value="${requestScope.sysAdmin.adminName}"  readonly/></td>
		</tr>
		<tr>
			<td>管理员权限</td>
			<td>
				<input type="radio" name="states" value="1" ${sysAdmin.adminType == 1 ? 'checked':''} />超级管理员
				<input type="radio" name="states" value="2" ${sysAdmin.adminType == 2 ? 'checked':''} />普通管理员
				<input type="radio" name="states" value="3" ${sysAdmin.adminType == 3 ? 'checked':''} />来宾管理员
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="保存"/></td>
			<td><input type="reset" name="reset" value="重置"/></td>
		</tr>		
	</table>
	</form>
</body>
</html>