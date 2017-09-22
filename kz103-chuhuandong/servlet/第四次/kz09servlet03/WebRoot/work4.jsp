<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'work4.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	4.写一个jsp,有一个表单，可以输入用户名，选择性别，选择爱好多个复选框，个人资料的文本域，用post提交到一个Servlet，写一个filter过滤请求
  遍历所有的值，如果有为null，就给它一个空字符串，然后在servlet中得到数据，要解决中文乱码问题,然后打印输出到客户端.
	-->
  </head>
  
  <body>
  		<form action="servlet04" method="post">
  			用户名：<input type="text" name="name"/><br>
  			男：<input type="radio" name="sex" value="男"/>女：<input type="radio" name="sex" value="女"/><br>
  			篮球：<input type="checkbox" name="hobby" value="篮球"/><br>
  			排球：<input type="checkbox" name="hobby" value="排球"/><br>
  			足球：<input type="checkbox" name="hobby" value="足球"/><br>
  			个人资料：<textarea name="grzl"></textarea>
  			<input type="submit" value="体骄傲"/>
  		</form>
  </body>
</html>
