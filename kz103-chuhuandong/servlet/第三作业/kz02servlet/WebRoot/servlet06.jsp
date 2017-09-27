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
	6.写一个jsp，一个用户名的文本框，三个爱好复选框（篮球，足球，排球），然后提交到一个Servlet（继承GenericServlet），
  解决中文乱码问题以后，打印输出到客户端
	-->
  </head>
  <body>
	<form action="servlet06" method="post">
  		用户名：<input type="text" name="name"/><br/>
  		篮球：<input type="checkbox" name="hobby" value="篮球"/><br/>
  		排球：<input type="checkbox" name="hobby" value="排球"/><br/>
  		足球：<input type="checkbox" name="hobby" value="足球"/><br/>
  		<input type="submit" value="提交"/>
	</form>
  </body>
</html>
