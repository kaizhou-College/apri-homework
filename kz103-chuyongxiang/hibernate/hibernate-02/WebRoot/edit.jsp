<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <script src="js/jquery-1.4.2.js" type="text/javascript"></script>
 <script type="text/javascript">
 
 $(document).ready(function(){
	 $("#xiugai").click(function(){
		 if($("#password").val()!=$("#password2").val()){
			 alert("两次密码不一致");
			 return false;
		 }
		 });
	 });
		 
	 
 
 </script>

  </head>
  <body>
   <form action="sys_edit" method="Post">
   <s:iterator value="sysuser" var="sysuser">
    <h3>修改</h3>
   	<br/>
    	姓&nbsp;&nbsp;名<input name="username" value="${sysuser.username}">
     <br/>
    	密&nbsp;&nbsp;码<input type="password" name="password"  id="password" value="${sysuser.password}">
    <br/>
    	确认密码<input type="password" name="password2" id="password2"/>
    	<br/>
    	
   <input type="submit" value="修改" id="xiugai"/>
   <br/>
    <input type="hidden" value="${sysuser.id}" name="id">
   </s:iterator>
    </form>
   
  </body>
</html>
<s:debug></s:debug>
