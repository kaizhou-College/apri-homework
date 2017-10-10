<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <%
  	request.setAttribute("name", "abc");
    request.getRequestDispatcher("MyServlet3").forward(request, response);
  %>
  <body>
<!--     <form action="MyServlet3" method="post"> -->
<!--     	用户名：<input name="uname" /></br> -->
<!--     	密   码: <input type="password" name="pwd" /></br> -->
<!--     	<input type="submit" value="提交"/> -->
<!--     </form> -->
  </body>
</html>
