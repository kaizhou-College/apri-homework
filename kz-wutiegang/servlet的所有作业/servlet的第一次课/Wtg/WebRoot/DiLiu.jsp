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
   	<form action="DiLiu" method="get">
   			文本1：<input name="wenben1"/><br/><br/>
   			文本2：<input name="wenben2"/><br/><br/>
   			运算符：<select name="fu">
   				<option value="+" selected="selected">+</option>
   				<option value="-">-</option>
   				<option value="*">*</option>
   				<option value="/">/</option>
   			</select><br/><br/>
   	
   	<input type="submit" value="提交"/>
   	</form>
  </body>
</html>
