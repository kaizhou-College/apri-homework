<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="entity.book"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
  <table border="1">
  <tr>
  	<td>name</td><td>price</td><td>writer</td>
  </tr>
	<%
	 List<book> list=(List)request.getAttribute("sel");
		for(int i=0;i<list.size();i++){%>
		<tr>	
			<td><%=list.get(i).getName() %></td>
			<td><%=list.get(i).getPrice() %></td>
			<td><%=list.get(i).getWriter() %></td>
		</tr>
		<%}
	 %>
	</table>
  </body>
</html>
