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
     	通过validation.xml文件针对具体自定义方法完成验证
     	
  		1、在hello2.jsp功能基础上，增加针对其中自定义方法的验证功能。该验证功能实现上，与hello2.jsp有区别，
  		借助aciton类名-action名(在struts中指定处理某方法的action的name)-validation.xml文件来完成验证。
    	
    	2、注意：
    	2.1、同样在验证时，在struts.xml的<action>标签中，必须包含<result name="input">
    	和<result name="success"两个子标签>
    	2.2、只要符合命名规则，即citon类名-action名-validation.xml形式，就能针对该aciton类完成验证。
    	
    	3、关于action类名-action名-validation.xml中的详细信息，参考具体文件StrutsValidation-testValidate-validation.xml
    	
    	4、测试时，如果输入密码长度小于3，会发现同时报2个错，要求在3到8之间和要求在4到10之间，如果输入3个字长度的密码，会
    	发现，则只报要求在4到10之间一个错，证明2个验证框架配置文件都在发生作用。其顺序是先验证不针对具体方法的.xml，再验证
    	针对方法的.xml配置验证文件。
     -->       
    
    <s:form action="strutsValidationByMethod.action" method="post" >
    		<s:textfield name="name" label="请输入用户姓名："></s:textfield>
    		<s:password name="pwd" label="请输入密码："></s:password>
    		<s:submit value="提交"></s:submit>
    	</s:form>
  </body>
</html>
