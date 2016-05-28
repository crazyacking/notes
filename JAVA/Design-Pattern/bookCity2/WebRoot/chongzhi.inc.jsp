<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="bhui bian rt2 bbn" style="margin-top:15px;">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
      <td width="5%" height="27">&nbsp;</td>
      <td width="42%" class="bai">帐户余额</td>
      <td width="53%" align="center" class="shenhui">充值</td>
    </tr>
    <tr>
      <td height="240" align="center" class="biandi">&nbsp;</td>
      <td valign="middle" class="biandi"><span style="font-size:20px; font-weight:bold;">积分：</span><span class="f40 b">0</span><br><br><br><span class="shenhui" style="line-height:25px;">用帐户余额可以直接在瑞购网进行购买(系统暂不支持)<br>
价值:1积分等同于0.1人民币。</span></td>
      <td align="center" class="biandi shenhui"><img src="images/alipay.jpg" width="280" height="49"></td>
    </tr>
  </tbody></table>
</div>