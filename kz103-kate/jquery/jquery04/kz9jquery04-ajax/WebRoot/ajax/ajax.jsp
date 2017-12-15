<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ajax.jsp' starting page</title>
    <script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			$("#ajax").bind("click",function(){
  				$.ajax({
		  			type:"post",
		  			url:"../AjaxServlet1",
		  			data:{"uname":"二狗子"},
		  			success:function(data){
		  				alert("成功！！"+data);
		  			},
		  			error:function(){
		  				alert("请求失败！！！");
		  			}
  				});
  		});
  		
  		});
  	</script>
  </head>
  	
  <body>
    <button id="ajax">ajax</button>
  </body>
</html>
