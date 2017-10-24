<%@ page language="java" import="java.util.*,com.kz.dao.BaseDao,com.kz.entity.*" pageEncoding="UTF-8"%>
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
    	for(Message u:new BaseDao<Message>().queryDataPage(Message.class,1,2)){
    		out.print(u+"<br/>");
    	}
    	Users2 t = new Users2();
    	t.setUname("拉登");
    	t.setUpassword("1111");
    	out.print(new BaseDao<Users2>().save("seq_users2",t));
     %>
  </body>
</html>
