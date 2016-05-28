<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新增图书信息-网上书城</title>
	<link rel="styleSheet" href="${pageContext.request.contextPath}/background/css/body.css" type="text/css" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/background/js/wpCalendar.js"></script>
	<style>
		#img_cre,#newPreview
		{
    		filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);
		}
	</style>
	<script>
		function ShowImage(FileUploadID, ImgID) {
		    if (document.getElementById(FileUploadID).value != "") {
		        document.getElementById(ImgID).style.display = "block";
				var path=getPath(document.getElementById(FileUploadID));
		        //alert(window.navigator.userAgent.indexOf("MSIE"));
				if (window.navigator.userAgent.indexOf("MSIE") >= 1){
					document.getElementById(ImgID).style.display = 'none';
					var newPreview = document.getElementById("newPreview");
			    	newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = path;
				    newPreview.style.width = "280px";
				    newPreview.style.height = "280px";
				    
				}else if(window.navigator.userAgent.indexOf("Firefox") >= 1){
					document.getElementById(ImgID).display="block";
					document.getElementById(ImgID).src = path;
				}
		    }
		 }
		 
		 function getPath(obj) {
		    if (obj) {
		        if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
		            obj.select(); return document.selection.createRange().text;		   
		        }
		        else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
		            if (obj.files) { return obj.files.item(0).getAsDataURL(); }
		            return obj.value;
		        }
		         return obj.value;
		    }
		}	
		function checkBase() {
			if(myform.bookName.value.length == 0) {
				alert('请填写图书名称');
				myform.bookName.focus();
				return false;
			}
			if(myform.author.value.length == 0) {
				alert('请填写出版社名称');
				myform.author.focus();
				return false;
			}
			if(myform.price.value.length == 0) {
				alert('请填写价格');
				myform.price.focus();
				return false;
			}
			if(myform.publishDate.value.length == 0) {
				alert('请填写出版日期');
				myform.publishDate.focus();
				return false;
			}
			if(myform.specialPrice.value.length == 0) {
				alert('请填写特价');
				myform.specialPrice.focus();
				return false;
			}
			if(myform.context.value.length == 0) {
				alert('请填写图书描述信息');
				myform.context.focus();
				return false;
			}
			if(myform.context.value.lengt > 8000) {
				alert('您输入的描述信息太长');
				myform.context.focus();
				return false;
			}
			return true;
		}
	</script>
  </head>
  <body>
 		<form action="<%=request.getContextPath()%>/SaveBookInfoServlet" name="myform" method="post" enctype='multipart/form-data' onsubmit="return checkBase()">
		<table>
			<caption>新增图书信息</caption>
			<tr>
				<td>图书名称:</td>
				<td><input type="text" class="text" name="bookName"/></td>
				<td rowspan="6"><div id="newPreview"><img id = "small" src=""/></div></td>
			</tr>
			<tr>
				<td>图书类别</td>
				<td>
				<select name="bookTypeId">
					<c:forEach items="${requestScope.initBooTypes}" var="bookType">
						<option value="${bookType.bookTypeId}">${bookType.bookTypeName}</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>出版社</td>
				<td><input type="text" class="text" name="publishName" /></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" class="text" name="author" /></td>
			</tr>
			<tr>
				<td>小图片:</td>
				<td><input id="smallPath" type="file" class="text" name="upfile" size="50" onChange="ShowImage('smallPath','small')" /></td>
			</tr>
			<tr>
				<td>大图片:</td>
				<td><input id="bigPath" type="file" class="text" name="upfile" size="50" onChange="ShowImage('bigPath','big')"/></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" class="text" name="price" /></td>
				<td rowspan="6"><div id="newPreview"><img id = "big" src=""/></div></td>
			</tr>
			<tr>
				<td>出版日期</td>
				<td><input type="text" class="text" name="publishDate" onfocus="javascript:showCalendar(this,'text4.value = text3.value')" /></td>
			</tr>
			<tr>
				<td>图书状态</td>
				<td>
					<input type="radio" name="bookStates" value="1" checked/>可用
					<input type="radio" name="bookStates" value="2" />上架
					<input type="radio" name="bookStates" value="3" />不可用
				</td>
			</tr>
			<tr>
				<td>特价</td>
				<td><input type="text" class="text" name="specialPrice" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td>
					<textarea rows="7" cols="33" name="context" ></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"/></td><td><input type="reset"/></td>
			</tr>
		</table>
		</form>
  </body>
</html>
