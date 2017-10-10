<%@ page language="java" import="java.util.*,com.kz.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <% 
  	/*九大内置对象：不要需要程序员创建，就可以直接使用的对象
  	applcation
  	session
  	request
  	response
  	pageContext
  	out
  	servletConfig对象
  	page		 对象
  	exception*/
  	
  	//session中设置值
  	User u= new User();
  	u.setName("苏大妈");
  	u.setUuid(1);
  	
  	session.setAttribute("u",u);
   
  %>
  
  
  
    This is my JSP page. <br><a href="exit.jsp">退出</a>
  </body>
</html>
