<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var ajax;
		function check(){
			var name = document.getElementById("name").value;
			var pwd = document.getElementById("pwd").value;
			createAjax();
			method = "get";
			url="LoginAction.do?name="+encodeURI(name)+"&pwd="+pwd;
			ajax.open(method,url,true);
			ajax.send(null);
			ajax.onreadystatechange=bc;
		}
		function bc(){
			var s1 = document.getElementById("s1")
			var s2 = document.getElementById("s2");
			if(ajax.readyState==4&&ajax.status==200){
				var value = ajax.responseText;
				alert(value);
				if(value=='userisNull'){
					s1.innerHTML='用户不存在';
				}else{
					s1.innerHTML='';
				}
				if(value=='nameisNull'){
						s1.innerHTML='用户名不能为空';
					}else{
						s1.innerHTML='';
					}
				if(value=='pwdisNull'){
					alert("????")
					s2.innerHTML='密码不能为空';
				}else{
					s2.innerHTML='';
				}
				if(value=='pwdisError'){
						s2.innerHTML='密码错误'
					}else{
						s2.innerHTML='';
					}
						var name = document.getElementById("name").value;
		var pwd = document.getElementById("pwd").value;
				if(value=='ok'){
					location.href='user.do?u.userName='+name+'&u.userPwd='+pwd;
				}
			}
		}
		function createAjax(){
			if(window.XMLHttpRequest){
				ajax = new XMLHttpRequest();
			}else{
				ajax = new AtiveXObject("Microsoft.XMLHTTP");
			}
		}
	</script>
  </head>
  
  <body>
  	<div align="center">
  			  	<table>
  	  		<tr>
  	  	<td>用戶名：</td>
  	  	<td><input type="text" name="name" id="name"/></td>
  	  	<td id="s1"></td>
  	  		</tr>
  	  		<tr><td>密碼：</td>
  	  		<td><input type="password" name="pwd" id="pwd"/></td>
  	  		<td id="s2"></td>
  	  		</tr>
  	  	</table>
 		<div><input type="button" value="登陸" onclick="check()"/></div>
  	</div>
  </body>
</html>
