<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DiSi.jsp' starting page</title>
    
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
    <form action="DiSi" method="post">
    	请输入用户编号：<input type="text" name="bianhao"/><br/><br/>
    	请输入用户名：<input type="text" name="name"/><br/><br/>
    	爱好：<input type="checkbox" name="aihao" checked="checked"/>篮球
    	<input type="checkbox" name="aihao"/>足球<br/><br/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
