<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'servlet01.jsp' starting page</title>
  </head>
  <body>
  <script type="text/javascript">
  	function check(){
  		var name = document.getElementById("name").value;
  		var pwd = document.getElementById("pwd").value
  		location.href='servlet01?name='+name+'&pwd='+pwd;
  	}
  </script>
  	<%--1.写一个jsp，其中含有一个用户名的文本框和密码框，要求提交到一个servlet(继承HttpServlet)
  要求分别在doGet()和doPost()方法中解决中文乱码问题，然后将用户名和密码打印输出到客户端 --%>
	<form action="servlet01" method="post">
		用户名:<input type="text" name="name" id="name"/>
		密码:<input type="password" name="pwd" id="pwd"/>
		<input type="submit" value="我是post"/>
	</form>
	<a onclick="check()">我是get</a>
  </body>
</html>
