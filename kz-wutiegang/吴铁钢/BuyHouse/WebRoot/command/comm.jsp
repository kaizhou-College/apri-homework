<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);

%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://www.kaizhouendu.com/jsp/jstl/kz/core" prefix="kz" %>
