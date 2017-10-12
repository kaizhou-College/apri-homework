<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'workFour.jsp' starting page</title>
    
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
    		<form action="Myservlet04" method="post">
    				用户名：<input name="name"/>
    				<br/>
    				性别：<input type="radio" name="sex" value="男"/>男&nbsp;&nbsp;<input type="radio" name="sex" value="女"/>女
    				<br/>
    				爱好：<input type="checkbox" name="hobby" value="吃">吃&nbsp;&nbsp;<input type="checkbox" name="hobby" value="喝">喝&nbsp;&nbsp;
    				<input type="checkbox" name="hobby" value="玩">玩&nbsp;&nbsp;<input type="checkbox" name="hobby" value="乐">乐
    				<br/>
    				个人资料：<textarea rows="3" cols="15" name="myself"></textarea>
    				<br/>
    				<input type="submit" value="提交"/>
    		</form>
  </body>
</html>
