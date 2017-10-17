<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"    prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'work1.jsp' starting page</title>
    
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
	${fn:contains("aa","bb")} 
	${fn:containsIgnoreCase("bob","bb")}
	${fn:endsWith(aa, ".txt")}
	${fn:escapeXml(bb:info)}
	${fn:indexOf(ben, "-")}
	${fn:join(array, ";")}
	${fn:length(shoppingCart.products)}
	${fn:replace(text, "-", "&#149;")}
	 ${fn:split(customerNames, ";")}
	 ${fn:startsWith(product.id, "100-")}
	 ${fn:substring(zip, 6, -1)}
	 ${fn:substringAfter(zip, "-")}
	 ${fn:substringBefore(zip, "-")}
	 ${fn.toLowerCase(product.name)}
	 ${fn.UpperCase(product.name)}
	 ${fn.trim(name)}
  </body>
</html>
