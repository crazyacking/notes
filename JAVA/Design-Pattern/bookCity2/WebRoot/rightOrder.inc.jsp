<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<OrderMain> orderMains = (List<OrderMain>)request.getAttribute("orderMains");
%>
<table width="100%" border="0" cellspacing="1" cellpadding="0" style="margin-top: 10px; margin-bottom: 5px; background-color: #CCC;">
	<tbody>
		<tr>
			<td width="100" height="30" align="center" bgcolor="#3B5999"
				style="color: #FFF;">
				全部订单
			</td>

			<td width="100" align="center" bgcolor="#FFFFFF">
				<a href="#">现货订单</a>
			</td>
			<td width="100" align="center" bgcolor="#FFFFFF">
				<a href="#">预售订单</a>
			</td>

			<td bgcolor="#FFFFFF">
				&nbsp;
			</td>
		</tr>
	</tbody>
</table>

<div class="bhui bian rt1 bbn">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			    <tbody>
			   <tr>
			      <td width="3%" height="27">&nbsp;</td>
			      <td width="23%" class="bai">订单号</td>
			      <td width="19%" align="center" class="shenhui">下单时间</td>
			      <td width="9%" align="center" class="shenhui">收货人</td>
			      <td width="8%" align="center" class="shenhui">订单总额</td>      
			      <td width="11%" align="center" class="shenhui">付款方式</td>
			      <td width="12%" align="center" class="shenhui">订单状态</td>                  
			      <td width="15%" align="center" class="shenhui">操作</td>
			    </tr>
			    <%if(orderMains != null) {%>
			    <%for(OrderMain orderMain : orderMains) {%>
				   <tr>
				   
				      <td height="33" class="biandi">&nbsp;</td>
				      <td class="biandi"><span class="b"><a href="ShowFgOrderDetailServlet?oid=<%=orderMain.getOid()%>"><%=orderMain.getOid()%></a></span></td>
				      <td align="center" class="biandi shenhui">2011-07-12 22:04:02</td>
				      <td align="center" class="biandi shenhui"><%=orderMain.getShouName()%></td>
				      <td align="center" class="biandi shenhui">￥<%=orderMain.getMoneyCount()%></td>
				      <td align="center" class="biandi shenhui">货到付款</td>
				      <td align="center" class="biandi shenhui">
				      	<%
				      		if(orderMain.getStates() == 1) {
				      			out.print("未处理");
				      		} else if (orderMain.getStates() == 2) {
				      			out.print("正在处理...");
				      		} else if (orderMain.getStates() == 3) {
				      			out.print("已处理");
				      		}
				      	%>
				      </td>                  
				      <td align="center" class="biandi shenhui">                        &nbsp;
				      <%
				      	if(orderMain.getStates() == 1) {
				      %>
				      	<a href="DeleteMyOrderServlet?oid=<%=orderMain.getOid()%>" onclick="return confirm('你确定取消该项订单?')">取消</a></td>
				      <% 
				      		}else {
				      %>
				      		无
				      <%
				      		}
				      %>
				    </tr>
			  <%}
			    	}%>
			  </tbody>
	  </table>
</div>

