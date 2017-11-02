<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'show.jsp' starting page</title>
  </head>
  <body>
  			<table border="1" align="center">
  				<tr>
  					<td>编号</td>
  					<td>客户名称</td>
  					<td>商品编号</td>
  					<td>订单金额</td>
  					<td>下单日期</td>
  				</tr>
  				<c:forEach items="${list}" var="list">
  					<tr>
  						<td><c:out value="${list.ordered}"></c:out></td>
  						<td><c:out value="${list.custname}"></c:out></td>
  						<td><c:out value="${list.prodname}"></c:out></td>
  						<td><c:out value="${list.ordercount}"></c:out></td>
  						<td><c:out value="${list.orderdate}"></c:out></td>
  						<td><a href="order_update?id=${list.ordered}">修改</a></td>
  						<td><a href="order_delete?id=${list.ordered}">删除</a></td>
  					</tr>
  				</c:forEach>
  			</table>
  </body>
</html>
