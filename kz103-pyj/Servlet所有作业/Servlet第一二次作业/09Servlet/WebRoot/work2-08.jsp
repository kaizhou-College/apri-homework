<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 写一个index.jsp其中含有一个用户名的文本框，三个单选框，
表示三个产品（苹果，梨子，香蕉）的表单,表单提交到一个
  servlet（继承HttpServlet）中，将用户名和产品保存到session中,
  然后从定向到result.jsp,显示用户名和产品名称 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<form action="Work8" method="post">
  		用户名:<input type="text" name="name"><br/><br/>
  		密&nbsp;码:<input type="radio" checked="checked" name="shuig" value="苹果">苹果
  		<input type="radio" name="shuig" value="梨子">梨子
  		<input type="radio" name="shuig" value="香蕉">香蕉<br/><br/>
  		<input type="submit" value="提交">
  	</form>
  </body>
</html>
