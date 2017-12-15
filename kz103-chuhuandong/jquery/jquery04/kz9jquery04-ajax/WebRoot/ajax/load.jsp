<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'load.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#ld").click(function(){
				$("#box").load("../LoadServlet",{"uname":"二狗子"},function(data){
					alert("成功！！！"+data);
				});
			});
		});
	</script>
  </head>
  
  <body>
    <button id="ld">Load请求</button>
    <div id="box"></div>
  </body>
</html>
