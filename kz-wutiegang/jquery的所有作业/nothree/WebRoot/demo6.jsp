<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--   引入jQuery -->
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>

</head>
<body>

<form method="post" action="">
	<div class="int">
		<label for="username">用户名:</label>
		<input type="text" id="username" class="required" />
	</div>
	<div class="int">
		<label for="email">邮箱:</label>
		<input type="text" id="email" class="required" />
	</div>
	<div class="int">
		<label for="personinfo">个人资料:</label>
		<input type="text" id="personinfo" />
	</div>
	<div class="sub">
		<input type="submit" value="提交" id="send"/><input type="reset" id="res"/>
	</div>
</form>

</body>
</html>
<script type="text/javascript">
	$(function(){
		$("input:lt(2)").after("<span id='uname'>*</span>");
		$("span").css("color","red");
	});
	//键盘按下上来的时候记录长度并判断长度并显示错误
	$("#username").keyup(function(){
		var $length=$(this).val().trim().length;
		if($length>4){
			$("#leg").remove();
			$("#uname").after("<span id='leg'>用户名的长度不能大于四个长度</span>");
			$("#leg").addClass("onError");
		}else{
			$("#leg").remove();
		}
		
	});
	
	//提交按钮时启用submit事件
	$("form").submit(function(){
		if($("#username").val().length<=3){
			$("#uname").after("<span id='leg'>用户名的长度不能大于四个长度并且不能为空</span>");
			return false;
		}else{
			return true;
		
		}
	
		
	});
		
		
</script>