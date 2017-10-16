<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="httt://www.tanzhouedu.com/kz/el/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="WEB-INF/tag/kztag.tld" prefix="kz" %>
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
   <%---
	<kztag:loop count="6">
		<%=new Date().toLocaleString()%><br/>
	</kztag:loop>
   	 --%>
  	<kz:kzif test="${1==2}"><!-- KzIfTag的doStartTag()方法 -->
		 	我是if条件成立时改执行的代码<!-- setBodyContent() ->doInitBody->doAfterBody() -->
		<kz:kzelseif test="${1==1}"/><!-- KzElseIfTag的doStartTag()方法 -->
			我是else  if条件成立时改执行的代码
		<kz:kzelse/>
			我是else条件成立时改执行的代码
	</kz:kzif>
	
	
   <br/>
   <c:set var="d" value="<%=new Date()%>"></c:set>
   ${fn:formateDate(d,"yyyy年MM月dd日 hh时")}
   
  </body>
</html>
