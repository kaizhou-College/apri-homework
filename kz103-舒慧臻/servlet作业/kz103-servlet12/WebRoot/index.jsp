<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.kaizhouendu.com/jsp/jstl/kz/core" prefix="bd" %>
<%@taglib uri="WEB-INF/tag/TestTag.tld" prefix="tt"%>
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
  <%-- 
	<bd:loop count="5">
		你好，再见！<br/>
	</bd:loop>
	
	<c:if test=""></c:if>
  --%>
  <tt:tagIf test="${1==2}"><!-- doStartTag()方法-->
  		if条件成立时该执行的代码
	  	<tt:elseIf test="${1==1}"/>
	  		else if成立时该执行的代码
	  	<tt:else/>
	  		else条件成立时该执行的代码
  </tt:tagIf>
  
  </body>
</html>
