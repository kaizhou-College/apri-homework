<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://servlet11/WebRoot/WEB-INF/el/kzservlet11"  prefix="kz" %>
<%@taglib uri="http://servlet11/WebRoot/WEB-INF/tag/work1"  prefix="kztag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
	<% //${kz:size(list)}%>
	<% //${kz:dateFormat("2015-02-03","yyyy年dd日MM月") }%>
	<%//${kz:indexOf("abcdefj","b") } %>
	<kztag:kzDate value="2017-05-01" pattern="yyyy年MM月dd日"></kztag:kzDate>
  </body>
</html>
