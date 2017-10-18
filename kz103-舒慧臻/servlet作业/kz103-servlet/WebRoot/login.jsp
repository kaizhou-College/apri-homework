<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
  	<!-- get提交 -->
    <form action="Servletwork04" method="post">
    	用户名：<input name="uname"/><br/>
    	密&nbsp;&nbsp;码<input type="password" name="pwd"/><br/>
    	<input type="submit" value="登录"/>
    </form>
  </body>
</html>
