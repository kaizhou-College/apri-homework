<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://IFtop" prefix="kz"  %>
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
  
  <body><div><br></div>
  
  	<%--<kz:if test="${2==1}">
  	我是if
  	<kz:elseIf test="${2==1}"/>
  	我是elseif
  	<kz:else/>
  	我是else
  	</kz:if>--%>
  	
  	<kz:switch test="3">
  	<kz:case value="1"/>
  	我是case1
  	<kz:case1 value="2"/>
  	我是case2
  	<kz:case2 value="3"/>
  	我是case3
  	</kz:switch>
  	
  </body>
</html>
