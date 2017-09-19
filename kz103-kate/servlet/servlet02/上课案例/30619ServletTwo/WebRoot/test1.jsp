<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//在request中设置属性(键/值)
	request.setAttribute("name","tom");
	request.setAttribute("age","23");
	request.setAttribute("city","长沙");
	
	request.getRequestDispatcher("MyServlet3").forward(request,response);
	

%>
