<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java/wangdapao/dapao" prefix="work02" %>
<%@taglib uri="http://java.wangdapao.com/jsp/work" prefix="work01" %>
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
  	第一題:${work01:getSize(list)}<br/>
  	第二題:${work01:dateToString("2017-03-14","yyyy年MM月dd日") }<br/>
  	第四題:${work01:indexof("wohaha","o") }<br/>
  	第五題:<work02:dateToString value="2017-03-14" pattern="yyyy年MM月dd日"></work02:dateToString><br/>
  </body>
</html>
