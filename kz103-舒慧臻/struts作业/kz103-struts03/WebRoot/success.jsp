<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>

  </head>
  
  <body>
  	<table>
  		<tr>
  			<td>订单编号</td>
  			<td>客户名称</td>
  			<td>商品名称</td>
  			<td>订单金额</td>
  			<td>下单日期</td>
  		</tr>
  		<c:forEach var="result" items="${list}">
  			<tr>
  				<td>${result.ordered }</td>
  				<td>${result.custname }</td>
  				<td>${result.prodname }</td>
  				<td>${result.ordercount }</td>
  				<td>${result.orderdate }</td>
  				<td><a href="updateAction.jsp?ordered=${result.ordered }">修改</td>
  				<td></a><a href="delAction_execute?ordered=${result.ordered}">删除</td>
  				<td></a><a href="addAction.jsp">添加</a></td>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
</html>
