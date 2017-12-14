<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Panel</title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" type="text/css"
			href="../easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="../easyui/themes/icon.css">
		<!--引入Jquery主文件-->
		<script type="text/javascript" src="../easyui/jquery.min.js">
</script>
		<!--引入JqueryEasyUI主文件-->
		<script type="text/javascript" src="../easyui/jquery.easyui.min.js">
</script>
<script type="text/javascript">
	$(function(){
		$("#dd2").draggable({
			handle:'#title'
			
		});
	})
	
</script>
	</head>

	<body>
		<%--<div id="dd" class="easyui-draggable" data-options="handler:'#title',revert:true"
			style="width: 300px; height: 300px; background:green">
			<div id="title" style="background: #ccc;">
				title
			</div>
		</div>

	--%>
	
	<div id="dd2" style="width:100px;height:100px;" > 
		<div id="title" style="background:#ccc;">title</div> 
	</div> 
	</body>
</html>
