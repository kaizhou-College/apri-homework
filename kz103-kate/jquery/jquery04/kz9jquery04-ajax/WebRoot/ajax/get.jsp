<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'get.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#get").click(function(){
				$.get("../GetServlet","uname=二狗子",function(data){
				alert("成功     ！！"+data);
				//获取data中的数据 id和 name
				//方式1：substring 可以  不推荐
				//方法2：json对象(容易被别人截获)
				var dogArray = eval("("+data+")");
				//alert(dogArray);
				for(var i=0;i<dogArray.length;i++){
					alert(dogArray[i].id);
					alert(dogArray[i].name);
				}
				//$("#box").append(data);
			},"html");
				
			});
		});
	</script>
  </head>
  
  <body>
    <button id="get">get请求</button>
    <div id="box"></div>
  </body>
</html>
