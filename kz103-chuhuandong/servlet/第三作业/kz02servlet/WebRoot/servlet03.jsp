<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'servlet02.jsp' starting page</title>
  </head>
  <body>
  	<!-- 3.在一个jsp页面中,向request里面设置三个值（用户名，密码，和爱好（爱好，注意对应的value是个字符串数组））,
  	然后转发到一个Servlet(继承GenericServlet)里面,拿出参数名和参数值，并输出到客户端（使用表格） -->
	<form action="servlet03" method="post">
  		<input type="text" name="name"/><br>
  		<input type="password" name="pwd"/><br/>
  		爱好1：<input type="checkbox" name="hobby" value="爱好1"/>爱好2：<input type="checkbox" name="hobby" value="爱好2"/><br/>
  		<input type="submit" value="提交"/>
	</form>
  </body>
</html>
