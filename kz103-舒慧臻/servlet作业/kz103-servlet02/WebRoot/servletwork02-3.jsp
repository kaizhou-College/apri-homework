<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'servletwork02-3.jsp' starting page</title>
    
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
    	<form action="Servletwork03" method="post">
    		用户名：<input type="text" name="user"/>
    		<br/>
    		密码：<input type="password" name="pswd"/>
    		<br/>
    		爱好：<input type="checkbox" name="hoppy" value="游泳"/>游泳
    			<input type="checkbox" name="hoppy" value="阅读" />阅读
    			<input type="checkbox" name="hoppy" value="辩论" />辩论
    		<input type="submit" value="登录"/>
    	</form>
  </body>
</html>
