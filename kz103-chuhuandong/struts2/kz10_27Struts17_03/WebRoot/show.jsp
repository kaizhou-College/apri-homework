<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
  	<table align="center" border="1">
  		<tr>
  			<td>编号</td>
  			<td>客户名称</td>
  			<td>商品名称</td>
  			<td>订单金额</td>
  			<td>下单日期</td>
  			<td>修改</td>
  		</tr>
  		<c:forEach items="${list}" var="list">
  			<tr>
  				<td>${list.ordered }</td>
  				<td>${list.custname }</td>
  				<td>${list.prodname }</td>
  				<td>${list.ordercount }</td>
  				<td>${list.orderdate }</td>
  				<td><a href="update.do?id=${list.ordered }">点鸡修改</a></td>
  			</tr>
  		</c:forEach>
  		<tr align="center">
  			<td colspan="6"><a href="O_Add.jsp">增加</a></td>
  		</tr>
  	</table>
  </body>
</html>
