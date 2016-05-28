<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 导入 标签开发能力-->
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
   	<title>验证框架</title>
  </head>
  
  <body>
  		 <!--
  		通过Action类中execute()方法完成struts2服务器端数据验证
  		 
  		1、在hello.jsp功能基础上，增加验证功能。完成一个信息验证，如果没有输入任何内容，
  		返回hello1.jsp，并提示出错原因。验证手段采用继承的validate()方法来完成。
  		
  		2、注意：
  		2.1、采用验证时，在struts.xml的<action>标签中，必须包含<result name="input">
    	和<result name="success"两个子标签>
    	2.2、在Action类的方法中使用了方法addFieldError(key,value)，
    	其中key的值为s:textfield name="name" label="请输入用户姓名：">的name值保持一致
    	value值为出错提示信息。
    	3、用struts2标签才能自动显示出错信息。	
    	-->
  	
    	<s:form action="strutsValidate.action" method="post" >
    		<s:textfield name="name" label="请输入用户姓名："></s:textfield>
    		<s:submit value="提交"></s:submit>
    	</s:form>
    	
    	<!-- s:fielderror也可以获得validate()方法中的出错信息 -->
    	<s:fielderror /> 
  </body>
</html>
