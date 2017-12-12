<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--   引入jQuery -->
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>

</head>
<body>
<div>
<br/>
筛选：
<input id="filterName" />
<br/>

</div>

<table>
	<thead>
		<tr><th>姓名</th><th>性别</th><th>暂住地</th></tr>
	</thead>
	<tbody>
		<tr><td>张山</td><td>男</td><td>浙江宁波</td></tr>
		<tr><td>李四</td><td>女</td><td>浙江杭州</td></tr>
		<tr><td>王五</td><td>男</td><td>湖南长沙</td></tr>
		<tr><td>找六</td><td>男</td><td>浙江温州</td></tr>
		<tr><td>Rain</td><td>男</td><td>浙江杭州</td></tr>
		<tr><td>MAXMAN</td><td>女</td><td>浙江杭州</td></tr>
		<tr><td>王六</td><td>男</td><td>浙江杭州</td></tr>
		<tr><td>李字</td><td>女</td><td>浙江杭州</td></tr>
		<tr><td>李四</td><td>男</td><td>湖南长沙</td></tr>
	</tbody>
</table>

</body>
</html>
<script type="text/javascript">
 	$(function(){
 		$("tbody tr").show();
 	});
 	$("#filterName").keyup(function(){
		var $name=$(this).val();
		
		$("tbody tr:contains('"+$name+"')").each(function(){
			$("tbody tr").hide();
			$(this).show();
		});
		
 	});
</script>