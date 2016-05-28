var slides = new Array ();
slides['slide_1'] = new Array('ajax/ad9_02.jpg', 'ajax/ad9_01_01.gif');
slides['slide_2'] = new Array('ajax/ad9_03.jpg', 'ajax/ad9_01_02.gif');
slides['slide_3'] = new Array('ajax/ad9_04.jpg', 'ajax/ad9_01_03.gif');

	var esalestartTime = new Date();
	var esaleEndTime=esalestartTime.getTime()+200*60*1000;

	function GetRTimesale(){
		var esaleNowTime = new Date();
		var esalenMS =esaleEndTime - esaleNowTime.getTime();
		var esalenH=Math.floor(esalenMS/(1000*60*60)) % 24;
		var esalenM=Math.floor(esalenMS/(1000*60)) % 60;
		var esalenS=Math.floor(esalenMS/1000) % 60;
		
 		document.getElementById("esaleRemainH").innerHTML=esalenH;
 		document.getElementById("esaleRemainM").innerHTML=esalenM;
 		document.getElementById("esaleRemainS").innerHTML=esalenS;
		
		setTimeout("GetRTimesale()",1000);
	}
	
	
	
	var startTime = new Date();
	var EndTime=startTime.getTime()+100*60*1000;

	function GetRTime(){
		var NowTime = new Date();
		var nMS =EndTime - NowTime.getTime();
		var nH=Math.floor(nMS/(1000*60*60)) % 24;
		var nM=Math.floor(nMS/(1000*60)) % 60;
		var nS=Math.floor(nMS/1000) % 60;
		
 		document.getElementById("RemainH").innerHTML=nH;
 		document.getElementById("RemainM").innerHTML=nM;
 		document.getElementById("RemainS").innerHTML=nS;
		
		setTimeout("GetRTime()",1000);
	}
	
	function tabit(btn){
		var idname = new String(btn.id);
		//document.write(idname);
		var s = idname.indexOf("_");
		var e = idname.lastIndexOf("_")+1;
		var tabName = idname.substr(0, s);
		var id = parseInt(idname.substr(e, 1));
		var tabNumber = btn.parentNode.childNodes.length;
		for(i=0;i<tabNumber;i++)
			{
				document.getElementById(tabName+"_div_"+i).style.display = "none"; 
				document.getElementById(tabName+"_btn_"+i).className = "daohang1 dao";
			
			};		
			document.getElementById(tabName+"_div_"+id).style.display = "block"; 
			btn.className = "daohang2 daohangx";
	};
	var fodTime;
	function delaytabit(btn){
		clearTimeout(fodTime);
		fodTime=setTimeout(function(){tabit(btn)},100);
	}
	

	
var req;

function purchase_login_checked(email,password,id){
	req = false;
	if(window.XMLHttpRequest) {
		try {
			req = new XMLHttpRequest();
		} catch(e) {
			req = false;
		}
	} else if(window.ActiveXObject) {
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {
				req = false;
			}
		}
	}	
	url = 'ajax/purchase_login_check.php?email='+email+"&password="+password;
	req.onreadystatechange = function(){build_attribute_form(id)};
	req.open("GET", url, true);
	req.send("");	
}	
	
function build_attribute_form(id) {
    if (req.readyState == 4) {
		check_result=req.responseText;
		if(check_result == "member_no"){
			AlertMsg();
		}else{
			location.href='order/Yorder.php?id'+id;
		}		
		
    }
}

function auction_checked(email,password,id){
	req = false;
	if(window.XMLHttpRequest) {
		try {
			req = new XMLHttpRequest();
		} catch(e) {
			req = false;
		}
	} else if(window.ActiveXObject) {
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {
				req = false;
			}
		}
	}	
	url = 'ajax/purchase_login_check.php?email='+email+"&password="+password;
	req.onreadystatechange = function(){build_aucuion_form(id)};
	req.open("GET", url, true);
	req.send("");	
}	
	
