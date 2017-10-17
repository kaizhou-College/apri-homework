<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.Wtg.com/Loop" prefix="t" %>
<%@taglib uri="http://www.Wtg.com/Switch" prefix="kz" %>
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
   <%--  <t:loop count="5">
    	<%=new Date() %><br/>
    </t:loop>--%>
    <kz:Switch test="${'v3'}">
		<kz:Case1 value="v1"/>
			我是case1输出的内容
		<kz:Case2 value="v2"/>
			我是case2输出的内容
		<kz:Case3 value="v3"/>
			我是case3输出的内容
	</kz:Switch>
  </body>
</html>
