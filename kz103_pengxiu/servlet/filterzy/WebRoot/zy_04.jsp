<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zy)4.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    <form action="servlet_04" method="post">
    name<input   name="name" /><br/>
    age<input type="radio" name="age" value="男"/> 男<input type="radio" name="age" value="女"/>女<br/>
    ah<input type="checkbox" name="ah" value="a">a
    <input type="checkbox" name="ah" value="b">b
    <input type="checkbox" name="ah" value="c">c
    <input type="submit" value="登入" />
    </form>
  </body>
</html>