function build_aucuion_form(id) {
    if (req.readyState == 4) {
		check_result=req.responseText;
		if(check_result == "member_no"){
			Aucuion();
		}else{
			location.href='order/Auction.php?id='+id;
		}		
		
    }
}	


function AlertMsg(){

   /**第一步：创建DIV遮罩层。*/
	var sWidth,sHeight;
	sWidth = window.screen.availWidth;
	//屏幕可用工作区高度： window.screen.availHeight;
	//屏幕可用工作区宽度： window.screen.availWidth;
	//网页正文全文宽：     document.body.scrollWidth;
	//网页正文全文高：     document.body.scrollHeight;
	if(window.screen.availHeight > document.body.scrollHeight){  //当高度少于一屏
		sHeight = window.screen.availHeight;  
	}else{//当高度大于一屏
		sHeight = document.body.scrollHeight;   
	}
	//创建遮罩背景
	var maskObj = document.createElement("div");
	maskObj.setAttribute('id','BigDiv');
	maskObj.style.position = "absolute";
	maskObj.style.top = "0";
	maskObj.style.left = "0";
	maskObj.style.background = "#777";
	maskObj.style.filter = "Alpha(opacity=30);";
	maskObj.style.opacity = "0.3";
	maskObj.style.width = sWidth + "px";
	maskObj.style.height = sHeight + "px";
	maskObj.style.zIndex = "10000";
	document.body.appendChild(maskObj);

  
	/**第二步：动态设置div的上边距和左边距，使弹出div居中打开。*/
	var MyDiv =document.getElementById("denglu");
	var MyDiv_w = getStyle(MyDiv,"width");
	var MyDiv_h = getStyle(MyDiv,"height");
	MyDiv_w = parseInt(MyDiv_w); //去掉 单位 "px"
	MyDiv_h = parseInt(MyDiv_h);

	var width = pageWidth(); 
	var height = pageHeight();
	var left = leftPosition();
	var top = topPosition();

	var Div_topposition = top + (height / 2) - (MyDiv_h / 2) - 80; //计算上边距
	var Div_leftposition = left + (width / 2) - (MyDiv_w / 2); //计算左边距

	MyDiv.style.left = Div_leftposition + "px";  //拼接上 单位"px"
	MyDiv.style.top =  Div_topposition + "px";
	MyDiv.style.display = "block";  //设置弹出div显示
}

	/**第三步：关闭窗口和遮罩层。*/
function CloseDiv(){
	var Bigdiv = document.getElementById("BigDiv");
	var Mydiv = document.getElementById("denglu");
	document.body.removeChild(Bigdiv); 
	Mydiv.style.display="none";
}

/**  首页也调用了ajax_elements.js 但没有id "denglu" 会报错。
   第四步：弹出层跟随滚动条滚动。
window.onscroll = window_onscroll;
function window_onscroll(){
	var MyDiv =document.getElementById("denglu");
	var MyDiv_h = getStyle(MyDiv,"height");
	MyDiv_h = parseInt(MyDiv_h);
	var height = pageHeight();
	var top = topPosition();
	var Div_topposition = top + (height / 2) - (MyDiv_h / 2) - 80 ; //计算上边距
	MyDiv.style.top =  Div_topposition + "px";
}
*/

/**
下面都是常用函数，已经收录在我的jsskep.js中。可以在里面找到。
工程地址：http://code.google.com/p/jsskep/
**/
// 计算当前窗口的宽度 //
function pageWidth(){
			 return window.innerWidth != null ? window.innerWidth : document.documentElement && document.documentElement.clientWidth ? document.documentElement.clientWidth : document.body != null ? document.body.clientWidth : null;
}

// 计算当前窗口的高度 //
function pageHeight(){
			 return window.innerHeight != null? window.innerHeight : document.documentElement && document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body != null? document.body.clientHeight : null;
}

