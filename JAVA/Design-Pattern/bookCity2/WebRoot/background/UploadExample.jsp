<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<title><%= application.getServerInfo() %></title>
<body>
上传文件程序应用示例
<form action='SaveImage' method='post' enctype='multipart/form-data'>
<%-- 类型enctype用multipart/form-data，这样可以把文件中的数据作为流式数据上传，不管是什么文件类型，均可上传。--%>
请选择要上传的文件<input type='file' name='upfile' size='50'>
请选择要上传的文件1<input type='file' name='upfile' size='50'>
<input type='submit' value='提交'>
</form>
</body>
</html>