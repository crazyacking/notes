<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="quanxian.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="js/ddaccordion.js">

/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/

</script>


<script type="text/javascript">


ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})


</script>


<style type="text/css">
body {
	margin-left:2px;
	margin-top:0px;
	background:#0a5c8e;
}
a{
	line-height:30px;
	color:#006;
	text-decoration:none;
	font-size:12px;
}
a:hover{
	color:#366;
	background:#C93;
}



#top_div{
	width:171px;
	margin-left:0px;
	margin-top:3px;
	background-image:url(images/main_29.gif);
	background-repeat:no-repeat;
	text-align:center;
	height:23px;
}

#bottom_div{
	width:171px;
	margin-left:0px;		
	background-image:url(images/main_45.gif);
	background-repeat:no-repeat;	
	text-align:center;
	vertical-align:bottom;
	height:23px;
}








.glossymenu{

padding: 0;
width: 168px; /*width of menu*/

border-bottom-width: 0;
}

.glossymenu a.menuitem{
background: black url(images/glossyback.gif) repeat-x bottom left;
font: bold 14px "Lucida Grande", "Trebuchet MS", Verdana, Helvetica, sans-serif;
color: white;
display: block;
position: relative; /*To help in the anchoring of the ".statusicon" icon image*/
width: auto;
padding: 2px 0;
padding-left: 8px;
text-decoration: none;
height:18px;
}


.glossymenu a.menuitem:visited, .glossymenu .menuitem:active{
color: white;
}

.glossymenu a.menuitem .statusicon{ /*CSS for icon image that gets dynamically added to headers*/
position: absolute;
top: 5px;
right: 3px;
border: none;

}

.glossymenu a.menuitem:hover{
background-image: url(images/glossyback2.gif);
height:18px;
}

.glossymenu div.submenu{ /*DIV that contains each sub menu*/
background: white;
}

.glossymenu div.submenu ul{ /*UL of each sub menu*/
list-style-type: none;
margin: 0;
padding: 0;
}

.glossymenu div.submenu ul li{
border-bottom: 1px solid  #0CF;
}

.glossymenu div.submenu ul li a{
display: block;
font: normal 13px "Lucida Grande", "Trebuchet MS", Verdana, Helvetica, sans-serif;
color: black;
text-decoration: none;
padding: 2px 0;
padding-left: 8px;
}

.glossymenu div.submenu ul li a:hover{
background: #DFDCCB;
colorz: white;
}

</style>

</head>

<body>
<div id="top_div"><font style="height:1; margin-top:3px; margin-left:20px;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">后台管理 </font></div>
<div style="background-color:#e5f4fd; height:745px;width:168px; margin-left:0px;">


<div class="glossymenu">
	<c:if test="${sessionScope.sysAdmin.adminType == 1}">
	<a class="menuitem submenuheader" href="#" target="I2">用户管理</a>
	<div class="submenu">
		<ul>
			<li><a href="<%=request.getContextPath()%>/ShowSysAdminServlet" target="I2">系统用户管理</a></li>	
			<li><a href="<%=request.getContextPath()%>/FindAllCustomerInfoServlet" target="I2">客户管理</a></li>	
		</ul>
	</div>
	</c:if>
	
	
	<a class="menuitem submenuheader" href="#" >图书信息</a>
	<div class="submenu">
		<ul>
			<li><a href="<%=request.getContextPath()%>/FindAllBookTypeServlet" target="I2">图书类别管理</a></li>
			<li><a href="<%=request.getContextPath()%>/FindAllBookInfoServlet" target="I2">图书信息管理</a></li>
			<li><a href="<%=request.getContextPath()%>/FindAllBookStockServlet" target="I2">图书库存管理</a></li>
		</ul>
	</div>
	
	<c:if test="${sessionScope.sysAdmin.adminType <= 2}">	
	<a class="menuitem submenuheader" href="#">交互管理</a>
	<div class="submenu">
		<ul>
				<li><a href="<%=request.getContextPath()%>/ShowDiscussServlet" target="I2">评论管理</a></li>	
		
			<c:if test="${sessionScope.sysAdmin.adminType == 1}">
				<li><a href="<%=request.getContextPath()%>/OrderMakeServlet" target="I2">订单处理</a></li>
			</c:if>
		</ul>
	</div>
	</c:if>
	
	<c:if test="${sessionScope.sysAdmin.adminType == 1}">
	<a class="menuitem submenuheader" href="#" target="I2">系统设置</a>
	<div class="submenu">
		<ul>
			<li><a href="goods/pages/addGoods.php" target="I2">xx</a></li>	
			<li><a href="goods/pages/goodsList.php" target="I2">xx</a></li>	
		</ul>
	</div>
	</c:if>
	
	<a class="menuitem submenuheader" href="#" target="I2">其它</a>
	<div class="submenu">
		<ul>
			<li><a href="#" target="I2" onclick="window.parent.parent.location.href='../ChangeServlet'">退出并进入前台首页</a></li>	
			<li><a href="#" target="I2" onclick="window.parent.parent.location.href='../ReLoginServlet'">重新登录</a></li>	
		</ul>
	</div>
</div>
</div>
 <div id="bottom_div"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">版本2014 V1.1 </font></div>
</body>

</html>