// 计算当前窗口的上边滚动条//
function topPosition(){
			  return typeof window.pageYOffset != 'undefined' ? window.pageYOffset : document.documentElement && document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop ? document.body.scrollTop : 0;
}

// 计算当前窗口的左边滚动条//
function leftPosition(){
			 return typeof window.pageXOffset != 'undefined' ? window.pageXOffset : document.documentElement && document.documentElement.scrollLeft ? document.documentElement.scrollLeft : document.body.scrollLeft ? document.body.scrollLeft : 0;
}

//解决外嵌样式style , 用js获取不到的问题。
function getStyle(elem, name){
			if(elem.style[name])
				return elem.style[name];
			else if(elem.currentStyle)	//ie
				return elem.currentStyle[name];
			else if(document.defaultView && document.defaultView.getComputedStyle){	//w3c
				name = name.replace(/([A-Z])/g,"-$1");
				name = name.toLowerCase();
				
				var s = document.defaultView.getComputedStyle(elem,"");
				return s && s.getPropertyValue(name);
			} else
				return null
}

function Aucuion(){

   /**第一步：创建DIV遮罩层。*/
	var sWidth,sHeight;
	sWidth = window.screen.availWidth;

	//屏幕可用工作区高度： window.screen.availHeight;
	//屏幕可用工作区宽度： window.screen.availWidth;
	//网页正文全文宽：     document.body.scrollWidth;
	//网页正文全文高：     document.body.scrollHeight;
	if(window.screen.availHeight > document.body.scrollHeight){  //当高度少于一屏
		sHeight = window.screen.availHeight;  
	}else{//当高度大于一屏
		sHeight = document.body.scrollHeight;   
	}	
	//创建遮罩背景
	var maskObj = document.createElement("div");
	maskObj.setAttribute('id','BigDiv');
	maskObj.style.position = "absolute";
	maskObj.style.top = "0";
	maskObj.style.left = "0";
	maskObj.style.background = "#777";
	maskObj.style.filter = "Alpha(opacity=30);";
	maskObj.style.opacity = "0.3";
	maskObj.style.width = sWidth + "px";
	maskObj.style.height = sHeight + "px";
	maskObj.style.zIndex = "10000";
	document.body.appendChild(maskObj);

  
	/**第二步：动态设置div的上边距和左边距，使弹出div居中打开。*/
	var MyDiv =document.getElementById("aucuiond");
	var MyDiv_w = getStyle(MyDiv,"width");
	var MyDiv_h = getStyle(MyDiv,"height");
	MyDiv_w = parseInt(MyDiv_w); //去掉 单位 "px"
	MyDiv_h = parseInt(MyDiv_h);

	var width = pageWidth(); 
	var height = pageHeight();
	var left = leftPosition();
	var top = topPosition();

	var Div_topposition = top + (height / 2) - (MyDiv_h / 2) - 80; //计算上边距
	var Div_leftposition = left + (width / 2) - (MyDiv_w / 2); //计算左边距

	MyDiv.style.left = Div_leftposition + "px";  //拼接上 单位"px"
	MyDiv.style.top =  Div_topposition + "px";
	MyDiv.style.display = "block";  //设置弹出div显示
}

	/**第三步：关闭窗口和遮罩层。*/
function aucuionfh(){
	var Bigdiv = document.getElementById("BigDiv");
	var Mydiv = document.getElementById("aucuiond");
	document.body.removeChild(Bigdiv); 
	Mydiv.style.display="none";
}

//抢购登录判断
function scare_buying_checked(email,password,id){
	req = false;
	if(window.XMLHttpRequest) {
		try {
			req = new XMLHttpRequest();
		} catch(e) {
			req = false;
		}
	} else if(window.ActiveXObject) {
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {
				req = false;
			}
		}
	}	
	url = '../ajax/scare_buying_login_check.php?email='+email+"&password="+password+"&id="+id;
	req.onreadystatechange = function(){build_scare_buying_form(id)};
	req.open("GET", url, true);
	req.send("");	
}	
	
