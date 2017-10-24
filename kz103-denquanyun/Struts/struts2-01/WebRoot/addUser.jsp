<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addUser.jsp' starting page</title>
  </head>
  <body>
    		<form action="addUser.action" method="post">
    				用户名：<input name="name"/>
    				密码:<input type="password" name="pwd"/>
    				<input type="submit" value="添加"/>
    		</form>
  </body>
</html>
