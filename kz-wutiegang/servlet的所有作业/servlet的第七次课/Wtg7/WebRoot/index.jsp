<%@ page language="java" import="java.util.*,javax.naming.*,javax.sql.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   		   
			Context context = new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");
			Connection conn=ds.getConnection();
			out.println(conn);
    		conn.close();//关键 这个关闭不是真正的关闭 是放回连接池
    
     %>
  </body>
</html>
