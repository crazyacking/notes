<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>����ҳ����� - ������</title>
<meta name="keywords" content="�Ź���,�Ź���վ��ȫ,�Ź�����,�Ź�����"/>
<meta name="description" content="����õ��Ź���վ��ȫ���ռ�������ʳ���������֣����ݱ���������������Ϲ���ȴ����Ź���Ϣ���������е��Ź���Ϣ�������Ź���վ��ȫ���Ͼ��ԡ�"/>
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
        	<div class="logo l"><a href="/" title="������"><img alt="������" src="/img/newimg/logo.gif" /></a></div>
            <div class="search l">
            	<div class="search-content cl">
                	<form name=tsForm method=get action="/search" onsubmit="return checkSearchText();">
                	<input type="hidden" name="inputT" value="1"/>
						<div class="search-box l">
							<input name="wd" type="text" id="wd" value="������Ʒ����վ���ַ..." title="������Ʒ����վ���ַ..." onFocus="tsFocus()" onBlur="tsBlur()" />
						</div>
						<div class="search-btn l">
							<button type="submit" name="searchbtn" value="&nbsp;"></button>
						</div>
					</form>
                </div>
                <!-- 
                <div class="search-hot">
                	<a href="#" title="����">����</a>
                    <a href="#" title="����">����</a>
                    <a href="#" title="�տ�">�տ�</a>
                    <a href="#" title="����">����</a>
                    <a href="#" title="����">����</a>
                    <a href="#" title="��Ӿ">��Ӿ</a>
                    <a href="#" title="����">����</a>
                    <a href="#" title="SPA">SPA</a>
                </div>
                 -->
            </div>
        </div>
        <div class="content error404" style="border:none;">   
        	<h1><span class="l">�ܱ�Ǹ����Ҫ���ʵ�ҳ�治���ڣ�</span><span class="r"><a href="/">������ҳ</a></span></h1>
            <p style="clear:both;">1���������������ַ�Ƿ���ȷ��</p>
            <p>2�������ʵĳ�����<em>����</em>���������л����������У�</p>
            <p class="ecity cl">
            <a href='/beijing/' >����</a>
            <a href='/shanghai/' >�Ϻ�</a>
            <a href='/shenzhen/' >����</a>
            <a href='/wuhan/' >�人</a>
            <a href='/guangzhou/' >����</a>
            <a href='/hangzhou/' >����</a>

            <a href='/xian/' >����</a>
            <a href='/tianjin/' >���</a>
            <a href='/chengdu/' >�ɶ�</a>
            <a href='/nanjing/' >�Ͼ�</a>
            <a href='/chongqing/' >����</a>
            <a href='/qingdao/' >�ൺ</a>

            <a href='/xiamen/' >����</a>
            <a href='/fuzhou/' >����</a>
            <a href='/shenyang/' >����</a>
            <a href='/zhengzhou/' >֣��</a>
            <a href='/dalian/' >����</a>
            <a href='/changsha/' >��ɳ</a>

            <a href='/kunming/' >����</a>
            <a href='/nanchang/' >�ϲ�</a>
            <a href='/hefei/' >�Ϸ�</a>
            <a href='/suzhou/' >����</a>
            <a href='/lanzhou/' >����</a>
            <a href='/haerbin/' >������</a>

            <a href='/shijiazhuang/' >ʯ��ׯ</a>
            <a href='/jinan/' >����</a>
            <a href='/guiyang/' >����</a>
            <a href='/area.htm' >�������</a>
            </p>
            <p class="cl">3���绹�����������<a href="/about/feedback.jsp" class="fb">�������</a></p>
        </div>
        <div class="footer">
			<p class="l">������ &copy; 2011 ��ICP֤110311��</p>
			<p class="r">
				<a href="/about/index.jsp" title="���ھ���">���ھ���</a><span class="pipe">|</span> 
				<a href="/about/contact.jsp" title="��ϵ����">��ϵ����</a><span class="pipe">|</span> 
				<a href="/about/join.jsp" title="��������">��������</a><span class="pipe">|</span> 
				<a href="/about/feedback.jsp" title="�������">�������</a><span class="pipe">|</span> 
				<a href="/about/addsite.jsp" title="��վ��¼">��վ��¼</a><span class="pipe">|</span> 
				<a href="/links.htm" title="��������">��������</a><span class="pipe">|</span> 
				<a href="/about/disclaimer.jsp" title="��������">��������</a>
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
