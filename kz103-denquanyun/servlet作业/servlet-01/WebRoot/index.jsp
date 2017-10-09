<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <form method="post" action="Myservlet04">
    	用户编号：<input name="id"/>
    	用户名：<input name="name"/>
    	爱好：吃<input name="hobby" type="checkbox" value="吃"/>喝<input name="hobby" type="checkbox" value="喝"/>
    	玩<input name="hobby" type="checkbox" value="玩"/>乐<input name="hobby" type="checkbox" value="乐"/>
    	<input  type="submit" value="提交"/>
    </form>
  </body>
</html>
