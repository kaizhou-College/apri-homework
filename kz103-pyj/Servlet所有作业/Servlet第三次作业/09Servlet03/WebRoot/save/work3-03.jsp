<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- ，然后复制上题的登录页面，重命名
然后以post方式提交到LoginServlet中, -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
  	用户名:<input type="text" name="name"><br/><br/>
  	密&nbsp;&nbsp;码:<input type="password" name="pwd"><br/><br/>
  	<input type="submit" value="提交">
  </form>
  </body>
</html>
