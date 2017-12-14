<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'getScript.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
  	<style type="text/css">
  		.mini{
  			width:100px;
  			height:100px;
  			border: 2px solid red;
  		}
  	</style>
  	<script type="text/javascript">
  		$(function(){
  			$("#gs").click(function(){
  				$.getScript("../my.js");
  				
  			});
  		});
  	
  	</script>
  </head>
  
  <body>
    <button id="gs">getScript请求</button>
    <div id="box" ></div>
  </body>
</html>
