<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zy_2.jsp' starting page</title>
    
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
    	<form action="info.action">
    		name:<input name="name"/><br>
    		JG:<select name="JG">
    			<option value="qqq">qqq</option>
    			<option value="www">www</option>
    			<option value="eee">eee</option>
    			<option value="rrr">rrr</option>
    			</select><br>
    		sex: <input type="radio" value="男" name="sex"/>男<input type="radio" value="女" name="sex"/>女	<br>
    		<input type="submit" value="提交">
    	</form>
  </body>
</html>
