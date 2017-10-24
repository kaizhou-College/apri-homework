<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.kz.entity.Users"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUser.jsp' starting page</title>
    
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
  <table border="1" align="center" width="80%">
  			<tr>
  				<td>name</td>
  				<td>pwd</td>
  				<td>date</td>
  				<td>chaozuo</td>
  			</tr>
		<% List<Users> list= (List<Users>)request.getAttribute("list");
			for(int i=0;i<list.size();i++){
		 %>
			<tr>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getPwd() %></td>
				<td><%=list.get(i).getDate() %></td>
				<td><a href="delUser.action?id=<%=i%>">删除</a></td>
			</tr>
		<%} %>
  </table>
  </body>
</html>
