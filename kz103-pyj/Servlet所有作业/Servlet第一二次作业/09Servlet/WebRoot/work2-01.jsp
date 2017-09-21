<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 写一个jsp，其中含有一个用户名的文本框和密码框，要求提交到一个servlet(继承HttpServlet)
  要求分别在doGet()和doPost()方法中解决中文乱码问题，然后将用户名和密码打印输出到客户端
 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<form action="Work1">
  		<input type="text" name="text"><br/><br/>
  		<input type="password" name="pwd"><br/><br/>
  		<input type="submit" value="提交">
  	</form>
  </body>
</html>
