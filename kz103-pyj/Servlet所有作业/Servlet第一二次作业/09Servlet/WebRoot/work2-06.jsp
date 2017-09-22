<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 写一个jsp，一个用户名的文本框，三个爱好复选框（篮球，足球，排球），
然后提交到一个Servlet（继承GenericServlet），
  解决中文乱码问题以后，打印输出到客户端 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  		<form action="Work6" method="post">
  			用户名:<input type="text" name="name"><br/><br/>
  			爱&nbsp;好:<input type="checkbox" checked="checked" name="aihao" value="篮球">篮球
  			<input type="checkbox" name="aihao" value="足球">足球
  			<input type="checkbox" name="aihao" value="排球">排球<br/><br/>
  			<input type="submit" value="提交">
  		</form>
  </body>
</html>
