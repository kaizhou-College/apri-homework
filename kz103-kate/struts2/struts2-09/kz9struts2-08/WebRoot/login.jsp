<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
  	<!-- 值栈： -->
  	<s:actionerror/>
    <form action="user_logon"  method="post">
    	<s:token></s:token>
    	用户名：<input name="uname"/><br/>
    	密码:<input type="password" name="upwd"/><br/>
    	<input type="submit" value="登 	录"/>
    </form>
    <s:debug></s:debug>
	
  </body>
</html>
