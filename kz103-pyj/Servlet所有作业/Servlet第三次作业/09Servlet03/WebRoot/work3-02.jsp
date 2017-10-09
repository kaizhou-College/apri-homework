<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 写一个用户名登录的jsp，可以填写密码和用户名，提交到登录的Encodeservlet中,
 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <form action="Encodeservlet">
  	用户名:<input type="text" name="name"><br/><br/>
  	密&nbsp;&nbsp;码:<input type="password" name="pwd"><br/><br/>
  	<input type="submit" value="提交">
  </form>
  </body>
</html>
