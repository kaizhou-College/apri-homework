<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'servlet06.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <form action="servlet06" method="get">
  	<input type="text" name="num1">
  	<select name="fuhao">
  	<option name="+">+</option>
  	<option name="-">-</option>
  	<option name="*">*</option>
  	<option name="/">/</option>
  	</select>
  	<input type="text" name="num2">
  	<br/>
  	<br/>
  	<input type="submit" value="计算结果 ">
  <body>
  
  </body>
</html>
