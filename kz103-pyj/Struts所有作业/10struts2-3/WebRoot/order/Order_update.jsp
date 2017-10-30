<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Order_update.jsp' starting page</title>
    
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
			<form action="UpdateAction.action" method="post">
		<table>
			<tr>
				<td>订单编号 ：</td>
				<td><input name="ordered" type="text"/></td>
			</tr>
			<tr>
				<td>客户名称   :</td>
				<td><input name="custname"/></td>
			</tr>
			<tr>
				<td>商品名称  :</td>
				<td><input name="prodname"/></td>
			</tr>
			<tr>
				<td>订单金额    :</td>
				<td><input name="ordercount"/></td>
			</tr>
			<tr>
				<td>下单日期  :</td>
				<td><input name="orderdate"/></td>
			</tr>
			<tr><td><input type="submit" value="修改"/></td></tr>
		</table>
	</form>
  </body>
</html>
