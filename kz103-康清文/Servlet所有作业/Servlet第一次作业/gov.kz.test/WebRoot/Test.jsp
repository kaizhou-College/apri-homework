<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test.jsp' starting page</title>
   

  </head>
  
  <body>
    		<form action="Test4" method="post">
    		<p>帐号：<input type="text" name="name" value=""></p>
    		<p>密码：<input type="password" name="pwd" value=""></p>
    		<p><input type="checkbox" name="sex" value="篮球">篮球
    		   <input type="checkbox" name="sex" value="足球">足球</p>
    		<p><input type="submit" name="xx" value="提交"></p>
    		</form>
  </body>
</html>
