<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'servlet04.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <body>
	<form action="servlet04" method="get">
  	<input type="text" name="number1"/>
  	<select name="ysf">
  		<option value="+">+</option>
  		<option value="-">-</option>
  		<option value="*">*</option>
  		<option value="/">/</option>
  	</select>
  	<input type="text" name="number2"/>
  	<input type="submit" value="提交"/>
	</form>
  </body>
</html>
