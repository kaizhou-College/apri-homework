<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'servlet02.jsp' starting page</title>
  </head>
  <body>
	<form action="servlet02" method="post">
  		用户编号:<input type="text" name="number"/><br/>
  		用户名:<input type="text" name="name"/><br/>
  		<input type="checkbox" name="hobby" value="爱好1"/>爱好1<input type="checkbox" name="hobby" value="爱好2" />爱好2<br/>
  		<input type="submit" value="提交" />
	</form>
  </body>
</html>
