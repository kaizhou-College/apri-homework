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
    <div align="center">
    <form action="updateAction1" method="post">
    <input type="hidden" name="id" value="${orders.ordered }"/>
    	客户名称：<input name="custName" value="${orders.custName }" readonly="readonly"/><br/><br/>
    	商品名称：<input name="prodName" value="${orders.prodName }"/><br/><br/>
    	订单金额：<input name="ordercount" value="${orders.orderCount }" readonly="readonly"/><br/><br/>
    	下单时间：<input name="orderDate" value="${orders.orderDate }" readonly="readonly"/><br/><br/>
    	<input type="submit" value="更新"/>
    </form>
    </div>
  </body>
</html>
