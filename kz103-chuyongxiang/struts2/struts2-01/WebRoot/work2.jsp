<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'work2.jsp' starting page</title>
    
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
  <form action="work2.action">
  	姓名：<input type="text" name="name">
  	籍贯：
  	<select name="jiguan">
  		<option value="a1">爱新觉罗</option>
  		<option value="a2">诸葛村夫</option>
  	</select>
  	性别：<input type="radio" name="sex" value="nan">男
  	<input type="radio" name="sex" value="nv">女
  	<input type="submit"  value="提交" />
  </form>
  </body>
</html>
