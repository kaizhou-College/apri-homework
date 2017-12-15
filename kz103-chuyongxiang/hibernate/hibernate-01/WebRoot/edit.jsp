<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
   <form action="produc_edit">
   <s:iterator value="product" var="product">
    <h3>修改</h3>
   <br/>
    	名称<input name="pname" value="${product.pname}">
     <br/>
    	价格<input name="price"  value="${product.price}">
   <br/>
    	信息<input name="pinfo"  value="${product.pinfo}">
    <br/>
   <input type="submit" value="修改"/>
   <br/>
    <input type="hidden" value="${product.pid}" name="pid">
   </s:iterator>
    </form>
   
  </body>
</html>
<s:debug></s:debug>
