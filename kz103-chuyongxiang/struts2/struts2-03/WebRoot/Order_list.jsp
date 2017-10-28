<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page import="entity.Orders"%>
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
  
  <body align="center">
  <table align="center" border="1">
  	<tr>
  	<td>编号</td>
  	<td>客户名称</td>
  	<td>商品名称</td>
  	<td>订单金额</td>
  	<td>下单日期</td>
  	</tr>
  	<c:forEach items="${list}" var="s">
  		<tr>
  			<td>${s.ordered}</td>
  			<td>${s.custName}</td>
  			<td>${s.prodName}</td>
  			<td>${s.orderCount}</td>
  			<td>${s.orderDate}</td>
  			<td><a href="DeleteAction.action?ordered=${s.ordered}">删除</a></td>
  			<td><a href="Order_update.jsp?ordered=${s.ordered}&custName=${s.custName}">修改</a></td>
		</tr>  
  	</c:forEach>
  	<a href="Order_add.jsp">添加</a>
  </table>
  </body>
</html>
