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
  <s:debug></s:debug>
  <body>
    <table border="1">
    <tr>
    <td>编号</td>
    <td>名称</td>
    <td>价格</td>
    <td>信息</td>
    <td>操作</td>
    </tr>
    
     <s:iterator value="listproduct" var="listproduct">
    	<tr>
    		<td><s:property value="#listproduct.pid"/></td>
    		<td><s:property value="#listproduct.pname"/></td>
    		<td><s:property value="#listproduct.price"/></td>
    		<td><s:property value="#listproduct.pinfo"/></td>
    		<td>
    		<a href="produc_toedit?pid=<s:property value="#listproduct.pid"/>">修改</a>
    		<a href="produc_delete?pid=<s:property value="#listproduct.pid"/>">删除</a>
    		</td>
    	</tr>
    </s:iterator>
    
    </table>
    <a href="produc_select">查询</a>
    
    <br/>
    <form action="produc_add">
    <h3>注册</h3>
   <br/>
    	名称<input name="pname">
     <br/>
    	价格<input name="price">
   <br/>
    	信息<input name="pinfo">
    <br/>
   <input type="submit" value="添加"/>
   <br/>
    
    </form>
  </body>
</html>
