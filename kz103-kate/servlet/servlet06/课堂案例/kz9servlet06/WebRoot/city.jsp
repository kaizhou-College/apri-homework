<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'city.jsp' starting page</title>
	<script type="text/javascript" src="js/kz.js"></script>
  </head>
  
  <body>
    <select id="province" onchange="pickCityPost(this)">
    	<option>--请选择省份--</option>
    	<c:forEach items="${pros}" var="p">
    		<option value="${p.pid}">${p.pname }</option>
    	</c:forEach>
    </select>
    <select id="city" >
    	<option>--请选择市--</option>
    </select>
  </body>
</html>
