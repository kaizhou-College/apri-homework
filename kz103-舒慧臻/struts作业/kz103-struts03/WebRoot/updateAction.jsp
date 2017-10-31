<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
  
  </head>
  
  <body>
	<form action="updateAction_execute" method="post">
		<table>
			<tr>
				<td>订单编号 ：</td>
				<td><input name="ordered" type="text" value="${ordered}"/></td>
			</tr>
			<tr>
				<td>客户名称   :</td>
				<td><input name="custname" value="${custname}"/></td>
			</tr>
			<tr>
				<td>商品名称  :</td>
				<td><input name="prodname" value="${prodname}"/></td>
			</tr>
			<tr>
				<td>订单金额    :</td>
				<td><input name="ordercount" value="${ordercount}"/></td>
			</tr>
			<tr>
				<td>下单日期  :</td>
				<td><input name="orderdate" value="${orderdate}"/></td>
			</tr>
			<tr><td><input type="submit" value="修改"/></td></tr>
		</table>
	</form>
  </body>
</html>
