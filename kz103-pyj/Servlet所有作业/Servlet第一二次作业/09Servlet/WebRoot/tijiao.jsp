<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <!--4.从一个jsp页面上使用post方式提交一个用户编号，一个用户名，和爱好的两个复选项到Servlet，
  Servlet接收后处理编码问题，输出到控制台。(继承GenericServlet)
    -->
  <body>
		<form action="Tijiao" method="post">
			用户编号:<input type="text" name="id"><br/>
			用户名:<input type="text" name="name"><br/>
			爱&nbsp;好：<input type="checkbox"  checked="checked" name="aihao" value="购物">购物
			<input type="checkbox" name="aihao" value="读书">读书<br/>
			<input type="submit" value="登陆"/> 
		</form>
  </body>
</html>
