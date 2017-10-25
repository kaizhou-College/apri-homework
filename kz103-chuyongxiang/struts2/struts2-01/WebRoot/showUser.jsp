<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <body>
  		<table>
  		<c:forEach items="${list}" var="list">
  		<tr>
  			<td><c:out value="${list.id}"></c:out></td>
  			<td><c:out value="${list.name}"></c:out></td>
  			<td><c:out value="${list.pwd}"></c:out></td>
  			<td><a href="delUser.action?id=${list.id}">删除</a></td>
  			</tr>
  		</c:forEach>
  		</table>
  </body>
  </body>
</html>
