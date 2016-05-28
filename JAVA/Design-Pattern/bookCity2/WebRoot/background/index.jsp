<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@include file="quanxian.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/php; charset=utf-8" />
<title>网站后台管理系统</title>
</head>

<frameset rows="83,*" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="<%=request.getContextPath()%>/background/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  <frame src="<%=request.getContextPath()%>/background/center.jsp" name="mainFrame" id="mainFrame" />
</frameset>
<noframes><body>
</body>
</noframes></html>
