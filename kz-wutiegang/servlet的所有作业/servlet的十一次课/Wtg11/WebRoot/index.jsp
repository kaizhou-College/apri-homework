<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    ${fn:contains("abcdef","bc") }
    ${fn:containsIgnoreCase("abcdef", "EF")}
    ${fn:endsWith("a", ".txt")}
     ${fn:escapeXml("bhdud")}
    ${fn:indexOf("acd", "c")}
    ${fn:join(array, ";")}
    ${fn:length(book)}
    ${fn:replace("abcdef", "c", "-")}
    ${fn:split("abcdef", "-")}
    ${fn:startsWith("abcdef", "ag")}
    ${fn:substring("abcdef", 4, 5)}
    ${fn:substringAfter("abcdef", "c")}
    ${fn:substringBefore("abcdef", "c")}
    ${fn:toLowerCase("ABCDEF")}
  	${fn:toUpperCase("abcdef")}
    ${fn:trim(" abcd  ")}
  </body>
</html>