function build_scare_buying_form(id) {
    if (req.readyState == 4) {
		check_result = req.responseText;
		if(check_result == "no_login"){
			scare_buying_AlertMsg();
		}else if(check_result == "member_no_purview"){
			alert('您的会员级别不够，不能参加此商品的抢购!');
			location.href='javascript:history.back();';
		}else {
			location.href='Gorder_add_product.php?id='+id;
		}		

    }
}	
function scare_buying_AlertMsg(){

   /**第一步：创建DIV遮罩层。*/
	var sWidth,sHeight;
	sWidth = window.screen.availWidth;
	//屏幕可用工作区高度： window.screen.availHeight;
	//屏幕可用工作区宽度： window.screen.availWidth;
	//网页正文全文宽：     document.body.scrollWidth;
	//网页正文全文高：     document.body.scrollHeight;
	if(window.screen.availHeight > document.body.scrollHeight){  //当高度少于一屏
		sHeight = window.screen.availHeight;  
	}else{//当高度大于一屏
		sHeight = document.body.scrollHeight;   
	}
	//创建遮罩背景
	var maskObj = document.createElement("div");
	maskObj.setAttribute('id','BigDiv');
	maskObj.style.position = "absolute";
	maskObj.style.top = "0";
	maskObj.style.left = "0";
	maskObj.style.background = "#777";
	maskObj.style.filter = "Alpha(opacity=30);";
	maskObj.style.opacity = "0.3";
	maskObj.style.width = sWidth + "px";
	maskObj.style.height = sHeight + "px";
	maskObj.style.zIndex = "10000";
	document.body.appendChild(maskObj);

  
	/**第二步：动态设置div的上边距和左边距，使弹出div居中打开。*/
	var MyDiv =document.getElementById("scare_buying_login");             //拷贝时要改的,到help.css里加 共4处要改
	var MyDiv_w = getStyle(MyDiv,"width");
	var MyDiv_h = getStyle(MyDiv,"height");
	MyDiv_w = parseInt(MyDiv_w); //去掉 单位 "px"
	MyDiv_h = parseInt(MyDiv_h);

	var width = pageWidth(); 
	var height = pageHeight();
	var left = leftPosition();
	var top = topPosition();

	var Div_topposition = top + (height / 2) - (MyDiv_h / 2) - 80; //计算上边距
	var Div_leftposition = left + (width / 2) - (MyDiv_w / 2); //计算左边距

	MyDiv.style.left = Div_leftposition + "px";  //拼接上 单位"px"
	MyDiv.style.top =  Div_topposition + "px";
	MyDiv.style.display = "block";  //设置弹出div显示
}

	/**第三步：关闭窗口和遮罩层。*/
function scare_buying_CloseDiv(){                                           //拷贝时要改的
	var Bigdiv = document.getElementById("BigDiv");
	var Mydiv = document.getElementById("scare_buying_login");              //拷贝时要改的
	document.body.removeChild(Bigdiv); 
	Mydiv.style.display="none";
}

/**  首页也调用了ajax_elements.js 但没有id "scare_buying_login" 会报错。
  第四步：弹出层跟随滚动条滚动。
window.onscroll = window_onscroll;
function window_onscroll(){
	var MyDiv =document.getElementById("scare_buying_login");               //拷贝时要改的
	var MyDiv_h = getStyle(MyDiv,"height");
	MyDiv_h = parseInt(MyDiv_h);
	var height = pageHeight();
	var top = topPosition();
	var Div_topposition = top + (height / 2) - (MyDiv_h / 2) - 80 ; //计算上边距
	MyDiv.style.top =  Div_topposition + "px";
}
*/

