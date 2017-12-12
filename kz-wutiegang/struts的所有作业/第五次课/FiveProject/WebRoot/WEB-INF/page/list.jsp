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

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
  <div class="forms">
    <label for="name">名称</label>
        <input name="" type="text" class="nwinput" id="name"/>
        <label for="names">描述</label>
        <input name="" type="text" id="names" class="nwinput"/>
        <label for="time">开始时间</label>
        <input name="" type="text" id="time" class="nwinput"/>
        <label for="end-time">结束时间</label>
        <input name="" type="text" id="end-time" class="nwinput" />
        <label for="price">起拍价</label>
    <input name="" type="text" id="price" class="nwinput" />
    <input name="" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/>
  </div>
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
  			 	<a href="Auction_jinpai">竞拍</a>
  			</td>
  		</tr>
		</s:iterator>
  	
  	</table>

  </div>
</body>
</html>
