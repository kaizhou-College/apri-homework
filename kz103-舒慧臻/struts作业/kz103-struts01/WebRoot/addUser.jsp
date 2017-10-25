<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>

  </head>
  
  <body>
  	<form action="addUser.action" method="post">
  		姓名：<input name="uname" type="text"/>
  		<br/>
  		<br/>
  		密码：<input name="password" type="password"/>
  		<br/>
  		<br/>
  		出生日期：<input name="birthday" type="text"/>
  		<br/>
  		<br/>
  		<input type="submit" value="添加"/>	
  	</form>
  </body>
</html>
