<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/comm.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
		body
		{
			SCROLLBAR-ARROW-COLOR: #ffffff;  SCROLLBAR-BASE-COLOR: #dee3f7;
		}
    </style>
  </head>
  
<frameset rows="103,*,43" frameborder=0 border="0" framespacing="0">
  <frame src="${basePath}/login/top.jsp" name="topFrame" scrolling="NO" noresize>
  <frameset cols="159,*" frameborder="0" border="0" framespacing="0">
		<frame src="${basePath}/login/left.jsp" name="leftFrame" noresize scrolling="YES">
		<frame src="${basePath}/login/welcome.jsp" name="mainFrame">
  </frameset>
  <frame src="${basePath}/login/bottom.jsp" name="bottomFrame" scrolling="NO"  noresize>
</frameset>
</html>
