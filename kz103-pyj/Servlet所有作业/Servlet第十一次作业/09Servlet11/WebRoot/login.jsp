<%@ page language="java" import="java.util.*,entity.*,dao.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
s  <body>
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
