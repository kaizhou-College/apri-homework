<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.Wtg.com/Page" prefix="pg" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp4.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
  	function DoGo(maxPage){
  	
  			//取出用户输入的页数
  		var jpage = document.getElementById("ipage").value;
  		//alert(typeof(jpage));
  		//jpage是string类型  转为整数
  		if(!isNaN(jpage)){
  			jpage = parseInt(jpage);
  			if(jpage>0&&jpage<=maxPage){
  				location.href="pageServlet?currentPage="+jpage;
  			}else{
  				alert("唐雪松来了.....");
  			}
  		}else{
  				alert("唐雪松又来了.....");
  		}
  		
  	}
   </script>
  </head>
  
  <body>
    <pg:Page maxPage="${max}" currentPage="${page}"></pg:Page>
  </body>
</html>