//拍卖登录判断
function dutchauction_checked(email,password,id){
	req = false;
	if(window.XMLHttpRequest) {
		try {
			req = new XMLHttpRequest();
		} catch(e) {
			req = false;
		}
	} else if(window.ActiveXObject) {
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {
				req = false;
			}
		}
	}	
	url = '../ajax/dutchauction_login_check.php?email='+email+"&password="+password+"&id="+id;
	req.onreadystatechange = function(){build_dutchauction_form(id)};
	req.open("GET", url, true);
	req.send("");	
}	
	
function build_dutchauction_form(id) {
    if (req.readyState == 4) {
		check_result = req.responseText;
		if(check_result == "no_login"){
			dutchauction_AlertMsg();
		}
    }
}	
function dutchauction_AlertMsg(){

   /**第一步：创建DIV遮罩层。*/
	var sWidth,sHeight;
	sWidth = window.screen.availWidth;
	//屏幕可用工作区高度： window.screen.availHeight;
	//屏幕可用工作区宽度： window.screen.availWidth;
	//网页正文全文宽：     document.body.scrollWidth;
	//网页正文全文高：     document.body.scrollHeight;
	if(window.screen.availHeight > document.body.scrollHeight){  //当高度少于一屏
		sHeight = window.screen.availHeight;  
	}else{//当高度大于一屏
		sHeight = document.body.scrollHeight;   
	}
	//创建遮罩背景
	var maskObj = document.createElement("div");
	maskObj.setAttribute('id','BigDiv');
	maskObj.style.position = "absolute";
	maskObj.style.top = "0";
	maskObj.style.left = "0";
	maskObj.style.background = "#777";
	maskObj.style.filter = "Alpha(opacity=30);";
	maskObj.style.opacity = "0.3";
	maskObj.style.width = sWidth + "px";
	maskObj.style.height = sHeight + "px";
	maskObj.style.zIndex = "10000";
	document.body.appendChild(maskObj);

  
	/**第二步：动态设置div的上边距和左边距，使弹出div居中打开。*/
	var MyDiv =document.getElementById("dutchauction_login");             
																	//拷贝时要改的,到help.css里加 共4处要改
																	//登录对话框，改两个地方：ID POST路径
	var MyDiv_w = getStyle(MyDiv,"width");
	var MyDiv_h = getStyle(MyDiv,"height");
	MyDiv_w = parseInt(MyDiv_w); //去掉 单位 "px"
	MyDiv_h = parseInt(MyDiv_h);

	var width = pageWidth(); 
	var height = pageHeight();
	var left = leftPosition();
	var top = topPosition();

	var Div_topposition = top + (height / 2) - (MyDiv_h / 2) - 80; //计算上边距
	var Div_leftposition = left + (width / 2) - (MyDiv_w / 2); //计算左边距

	MyDiv.style.left = Div_leftposition + "px";  //拼接上 单位"px"
	MyDiv.style.top =  Div_topposition + "px";
	MyDiv.style.display = "block";  //设置弹出div显示
}

	/**第三步：关闭窗口和遮罩层。*/
function dutchauction_CloseDiv(){                                           //拷贝时要改的
	var Bigdiv = document.getElementById("BigDiv");
	var Mydiv = document.getElementById("dutchauction_login");              //拷贝时要改的
	document.body.removeChild(Bigdiv); 
	Mydiv.style.display="none";
}

/**  首页也调用了ajax_elements.js 但没有id "dutchauction_login" 会报错。
  第四步：弹出层跟随滚动条滚动。
window.onscroll = window_onscroll;
function window_onscroll(){
	var MyDiv =document.getElementById("dutchauction_login");               //拷贝时要改的
	var MyDiv_h = getStyle(MyDiv,"height");
	MyDiv_h = parseInt(MyDiv_h);
	var height = pageHeight();
	var top = topPosition();
	var Div_topposition = top + (height / 2) - (MyDiv_h / 2) - 80 ; //计算上边距
	MyDiv.style.top =  Div_topposition + "px";
}
*/
