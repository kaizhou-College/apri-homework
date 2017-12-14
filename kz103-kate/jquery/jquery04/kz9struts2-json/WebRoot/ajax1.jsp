<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ajax1.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#frm1_login").submit(function(){
				//var dataStr = $("#frm1_login").serialize();
				//alert(dataStr);
				//[{"uname":"二狗子"},{"upwd":"123"},{"usex":"男"}]
				var dataArray= $("#frm1_login").serializeArray();
				$.ajax({
					url:"user_login",
					type:"POST",
					//方式一：字符串
					//data:"uname="+$("#uname").val()+"&upwd="+$("#upwd"),
					//方式二：json对象(推荐)
					//1，自己拼
					//2，jquery方法  2.1.serialize();  2.2serializeArray();(推荐)
					data:dataArray,
					success:function(data){
						console.log(data);
						alert("成功！！！"+data);
						
						//alert("user---"+data.users);
						//alert("user----"+data.users.uname);
						//{"prods":[{"pid":1,"pname":"吃鸡1","pprice":"12.2"},{},{}}
						for(var i=0;i<data.prods.length;i++){
							alert(data.prods[i].pid);
							alert(data.prods[i].pname);
						}
						
					},
					error:function(){
						alert("请求失败");
					}
					
				});
				//alert(1);
			})
			
		})
		
		
	</script>
  </head>
  
  <body>
  	<form id="frm1_login">
   	 	用户名:<input type="text" name="users.uname" id="uname"/><br/>
  		密&nbsp;&nbsp;码:<input type="password" name="users.upwd" id="upwd"/><br/>
  		性&nbsp;&nbsp;别:<input type="text"name="users.usex" id="usex"/><br/>
  		<input type="submit" value="提交"/>
  	</form>
  </body>
</html>
