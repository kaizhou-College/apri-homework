<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'reg.jsp' starting page</title>
  </head>
  
  <body>
   		<form action="MyServlet1" method="get">
   			编号:<input name="number"/><br/>
   			用户名:<input name="uname"/><br/>
   			爱好:<input type="checkbox" name="hobby" value="泡吧"/>泡吧
   			<input type="checkbox" name="hobby" value="泡妞"/>泡妞
   			<input type="checkbox" name="hobby" value="泡澡"/>泡澡<br/>
   			<input type="submit" value="注册"/>
   		</form>
  </body>
</html>
