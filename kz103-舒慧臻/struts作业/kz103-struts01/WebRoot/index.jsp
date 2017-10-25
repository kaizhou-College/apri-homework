<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<form action="login.action" method="post">
  		用户名：<input name="uname" type="text"/>
  		<br/>
  		<br/>
  		密&nbsp;&nbsp;码：<input name="upassword" type="password"/>
  		<br/>
  		<br/>
  		<input type="submit" value="提交" />
  	</form>
  	<a href="addUser.jsp">添加用户</a>
  	<a href="showUser.action">显示用户</a>
  </body>
</html>
