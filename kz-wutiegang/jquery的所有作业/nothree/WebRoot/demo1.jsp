<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
body{
	font:normal 12px/17px Arial;
}
div{
    padding:2px;
} 
input, textarea { 
	 width: 12em; 
	 border: 1px solid #888;
}
.focus { 
	 border: 1px solid #f00;
	 background: #fcc;
} 
</style>
<!--   引入jQuery -->
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>

	

</head>
<body>
	<form action="" method="post" id="regForm">
		<fieldset>
			<legend>个人基本信息</legend>
				<div>
					<label  for="username">名称:</label>
					<input id="username" type="text"  value="名称" />
				</div>
                <div>
					<label for="pass">密码:</label>
					<input id="pass" type="password" value="密码" />
				</div>
                <div>
					<label for="pass">密码:</label>
					<input id="pass1" type="password" value="密码" />
				</div>
                <div>
					<label for="msg">详细信息:</label>
					<textarea id="msg" rows="2" cols="20">详细信息</textarea>
				</div>
		</fieldset>
	</form>
</body>
</html>
<script type="text/javascript">

	$("#username").focus(function(){
		//获得光标的时候内容隐藏，背景颜色改变
		
		$(this).removeAttr("value").css("background","pink");	
	});
	$("#username").blur(function(){
		//失去光标的时候添加内容
		$(this).removeAttr("style");
		$(this).attr("value","名称");	
	});
	$("#pass").focus(function(){
		//获得光标的时候内容隐藏，背景颜色改变
		
		$(this).removeAttr("value").css("background","pink");	
	});
	$("#pass").blur(function(){
		//失去光标的时候添加内容
		$(this).removeAttr("style");
		$(this).attr("value","密码");	
	});
	$("#pass1").focus(function(){
		//获得光标的时候内容隐藏，背景颜色改变
		
		$(this).removeAttr("value").css("background","pink");	
	});
	$("#pass1").blur(function(){
		//失去光标的时候添加内容
		$(this).removeAttr("style");
		$(this).attr("value","密码");	
	});

</script>