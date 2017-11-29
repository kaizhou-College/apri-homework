<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/comm.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${basePath}/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${basePath}/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${basePath}/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		//参数1：id   参数2：父类id  参数3：菜单名字 参数4：菜单的页面  参数6：在哪里显示
		d.add(0,-1,'系统菜单树');
		d.add(2,0,'员工管理','${basePath}/login/welcome.jsp','','mainFrame');
		
		//子目录添加
		d.add(3,2,'用户管理','${basePath}/user_list','','mainFrame');

		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
