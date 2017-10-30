<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OrderUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%--订单编号 ordered    number           主键,自增1
客户名称 custName  varchar2  20      非空
商品名称 prodName  varchar2  20      非空
订单金额 orderCount  number(5,2)      非空,2位小数
下单日期 orderDate   date          	  非空 --%>
  <body>
  		<div align="center">
  			<form action="OrdersUpdateAction_execute.action">
  			<table >
  				<tr>
  					<td>
  						订单号
  					</td>
  					<td>
  						<input  type="text" name="ordered" value="<%=request.getParameter("id") %>" readonly="readonly" /> 
  					</td>
  				</tr>
  				<tr>
  					<td>
  						客户名称
  					</td>
  					<td>
  						<input  type="text" name="custName" value="<%=request.getParameter("name") %>" readonly="readonly" />
  					</td>
  				</tr>
  				<tr>
  					<td>
  						商品名称
  					</td>
  					<td>
  						<input  type="text" name="prodName"  />
  					</td>
  				</tr>
  				<tr>
  					<td>
  						订单金额
  					</td>
  					<td>
  						<input  type="text" name="orderCount" />
  					</td>
  				</tr>
  				<tr>
  					<td>
  						下单日期
  					</td>
  					<td>
  						<input  type="text" name="orderDate" />
  					</td>
  				</tr>
  				<tr>
  					<td colspan="2" align="center" >
  						<input type="submit" style="width: 285px" value="登入"/>
  					</td>
  				</tr>
  			</table>
  			</form>
  		</div>
  </body>
</html>
