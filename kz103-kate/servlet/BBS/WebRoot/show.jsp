<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.kaizhouendu.com/jsp/jstl/kz/core" prefix="kz"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.box{
			position:absolute;
			left: 30%;
		}
		
		
	</style>
  </head>
  
  <body>
  	<div class="box">
  	<div class="subBox">
   	 请求次数：${count}&nbsp;&nbsp; 总访问量：${all}&nbsp;&nbsp;在线人数：${online}
 	<br/>
 	   <h2>欢迎使用BBS<h2>
 	   <a href="">发帖</a>
 	
 	   <table cellspacing="20px" >
 	   		<tr>
 	   			<th>回复</th>
 	   			<th>标题</th>
 	   			<th>作者</th>
 	   			<th>时间</th>
 	   		</tr>
 	   		<c:forEach items="${msgs}" var="msg">
 	   		<tr>
 	   			<td>${msg.count }</td>
 	   			<td>${msg.title }</td>
 	   			<td>${msg.writer }</td>
 	   			<td>${msg.writedate }</td>
 	   		</tr>
 	   		</c:forEach>
 	   		</div>
 	   </table>
 	   <kz:kzPage max="${max}" url="FindMsgServlet" page="${page}"></kz:kzPage>
 	  </div>
  </body>
</html>
