<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'servlet_6zy.jsp' starting page</title>
    
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
    <form action="servlet_6zy" method="post">
    <input name = "id1" size="3"/>
    <select name="ysf">
    	<option value="#">请选择</option> 
    	<option value="+">+</option>
    	<option value="-">-</option>
    	<option value="*">X</option>
    	<option value="/">/</option>
    </select>
    <input name = "id2" size="3"/>
    <input type="submit" value="计算">
    </form>
  </body>
</html>
