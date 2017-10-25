<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showUser.jsp' starting page</title>
  </head>
  
  <body>
  		<table>
  		<c:forEach items="${list}" var="list">
  		<tr>
  			<td>	<c:out value="${list.uuid}"></c:out></td>
  				<td><c:out value="${list.uname}"></c:out></td>
  				<td><c:out value="${list.upassword}"></c:out></td>
  				<td><a href="delUser.action?id=${list.uuid}">删除</a></td>
  				</tr>
  		</c:forEach>
  		</table>
  </body>
</html>
