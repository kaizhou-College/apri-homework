<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.cutegirl/jsp/jstl/yun/core" prefix="kz" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
 
  <kz:switch num="1">
		<kz:case1 num="1"/>
			我是case1输出的内容
		<kz:case2 num="2"/>
			我是case2输出的内容
		<kz:case3 num="3"/>
			我是case3输出的内容
	</kz:switch>
		
  </body>
</html>
