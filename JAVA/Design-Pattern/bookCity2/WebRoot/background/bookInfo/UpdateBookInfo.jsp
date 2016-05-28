<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改图书信息-网上书城</title>
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
	</script>
  </head>
  <body>
 		<form action="<%=request.getContextPath()%>/UpdateBookInfoServlet" name="saveBookInfo" method="post" enctype='multipart/form-data'> 
		<table>
			<caption>修改图书信息</caption>
			<tr>
				<td>图书编号:</td>
				<td><input type="text" class="text" name="bookId" value="${bookInfo.bookId}" readonly/></td>
				<td rowspan="6"><div id="newPreview"><img id="small" src="<%=basePath%>upload/images/${bookInfo.smallImg}"/></div></td>
			</tr>
			
			<tr>
				<td>图书名称:</td>
				<td><input type="text" class="text" name="bookName" value="${bookInfo.bookName}" /></td>
			</tr>
			<tr>
				<td>图书类别</td>
				<td>
					<select name="bookTypeId">
					<c:forEach items="${requestScope.initBooTypes}" var="bookType">
						<c:set var="selectedString"></c:set>
						<c:if test="${bookType.bookTypeId eq bookInfo.bookTypeId}">
							<c:set value="selected" var="selectedString"></c:set>
						</c:if>
						<option value="${bookType.bookTypeId}"  ${selectedString}>${bookType.bookTypeName}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>出版社</td>
				<td><input type="text" class="text" name="publishName" value="${bookInfo.publishName}"/></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" class="text" name="author" value="${bookInfo.author}"/></td>
			</tr>
			<tr>
				<td>小图片:</td>
				<td><input id="smallPath" type="file" class="text" name="upfile" size="50" onChange="ShowImage('smallPath','small')" /></td>
			</tr>
			<tr>
				<td>大图片:</td>
				<td><input id="bigPath" type="file" class="text" name="upfile" size="50" onChange="ShowImage('bigPath','big')"/></td>
				<td rowspan="7"><div id="newPreview"><img id="big" src="<%=basePath%>upload/images/${bookInfo.bigImg}"/></div></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" class="text" name="price" value="${bookInfo.price}"/></td>
			</tr>
			<tr>
				<td>出版日期</td>
				<td><input type="text" class="text" name="publishDate" value="${bookInfo.publishDate}" onFocus="javascript:showCalendar(this,'text4.value = text3.value')" readonly/></td>
			</tr>
			<tr>
				<td>图书状态</td>
				<td>
					<input type="radio" name="bookStates" value="1" ${bookInfo.bookStates == 1 ? 'checked':''} />可用
					<input type="radio" name="bookStates" value="2" ${bookInfo.bookStates == 2 ? 'checked':''} />上架
					<input type="radio" name="bookStates" value="3" ${bookInfo.bookStates == 3 ? 'checked':''} />不可用
				</td>
			</tr>
			<tr>
				<td>特价</td>
				<td><input type="text" class="text" name="specialPrice" value="${bookInfo.specialPrice}"/></td>
			</tr>
			<tr>
				<td>描述</td>
				<td>
					<textarea rows="7" cols="33" name="context">${bookInfo.context}</textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"/></td><td><input type="reset"/></td>
			</tr>
		</table>
		</form>
  </body>
</html>
