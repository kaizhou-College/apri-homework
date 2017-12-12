<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
* { margin:0; padding:0; }
div.centent {
   float:left;
   text-align: center;
   margin: 10px;
}
span { 
	display:block; 
	margin:2px 2px;
	padding:4px 10px; 
	background:#898989;
	cursor:pointer;
	font-size:12px;
	color:white;
}
</style>
<!--   引入jQuery -->
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>


</head>
<body>
	<div class="centent">
		<select multiple="multiple" id="select1" style="width:100px;height:160px;">
			<option value="1">选项1</option>
			<option value="2">选项2</option>
			<option value="3">选项3</option>
			<option value="4">选项4</option>
			<option value="5">选项5</option>
			<option value="6">选项6</option>
			<option value="7">选项7</option>
		</select>
		<div>
			<span id="add" >选中添加到右边&gt;&gt;</span>
			<span id="add_all" >全部添加到右边&gt;&gt;</span>
		</div>
	</div>

	<div class="centent">
		<select multiple="multiple" id="select2" style="width: 100px;height:160px;">
			<option value="8">选项8</option>
		</select>
		<div>
			<span id="remove">&lt;&lt;选中添加到左边</span>
			<span id="remove_all">&lt;&lt;全部添加到左边</span>
		</div>
	</div>


</body>
</html>
<script type="text/javascript">
	//appendTo()把某个元素追加到另一个元素之中
	//append()在某个元素中追加另一个元素
	$("#add").click(function(){
		$("#select1 option:selected").appendTo($("#select2"));
	});
	$("#add_all").click(function(){
		$("#select1 option").appendTo($("#select2"));
	});
	$("#remove").click(function(){
		$("#select2 option:selected").appendTo($("#select1"));
	});
	$("#remove_all").click(function(){
		$("#select2 option").appendTo($("#select1"));
	});
</script>
