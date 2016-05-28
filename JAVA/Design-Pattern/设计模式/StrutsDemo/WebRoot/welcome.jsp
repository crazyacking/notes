<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
	<title>strut2应用</title>
  </head>  
  <body>
   <!-- 非根对象输出模式 -->
   hello <s:property value="#request.name"/>!<br>
   <!-- 来自Action类根对象中属性输出模式，详细参考StrutsONGL:login.jsp和课件 -->
   hello <s:property value="name"/>!
   <br>
   <s:property value="#request.pwd"/>
  </body>
</html>
