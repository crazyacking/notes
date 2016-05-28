<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	OrderMain orderMain = (OrderMain)request.getAttribute("orderMain");
	List<OrderDetail> orderDetails = (List<OrderDetail>)request.getAttribute("orderDetails");
	List<BookInfo> bookss = (List<BookInfo>)request.getAttribute("bookss");
	int total = 0;
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
  <tbody><tr>
    <td height="40" colspan="4" align="center" bgcolor="#F0F0F0"><span style="font-size:14px;">订单号：<b><%=orderMain.getOid()%></b></span></td>
    </tr>
  <tr>
    <td width="12%" height="40" align="right" bgcolor="#F0F0F0">收货地址：</td>
    <td width="88%" colspan="3" bgcolor="#F0F0F0"><%=orderMain.getShouAddress()%></td>
  </tr>
  <tr>
    <td width="12%" height="40" align="right" bgcolor="#F0F0F0">收货人：</td>
    <td width="88%" colspan="3" bgcolor="#F0F0F0"><%=orderMain.getShouName()%></td>
  </tr>
  <tr>
    <td width="12%" height="40" align="right" bgcolor="#F0F0F0">联系方式：</td>
    <td width="88%" colspan="3" bgcolor="#F0F0F0">手机：<!--$order_data['Home_telephone']--> &nbsp;电话：<%=orderMain.getShouTel()%></td>
  </tr>
  <tr>
    <td height="40" align="right" bgcolor="#F0F0F0">配送方式：</td>
    <td width="15%" bgcolor="#F0F0F0">普通快递</td>
    <td width="8%" bgcolor="#F0F0F0">支付方式：</td>
    <td align="left" bgcolor="#F0F0F0">货到付款</td>
  </tr>
  <tr>
    <td height="40" align="right" bgcolor="#F0F0F0">宅急送单号：</td>
    <td width="15%" bgcolor="#F0F0F0"></td>
    <td width="8%" bgcolor="#F0F0F0">查询地址：</td>
    <td align="left" bgcolor="#F0F0F0"><a href="http://www.zjs.com.cn/WS_Business/WS_Business_GoodsTrack.aspx?id=6" target="_blank">http://www.zjs.com.cn/WS_Business/WS_Business_GoodsTrack.aspx?id=6</a></td>
  </tr>
</tbody></table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:15px;">
  <tbody><tr>
    <td width="15%" height="30" align="center">订单状态：</td>
    <td width="35%" align="left"><span class="hong">
    	<%
    		switch(orderMain.getStates()) {
    			case 1 : out.print("未处理");break;
    			case 2 : out.print("正在处理...");break;
    			case 3 : out.print("已处理");break;
    		} 
    	%>
    </span></td>
    <td width="15%" align="center">付款状态：</td>
    <td width="35%" align="left"><span class="hong">
    	<%
    		switch(orderMain.getStates()) {
				case 3 : out.print("已付款");break;
				default: out.print("未付款");break;
			} 
    	%>
    </span></td>
  </tr>
</tbody></table>

<div class="bhui bian rt2 bbn" style="margin-top:20px; border-bottom:1px solid #CCC; margin-bottom:30px;">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
      <td width="3%" height="27">&nbsp;</td>
      <td width="9%" align="center" class="bai">商品图片</td>
      <td width="47%" align="left" class="bai">商品名称</td>
      <td width="14%" align="center" class="shenhui">价格</td>
      <td width="13%" align="center" class="shenhui">数量</td>
      <td width="14%" align="center" class="shenhui">购买价格</td>
    </tr>
 	<% for(int i = 0; i < orderDetails.size(); i++) {
 		OrderDetail orderDetail = orderDetails.get(i);
 		BookInfo bookInfo = bookss.get(i);
 	%>
 		   
    <tr>
      <td height="33" align="center" class="biandi">&nbsp;</td>
      <td valign="middle" class="biandi padding"><a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>" target="_blank"><img src="<%=basePath%>upload/images/<%=bookInfo.getSmallImg()%>" height="80" border="0"></a></td>
      <td valign="middle" class="biandi"><b class="f14"><a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>" target="_blank"><%=bookInfo.getBookName()%></a></b> </td>
      <td align="center" class="biandi shenhui">￥<%=bookInfo.getPrice()%></td>
      <td align="center" class="biandi shenhui">
      	<% 
      		total += orderDetail.getNum();
      		out.print(orderDetail.getNum());
      	%>
      </td>
      <td align="center" class="biandi shenhui">￥<%=bookInfo.getSpecialPrice()%></td>
    </tr>
    <% } %>
            
    <tr>
      <td height="33" align="center" class="biandi">&nbsp;</td>
      <td valign="middle" class="biandi padding">&nbsp;</td>
      <td valign="middle" class="biandi">&nbsp;</td>
      <td align="center" class="biandi shenhui">运费：</td>
      <td align="center" class="biandi shenhui">&nbsp;</td>
      <td align="center" class="biandi shenhui">￥0.00</td>
    </tr>
  <tr>
      <td height="33" align="center" class="biandi">&nbsp;</td>
      <td valign="middle" class="biandi padding">&nbsp;</td>
      <td valign="middle" class="biandi">&nbsp;</td>
      <td align="center" class="biandi shenhui">总计：</td>
      <td align="center" class="biandi shenhui"><%=total%></td>
      <td align="center" class="biandi shenhui">￥<%=orderMain.getMoneyCount()%></td>
    </tr>
  </tbody></table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tbody><tr>
    <%--翻页用 
    <td width="99%" height="60" align="right"></td>
    <td width="1%">&nbsp;</td>--%>
  </tr>
</tbody></table>
  </div>
  