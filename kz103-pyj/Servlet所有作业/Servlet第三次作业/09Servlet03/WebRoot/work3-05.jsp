<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 写一个jsp，三个文本框，分别填写姓名，住址，工作单位,以post方式提交到StrServlet(继承GenericServlet),在web-inf准备一个
  str.properties文件
  文件内容: 二狗子 = **  (姓名)
            地狱 = ***    (住址)
            中央情报局=****  (工作单位)
   -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
  <form action="StrServlet" method="post">
  		用户名:<input type="text" name="name"><br/><br/>
  		住&nbsp;&nbsp;址:<input type="text" name="zhuzhi"><br/><br/>
  			工&nbsp;&nbsp;作:<input type="text" name="gongz"><br/><br/>
  			<input type="submit" value="提交">
  </form>
  </body>
</html>
