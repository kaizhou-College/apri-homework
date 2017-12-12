<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	
  </head>
  
  <body>
   	<form id="form_login">
   		用户名：<input type="text" name="user.uname" id="uname"/><br/><br/>
   		密码：<input type="password" name="user.upwd" id="upwd"/><br/><br/>
   		性别：<input type="text" name="user.usex" id="usex"/><br/><br/>
   		<input type="submit" value="提交"/>
   	</form>
  </body>
</html>
<script type="text/javascript">
	$(function(){
		$("#form_login").submit(function(){
			//获得表单输入的值分别作为一个对象
			var $formArray=$("#form_login").serializeArray();
			$.ajax({
				url:"user_login",
				type:"POST",
				data:$formArray,
				success:function(data){
					alert("111成功"+data.list);
					for(var i=0;i<data.list.length;i++){
						alert(data.list[i].pname);
						alert(data.list[i].pprice);
						alert(data.list[i].number);
					}
				},
				error:function(data){

					alert("222失败"+data);

				}
			
			})
		});
	
	
	});




</script>