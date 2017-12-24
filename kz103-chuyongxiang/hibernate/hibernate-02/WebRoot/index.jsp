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
  <body>
    <table border="1">
    <tr>
    <td style="background-color: red">ID</td>
    <td style="background-color: red">姓名</td>
    <td style="background-color: red">密码</td>
    <td style="background-color: red">操作</td>
    </tr>
    <s:iterator value="sysuserlist" var="sysuserlist">
    	<tr>
    	<td><s:property value="#sysuserlist.id"/></td>
    	<td><s:property value="#sysuserlist.username"/></td>
    	<td><s:property value="#sysuserlist.password"/></td>
    	<td>
    		<a href="sys_toedit?id=<s:property value="#sysuserlist.id"/>">编辑</a>
    		<a href="sys_delete?id=<s:property value="#sysuserlist.id"/>">删除</a>
    	</td>
    	</tr>
    </s:iterator>
    </table>
    <a href="sys_select">查询</a>
    <br/>
  </body>
</html>
 <s:debug></s:debug>
