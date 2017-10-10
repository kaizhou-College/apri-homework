<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("name","tom");
	session.setAttribute("name","jack");
	application.setAttribute("name","marry");
	
	//请求转发
	request.getRequestDispatcher("MyServlet4").forward(request,response);

%>