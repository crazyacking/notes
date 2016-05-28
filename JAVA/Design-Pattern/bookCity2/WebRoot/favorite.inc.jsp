<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="com.ht.entity.*"%>
<%@page import="com.ht.dao.*"%>
<%@page import="com.ht.dao.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<Favorite> favorites = (List<Favorite>)request.getAttribute("favorites");
	List<BookInfo> bookInfos = (List<BookInfo>)request.getAttribute("bookInfos"); 
%>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.checkbox.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$('#checkbox_checkbox').checkbox_checkbox('.list_id');

$('#delete_list_collection_button').click(function(){
		var list_id='';
		$('.list_id').each(function(){
			if($(this).attr('checked')==true) {
				list_id+=$(this).val()+',';
			}
		});
		list_id=list_id.slice(0,-1);

		if(list_id == ''){
			alert('请选择要删除的收藏商品!');
			return false;
		}else{
			if(confirm('您确认要删除该商品的收藏吗?')) {
				$.get('DeleteFavoriteByListIdServlet', {'list_id':list_id}, function(data) {
					switch(data){
						case '101':
							alert('操作成功!');
							location.reload();
							break;
						case '100':
							alert('对不起,操作执行失败,请重新操作!');
							break;
					}
				});
			}else{
				return false;
			}
			
		}
	});
})
</script>
<div class="nnav" style="margin-top:15px;">
  <input type="checkbox" name="checkbox" value="checkbox" style="float:left;" id="checkbox_checkbox">
<div><a href="#" class="button" id="delete_list_collection_button">删除选中的产品</a></div>
<img src="images/n.gif" width="18" height="18" class="right"><img src="images/p.gif" width="18" height="18" class="right" style="margin-right:5px;">
</div>
<div class="bhui bian rt2 bbn">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
      <td width="4%" height="27">&nbsp;</td>
      <td width="12%" class="bai">商品名称</td>
      <td width="40%" class="bai">&nbsp;</td>
      <td width="10%" align="center" class="shenhui">加入时间</td>
      <td width="11%" align="center" class="shenhui">原价</td>
      <td width="10%" align="center" class="shenhui">会员价</td>
      <td width="13%" align="center" class="shenhui">操作</td>
    </tr>
    
    <%
    	if(favorites != null) {
    		for(int i = 0; i < favorites.size(); i++) {
    			Favorite favorite = favorites.get(i);
    			BookInfo bookInfo = bookInfos.get(i);
    %>
    <tr>
      <td height="33" align="center" class="biandi"><input type="checkbox" name="checkbox" value="<%=favorite.getFavoriteId()%>" class="list_id"></td>
      <td valign="middle" class="biandi padding" align="center"><a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>" target="_blank"><img src="<%=basePath%>upload/images/<%=bookInfo.getSmallImg()%>" height="80" border="0"></a></td>
      <td valign="middle" class="biandi"><b class="f14"><a href="ShowOneBookInfoServlet?bookId=<%=bookInfo.getBookId()%>" target="_blank"><%=bookInfo.getBookName()%></a></b> </td>
      <td align="center" class="biandi shenhui"><%=favorite.getDate()%></td>
      <td align="center" class="biandi shenhui">￥<%=bookInfo.getPrice()%></td>
      <td align="center" class="biandi shenhui">￥<%=bookInfo.getSpecialPrice()%></td>
      <td align="center" class="biandi shenhui">
                  <a href="GwcServlet?opType=addBook&id=<%=bookInfo.getBookId()%>" target="_blank">预售</a>&nbsp;
                  
      <a href="DeleteFavoriteServlet?id=<%=favorite.getFavoriteId()%>" onclick="return confirm('是否[<%=bookInfo.getBookName()%>]删除')">删除</a></td>
    </tr>
    <%
    		}
    	}
    %>
  </tbody></table>
  </div>