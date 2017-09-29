<%@ page language="java" import="java.sql.*,java.util.*,javax.sql.*,com.kz.entity.Man,javax.naming.*" pageEncoding="UTF-8"%>
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
    	//tomcat默认的菜名前缀:java:comp/env
    	//Man man = (Man)context.lookup("java:comp/env/java/man");
    	//out.print(man);
    	Long start = System.currentTimeMillis();
    	DataSource ds = (DataSource)context.lookup("java:comp/env/conn/oracle");
     	Connection conn = null;
     	for(int i=0;i<10000;i++){
     		conn = ds.getConnection();
     		//out.print("conn=="+conn);
     		conn.close();//不是真正的关 是将conn放回连接池
     	}
     	Long end = System.currentTimeMillis();
		System.out.println("获取传统方式得到1w个连接的时间"+(end-start));
     	
     %>
	
  </body>
</html>
