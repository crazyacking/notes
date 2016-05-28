<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 导入 标签开发能力-->
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
	<title>strut2-validation应用</title>
  </head>  
  <body>
           欢迎进入登陆页面！！！<br>
    
     <!--
     	通过validation.xml完成验证
     	
  		1、在hello.jsp功能基础上，增加验证功能。该验证功能实现上，与hello1.jsp有区别，
  		借助aciton类名-validation.xml文件来完成验证。
    	 
    	2、注意：
    	2.1、同样在验证时，在struts.xml的<action>标签中，必须包含<result name="input">
    	和<result name="success"两个子标签>
    	2.2、只要符合命名规则，即aciton类名-validation.xml形式，就能针对该aciton类完成验证。
    	
    	3、关于XXX-validation.xml中的详细信息，参考具体文件StrutsValidation-validation.xml
     -->       
    
    <s:form action="strutsValidation.action" method="post" >
    		<s:textfield name="name" label="请输入用户姓名："></s:textfield>
    		<s:password name="pwd" label="请输入密码："></s:password>
    		<s:submit value="提交"></s:submit>
    	</s:form>
  </body>
</html>
