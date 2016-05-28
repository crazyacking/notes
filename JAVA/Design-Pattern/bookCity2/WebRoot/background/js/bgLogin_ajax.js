// JavaScript Document
var xmlHttp;  //全局

function createXmlHttp() {
    if (window.XMLHttpRequest) {
       xmlHttp = new XMLHttpRequest();
    } else {
       xmlHttpRequest = new ActiveXObject("MSXML2.XMLHTTP.3.0");
    }
}

function funjava() {
	createXmlHttp();
	var username = document.myform.username.value;
	var userpass = document.myform.userpass.value;
	xmlHttp.open("post","../../SysAdminLoginServlet?" + Math.random()+ "&name="+username+"&pwd="+userpass,true);
	xmlHttp.onreadystatechange=function() {
			var byjava = xmlHttp.responseText;	
			if(xmlHttp.readyState == 4) {
				if(xmlHttp.status != 200) {
					alert(xmlHttp.status);
				} else if(xmlHttp.status == 200) {
					if(byjava == 1) {
						alert('login successful');
						myform.submit();						
					} else {
						alert("username or password error");
						location.href="login.jsp";
					}
				}
			}
	};
	xmlHttp.send(null);
}
