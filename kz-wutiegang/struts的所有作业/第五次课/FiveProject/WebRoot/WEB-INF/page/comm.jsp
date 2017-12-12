<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.kaizhouendu.com/jsp/jstl/kz/core" prefix="kz"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);

%>
