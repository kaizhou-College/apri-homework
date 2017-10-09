<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'servletfilter-4.jsp' starting page</title>
    
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
   		<form action="Servletwork04" method="post"> 
   			用户名：<input type="text" name="user"/>
   			<br/>
   			<br/>
   			性别：<label><input type="radio" name="sex" value="男" checked="checked"/>男</label>
   			<label><input type="radio" name="sex" value="女"/>女</label>
   			<br/>
   			<br/>
   			爱好：<label><input type="checkbox" name="hoppy" value="吃" />吃</label>
   			<label><input type="checkbox" name="hoppy" value="喝"/>喝</label>
   			<label><input type="checkbox" name="hoppy" value="玩"/>玩</label>
   			<br/>
   			<br/>
   			个人资料：<textarea rows="5" cols="3" name="ziliao"></textarea>
   			<br/>
   			<br/>
   			<input type="submit" value="登录" />		
   		</form>
  </body>
</html>
