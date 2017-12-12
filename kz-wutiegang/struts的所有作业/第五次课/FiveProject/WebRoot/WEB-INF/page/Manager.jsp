<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="comm.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="${basePath}css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
<s:debug></s:debug>
<s:actionerror/>
	<body>
		<div class="wrap">
			<div class="main">
				<div class="sidebarg fnone">
					<form action="AuctionUser_Mceshi" method="post" target='_blank'>
					<s:token></s:token>
						<div class="login">
							<dl>
								<dt>
									<s:text name="manager login"></s:text>
								</dt>
								<dd>
									<label for="name">
										<s:text name="name"></s:text>：
									</label>
									<input type="text" class="inputh" id="name" name="actionuser.username"/>
									<s:fielderror fieldName="actionuser.username"></s:fielderror>
								</dd>
								
								<dd>
									<label for="password">
										<s:text name="password"></s:text>：
									</label>
									<input type="password" class="inputh" id="password" name="actionuser.userpassword"/>
									<s:fielderror fieldName="actionuser.userpassword"></s:fielderror>
								</dd>
								
							 <dd>
					          		<label class="lf" for="passwords"><s:text name="identifying code"></s:text>：</label>
					           		<input type="text" class="inputh inputs lf" id="code" name="code" onblur="checkCode()"/>
					           		<span class="wordp lf"><img src="code.jsp" id="img" align="absmiddle" width="96" height="27" /></span>
					          		<span class="lf"><a href="javascript:change()"><s:text name="invisibility"></s:text></a></span>
					          		<div id="mess" style="display: inline;background-color: black;line-height: 30px;color: red"></div>
					          		 <%--<s:fielderror fieldName="code"></s:fielderror>--%>
					        </dd>
					       
					
								<dd class="buttom">
									<input id="logonbutton" type="submit" value="<s:text name="login"></s:text>"
										class="spbg buttombg buttomb f14 lf" />
									<a class="spbg buttombg buttomb f14 lf" href="AuctionUser_Zhuce"><s:text name="register"></s:text></a>
									
									</span>
									<div class="cl"></div>
								</dd>

							</dl>
						</div>
					</form>
				</div>
				<div class="cl"></div>
			</div>
		</div>
	<a href="AuctionUser_check?request_locale=zh_CN">简体中文</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="AuctionUser_check?request_locale=en_US">English</a>
	</body>
	
</html>
<script type="text/javascript">
		function checkCode(){
			//alert("1111");
			//根据id获取文本框输入的验证码
			var loginCode=document.getElementById("code").value;
		//alert(loginCode);
		//带输入的验证码跳到处理页面和图片里面的验证码进行比较
			doAjax("AuctionUser_checkCode?loginCode="+loginCode);
		}
		var ajax;
		function doAjax(url){
			createAjax();
			var method="post";
			ajax.open(method,url,true);
			ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			ajax.send(null);
			ajax.onreadystatechange=processRequest;
		
		}
		function processRequest(){
			var mess=document.getElementById("mess");
			
			if(ajax.readyState==4&&ajax.status==200){
				var boolean=ajax.responseText;
				//alert(boolean);
				if(boolean=="false"){
					document.getElementById("name").value="";
					mess.innerHTML="验证码不匹配";
					//document.getElementById("logonbutton").disabled ="disabled";
				}else{
					mess.innerHTML=" ";
					//document.getElementById("logonbutton").disabled="";
				}
			}
		}
		function change(){
			//alert("222");
			document.getElementById("img").src="code.jsp?"+Math.random();
		}
	
	
	
	
	
			function createAjax(){
				//判断浏览器的版本：ie7或以上
				if (window.XMLHttpRequest) {
					ajax = new XMLHttpRequest();
				} else {
					ajax = new ActiveXObject("Microsoft.XMLHTTP");
				}
		}
	
	</script>