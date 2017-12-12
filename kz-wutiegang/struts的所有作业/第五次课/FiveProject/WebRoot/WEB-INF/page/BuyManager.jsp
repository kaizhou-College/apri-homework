<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="comm.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>
<s:debug></s:debug>
<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="Auction_pass" title="注销">注销</a></div>
  </div>
	<s:token></s:token>
	  <div class="forms">
	    <form action="Auction_gaoJi" method="post">
		    <label for="name">名称</label>
		    <input type="text" class="nwinput" id="name" name="action.auctionname" />
		    <label for="names">描述</label>
		    <input type="text" id="names" class="nwinput" name="action.auctiondesc" />
		    <label for="time">开始时间</label>
		    <input type="text" id="time" class="nwinput" name="action.auctionstarttime" />
		    <label for="end-time">结束时间</label>
		    <input type="text" id="end-time" class="nwinput" name="action.auctionendtime" />
		    <label for="price">起拍价</label>
		    <input type="text" id="price" class="nwinput" name="action.auctionstartprice" />
		    <input type="submit"  value="查询"/>
	     </form>
	  </div>
	  <a href="Auction_fb" class="spbg buttombg f14  sale-buttom buttomb">发布</a>
  <div class="items">
  	<table border=1>
  		<tr class="rows even strong">
  			<td>名称</td>
  			<td class="list-wd">描述</td>
  			<td>开始时间</td>
  			<td>结束时间</td>
  			<td>起拍价</td>
  			<td class="list-wd">操作</td>
  		</tr>
  		<s:iterator value="auction" var="au">
  		<tr>
  			<td><a href="#"><s:property value="#au.auctionname"/></a></td>
  			<td class="list-wd"><s:property value="#au.auctiondesc"/></td>
  			<td><s:property value="#au.auctionstarttime"/></td>
  			<td><s:property value="#au.auctionendtime"/></td>
  			<td><s:property value="#au.auctionstartprice"/></td>
  			<td class="borderno red">
  			  <a href="Auction_byId?updateId=<s:property value='#au.auctionid'/>">修改</a>
        	  <a href="Auction_delete?id=<s:property value='#au.auctionid'/>">删除</a>
  			</td>
  		</tr>
		</s:iterator>
  	
  	</table>
  	<kz:kzPage max="${max}" url="Auction_find" page="${page}"></kz:kzPage>
	
  </div>
  <script>
  
	function DoGo(max){
  			//取出用户输入的页数
  		var jpage = document.getElementById("ipage").value;
  		//alert(typeof(jpage));
  		//jpage是string类型  转为整数
  		if(!isNaN(jpage)){
  			jpage = parseInt(jpage);
  			if(jpage>0&&jpage<=max){
  				location.href="Auction_find?page="+jpage;
  			}else{
  				alert("操作错误.....");
  			}
  		}else{
  				alert("操作错误.....");
  		}
  		
  	}

  </script>
<!-- main end-->
</div>
</body>
</html>
