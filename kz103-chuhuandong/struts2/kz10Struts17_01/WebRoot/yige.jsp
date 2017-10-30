<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'yige.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- 测试二：写一个jsp,一个姓名的文本框，一个籍贯的下拉列表，两个单选框（性别）,提交到info.action中，准备一个InfoAction实现Action接口，
实现execute(),拿到姓名和籍贯和性别，如果性别是男的，就封装ActionForward(man.jsp,false),否则ActionForward(woman.jsp,false),在
在结果页面显示出表单的值,在actionConfig.properties配置好uri(info)和LoginAction关系 -->
  <body>
	<form action="info.action" method="post">
	  	<input type="text" name="name"/><br/>
	  	<select name="jiguan">
	  		<option>ssss</option>
	  		<option>aaaa</option>
	  	</select><br/>
	  	男：<input type="radio" name="sex" value="男" checked="checked"/>
	  	女：<input type="radio" name="sex" value="女"/>
	  	<input type="text" value="提交" />
	</form>
  </body>
</html>
