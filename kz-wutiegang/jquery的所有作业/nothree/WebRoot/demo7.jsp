<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--   引入jQuery -->
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>

</head>
<body>
	<table>
		<thead>
			<tr><th>姓名</th><th>性别</th><th>暂住地</th></tr>
		</thead>
		<tbody>
			<tr class="parent" id="row_01"><td colspan="3">前台设计组</td></tr>
			<tr class="child_row_01"><td>张山</td><td>男</td><td>浙江宁波</td></tr>
			<tr class="child_row_01"><td>李四</td><td>女</td><td>浙江杭州</td></tr>

			<tr class="parent" id="row_02"><td colspan="3">前台开发组</td></tr>
			<tr class="child_row_02"><td>王五</td><td>男</td><td>湖南长沙</td></tr>
			<tr class="child_row_02"><td>找六</td><td>男</td><td>浙江温州</td></tr>

			<tr class="parent" id="row_03"><td colspan="3">后台开发组</td></tr>
			<tr class="child_row_03"><td>Rain</td><td>男</td><td>浙江杭州</td></tr>
			<tr class="child_row_03"><td>MAXMAN</td><td>女</td><td>浙江杭州</td></tr>
		</tbody>
	</table>
</body>
</html>
<script type="text/javascript">
	$(function(){
		$("#row_01").css("background","pink");
		$("#row_02").css("background","pink");
		$("#row_03").css("background","pink");
		$(".child_row_01").hide();
		$(".child_row_02").hide();
		$(".child_row_03").hide();
	});
	$("#row_01").toggle(function(){$(this).css("background","red");
		$(".child_row_01").show();},function(){$(this).css("background","pink");
		$(".child_row_01").hide();});
	$("#row_02").toggle(function(){$(this).css("background","red");
		$(".child_row_02").show();},function(){$(this).css("background","pink");
		$(".child_row_02").hide();});
	
	$("#row_03").toggle(function(){$(this).css("background","red");
		$(".child_row_03").show();},function(){$(this).css("background","pink");
		$(".child_row_03").hide();});
	
	
</script>