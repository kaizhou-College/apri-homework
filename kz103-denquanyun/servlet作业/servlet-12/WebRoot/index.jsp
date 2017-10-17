<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.cutegirl/jsp/jstl/yun/core" prefix="ytag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
   <!-- <ytag:loop count="5">匀匀是仙女</ytag:loop>-->
    
    <ytag:switch value="7">
		<ytag:case1 value="2"/>
			我是case1输出的内容
		<ytag:case2 value="4"/>
			我是case2输出的内容
		<ytag:case3 value="7"/>
			我是case3输出的内容
	</ytag:switch>
    
  </body>
</html>
