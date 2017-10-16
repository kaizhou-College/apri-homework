<%@ page language="java" import="java.util.*,entity.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
     <%
    int page1=(Integer)1;
  	//取出最大页数
  	int max = (Integer)UsersDao.getMaxPage(8);
   	//2,把数据做成表格
   		List<Users> list = UsersDao.selByPage(8,page1);//根据键去值;
   		request.setAttribute("page",page1);
   		request.setAttribute("max",max);
   		request.setAttribute("list",list);
   		request.getRequestDispatcher("index_page.jsp").forward(request,response);
    %>
  </body>
</html>
