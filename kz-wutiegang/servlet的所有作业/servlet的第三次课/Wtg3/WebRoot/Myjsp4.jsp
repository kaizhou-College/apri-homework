<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Myjsp4.jsp' starting page</title>
    
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
    <form action="MyServlet4" method="post"> 
    	用户名：<input name="uname"/><br/><br/>
    	性别：<input type="radio" name="sex" value="男" checked="checked"/>男
    	<input type="radio" name="sex" value="女"/>女<br/><br/>
    	爱好：<input type="checkbox" name="like" value="篮球"/>篮球
    	<input type="checkbox" name="like" value="排球"/>排球<br/><br/>
    	个人资料：<textarea rows="10" cols="50" name="info"></textarea><br/><br/>
    	<input type="submit" value="提交"/>
    
    </form>
  </body>
</html>
