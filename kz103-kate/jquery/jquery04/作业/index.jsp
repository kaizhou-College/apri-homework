<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/area.js"></script>
  </head>
  
  <body>
   	省:<select id="province">
   			<option>--请选择省份--</option>
   	  </select>
   	  <%--
   	省:<select id="province2">
   			<option>--请选择省份--</option>
   	  </select>
  --%>	
	     城市 :<select id="city">
	   			<option>--请选择城市--</option>
	   	  </select>
	     县区 :<select id="district">
	   			<option>--请选择区县--</option>
	   	  </select>
  
  </body>
</html>
