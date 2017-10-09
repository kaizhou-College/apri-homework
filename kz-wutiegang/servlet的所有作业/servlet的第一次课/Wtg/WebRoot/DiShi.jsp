<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DiShi.jsp' starting page</title>
    
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
    <form action="DiShi" method="get">
    	文本1：<input name="wenben1"/>*填数字<br/><br/>
    	文本2：<input name="wenben2"/>*填数字<br/><br/>
    	文本3：<input name="wenben3"/>*填数字<br/><br/>
    	下拉框：<select name="xia"/>
    		<option value="max">max</option>
    		<option value="min">min</option>
    	</select>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
