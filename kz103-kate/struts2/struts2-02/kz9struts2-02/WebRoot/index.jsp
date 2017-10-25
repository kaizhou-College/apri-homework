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
  	<!--<a href="http://localhost:8080/kz9struts2-02/TestAction1">struts使用</a>
    -->
    <!-- 开始/代表的是服务器的根目录  不加/表示当前工程路径-->
    <a href="abc/def/TestAction1.action">struts使用</a><br/>
  	<a href="abc/def/TestAction2.action">action的创建方式二</a><br/>
  	<a href="abc/def/TestAction3.action">action的创建方式三</a><br/>
  	<!-- 指定方法的方式 -->
  	<a href="abc/def/TestAction33.action">action指定方法1</a><br/>
  	<a href="abc/def/TestAction1!test1.action">action指定方法2</a><br/>
  	<a href="abc/def/DynamicAction.action">action动态url</a><br/>
  		
  </body>
</html>
