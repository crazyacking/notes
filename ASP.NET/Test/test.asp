<html>
	<head>
		<title>一个简单的ASP程序</title>
	</head>
	<body>
		<h1 align="center">欢迎光临我的主页</h1>
		<%
			Dim a
			a="你的来访时间是：" & Time()
			Response.Write a
		%>
	</body>
<html>