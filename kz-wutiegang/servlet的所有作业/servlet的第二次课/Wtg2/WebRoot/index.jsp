<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <form action="Test8" method="post">
    	用户名：<input name="uname"/><br/><br/>
    	水果：<input type="radio" name="fa" value="苹果"/>苹果
    	<input type="radio" name="fa" value="梨子"/>梨子
    	<input type="radio" name="fa" value="香蕉"/>香蕉<br/><br/>
   		 <input type="submit" value="提交"/>
    </form>
  </body>
</html>
