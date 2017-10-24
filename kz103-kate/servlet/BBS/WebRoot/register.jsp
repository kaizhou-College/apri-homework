<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'register.jsp' starting page</title>
  </head>
  
  <body>
	
	<form action="RegServlet" method="post">
		用户名:<input name="uname"/><br/>
		密&nbsp;&nbsp;码:<input type="password" name="pwd"/><br/>
		<input type="submit" value="注册"/>
	</form>    

  </body>
</html>
