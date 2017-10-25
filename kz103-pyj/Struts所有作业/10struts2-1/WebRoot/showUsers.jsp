<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>

  
  <body>
  		
    <table>
  		<c:forEach items="${list}" var="list">
  		<tr>
  			<td>	<c:out value="${list.uuid}"></c:out></td>
  				<td><c:out value="${list.uname}"></c:out></td>
  				<td><c:out value="${list.upassword}"></c:out></td>
  				<td><a href="delUsers.action?id=${list.uuid}">删除</a></td>
  				</tr>
  		</c:forEach>
  	</table>
  
  </body>
</html>
