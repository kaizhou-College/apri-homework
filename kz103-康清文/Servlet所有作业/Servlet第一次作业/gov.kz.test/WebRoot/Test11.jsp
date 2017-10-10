<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DiLiu.jsp' starting page</title>
    
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
   	<form action="Test11" method="POST">
   			<input name="test1"/><br/><br/>
   			<input name="test2"/><br/><br/>
   			<select name="m">
   				<option value="+" selected="selected">+</option>
   				<option value="-">-</option>
   				<option value="*">*</option>
   				<option value="/">/</option>
   			</select><br/><br/>
   	
   	<input type="submit" value="提交"/>
   	</form>
  </body>
</html>
