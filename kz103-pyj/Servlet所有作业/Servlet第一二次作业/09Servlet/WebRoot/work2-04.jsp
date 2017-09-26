<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  <%
  	request.setAttribute("request","tony");
  	session.setAttribute("session","kate");
  	application.setAttribute("application","zoe");
  	request.getRequestDispatcher("Work4").forward(request,response);
  	 %>
  </body>
</html>
