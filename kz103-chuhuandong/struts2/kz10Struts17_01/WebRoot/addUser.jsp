<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'addUser.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <!-- （2）点击“添加用户”,跳到addUser.jsp，其中有一个表单，能够填入姓名，密码，和出生日期，提交到addUser.action中 -->
  <body>
	<form action="addUser.action" method="post">
		  	姓名:<input type="text" name="name"/><br/>
  	密碼:<input type="password" name="pwd"/><br/>
  	出生日期:<input type="text" name="brithday"/>
		<input type="submit" value="ss"/>
	</form>
  </body>
</html>
