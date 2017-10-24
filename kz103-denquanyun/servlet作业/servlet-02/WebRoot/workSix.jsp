<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'workSix.jsp' starting page</title>
    
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
    
c 2017/9/21 21:01:30
	<form action="Myservlet06" method="post">
  		用户名：<input type="text" name="name"/><br/>
  		篮球：<input type="checkbox" name="hobby" value="篮球"/><br/>
  		排球：<input type="checkbox" name="hobby" value="排球"/><br/>
  		足球：<input type="checkbox" name="hobby" value="足球"/><br/>
  		<input type="submit" value="提交"/>
	</form>

  </body>
</html>
