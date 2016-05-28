<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>访问页面出错 - 聚淘网</title>
<meta name="keywords" content="团购网,团购网站大全,团购导航,团购搜索"/>
<meta name="description" content="最好用的团购网站大全，收集餐饮美食，休闲娱乐，美容保健，生活服务，网上购物等大量团购信息，满足所有的团购信息需求。找团购网站大全，上聚淘。"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<!--[if IE]>
<link href="/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>

<body class="about spbg" style="background:none;">
	<div class="wrap">
    	<div class="header cl">
        	<div class="logo l"><a href="/" title="聚淘网"><img alt="聚淘网" src="/img/newimg/logo.gif" /></a></div>
            <div class="search l">
            	<div class="search-content cl">
                	<form name=tsForm method=get action="/search" onsubmit="return checkSearchText();">
                	<input type="hidden" name="inputT" value="1"/>
						<div class="search-box l">
							<input name="wd" type="text" id="wd" value="输入商品、网站或地址..." title="输入商品、网站或地址..." onFocus="tsFocus()" onBlur="tsBlur()" />
						</div>
						<div class="search-btn l">
							<button type="submit" name="searchbtn" value="&nbsp;"></button>
						</div>
					</form>
                </div>
                <!-- 
                <div class="search-hot">
                	<a href="#" title="自助">自助</a>
                    <a href="#" title="减肥">减肥</a>
                    <a href="#" title="烧烤">烧烤</a>
                    <a href="#" title="麦当劳">麦当劳</a>
                    <a href="#" title="瘦身">瘦身</a>
                    <a href="#" title="游泳">游泳</a>
                    <a href="#" title="烤肉">烤肉</a>
                    <a href="#" title="SPA">SPA</a>
                </div>
                 -->
            </div>
        </div>
        <div class="content error404" style="border:none;">   
        	<h1><span class="l">很抱歉，您要访问的页面不存在：</span><span class="r"><a href="/">返回首页</a></span></h1>
            <p style="clear:both;">1、请检查您输入的网址是否正确。</p>
            <p>2、您访问的城市是<em>北京</em>，您可以切换到其他城市：</p>
            <p class="ecity cl">
            <a href='/beijing/' >北京</a>
            <a href='/shanghai/' >上海</a>
            <a href='/shenzhen/' >深圳</a>
            <a href='/wuhan/' >武汉</a>
            <a href='/guangzhou/' >广州</a>
            <a href='/hangzhou/' >杭州</a>

            <a href='/xian/' >西安</a>
            <a href='/tianjin/' >天津</a>
            <a href='/chengdu/' >成都</a>
            <a href='/nanjing/' >南京</a>
            <a href='/chongqing/' >重庆</a>
            <a href='/qingdao/' >青岛</a>

            <a href='/xiamen/' >厦门</a>
            <a href='/fuzhou/' >福州</a>
            <a href='/shenyang/' >沈阳</a>
            <a href='/zhengzhou/' >郑州</a>
            <a href='/dalian/' >大连</a>
            <a href='/changsha/' >长沙</a>

            <a href='/kunming/' >昆明</a>
            <a href='/nanchang/' >南昌</a>
            <a href='/hefei/' >合肥</a>
            <a href='/suzhou/' >苏州</a>
            <a href='/lanzhou/' >兰州</a>
            <a href='/haerbin/' >哈尔滨</a>

            <a href='/shijiazhuang/' >石家庄</a>
            <a href='/jinan/' >济南</a>
            <a href='/guiyang/' >贵阳</a>
            <a href='/area.htm' >更多城市</a>
            </p>
            <p class="cl">3、如还有疑问请访问<a href="/about/feedback.jsp" class="fb">意见反馈</a></p>
        </div>
        <div class="footer">
			<p class="l">聚淘网 &copy; 2011 京ICP证110311号</p>
			<p class="r">
				<a href="/about/index.jsp" title="关于聚淘">关于聚淘</a><span class="pipe">|</span> 
				<a href="/about/contact.jsp" title="联系我们">联系我们</a><span class="pipe">|</span> 
				<a href="/about/join.jsp" title="加入我们">加入我们</a><span class="pipe">|</span> 
				<a href="/about/feedback.jsp" title="意见反馈">意见反馈</a><span class="pipe">|</span> 
				<a href="/about/addsite.jsp" title="网站收录">网站收录</a><span class="pipe">|</span> 
				<a href="/links.htm" title="友情链接">友情链接</a><span class="pipe">|</span> 
				<a href="/about/disclaimer.jsp" title="免责声明">免责声明</a>
			</p>
		</div>
		<div style="display: none"><script src="http://w.cnzz.com/c.php?id=30047666&l=3" language='JavaScript'></script></div>
    </div>
</body>
<script>  
String.prototype.trim = function() {  
	  return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');  
	} 

	$.post("/tuan/getAreaName.jsp",function(data){
		  $("#areaName").html(trim(data)); 
	})
</script>
</html>
