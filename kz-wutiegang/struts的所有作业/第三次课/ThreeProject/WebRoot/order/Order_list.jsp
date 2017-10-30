<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Order_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	
  <table border=1 align="center">
  		<tr>
  			<td colspan="6" align="center"><h2>订单表</h2></td>
  		</tr>
  		<tr>
  			<th>编号</th>
  			<th>客户名称</th>
  			<th>商品名称</th>
  			<th>订单金额</th>
  			<th>下单时间</th>
  			<th>操作</th>
  		</tr>
 		<c:forEach items="${list}" var="li">
 			<tr>
 				<td>${li.ordered }</td>
	    		<td>${li.custName }</td>
	    		<td>${li.prodName }</td>
	    		<td>${li.orderCount}</td>
	    		<td>${li.orderDate}</td>
	    		<td><a href="updateAction?ordered=${li.ordered }">修改</a>
	    		<a href="deleteAction?ordered=${li.ordered }">删除</a></td>
	    	</tr>
 		</c:forEach>
	  
  </table>
  <a href="order/Order_add.jsp">新增</a>
    <s:debug></s:debug>
  </body>
</html>
