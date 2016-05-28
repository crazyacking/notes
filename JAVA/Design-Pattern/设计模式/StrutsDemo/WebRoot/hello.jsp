<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
	<title>strut2应用</title>
	<script  language="javascript">
	<!--
		function  CheckForm(){  
			if  (document.form1.name.value.length==0)  {  
				alert("请输入您姓名!");
				document.form1.name.focus();
				return  false;
			}
			return  true;
		}
	-->
	</script>
  </head>  
  <body>
           欢迎进入登陆页面！！！<br>
           
    <!--
    	简单的struts例子，采用客户端验证
    		
    	提交一个名字，如果名字等于“HelloWorld”则返回hello.jsp页面，
    	否则为成功返回welcome.jsp页面并显示该名字-->
    
    <form action="struts.action" method="post" name="form1"> 
    	请输入姓名：<input type="text" name="name"/><br>
    	<input type="submit" value="提交" onclick="return CheckForm()"/><input type="reset" value="重置" />
    </form>
  </body>
</html>
