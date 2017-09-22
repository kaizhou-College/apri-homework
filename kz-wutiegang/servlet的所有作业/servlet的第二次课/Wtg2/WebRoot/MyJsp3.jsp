<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp3.jsp' starting page</title>
    
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
  	<form action="Test3" method="post">
  		用户名：<input type="text" name="uname"/><br/><br/>
  		密&nbsp;&nbsp;码：<input type="password" name="psw"/><br/><br/>
  		爱&nbsp;&nbsp;好：<input type="checkbox" name="aihao" value="海鲜" checked="checked"/>海鲜
  		<input type="checkbox" name="aihao" value="鸡"/>鸡<br/><br/>
  	<input type="submit" value="提交"/>
  	</form>
  </body>
</html>
