<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
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
		//0:id   -1:父亲是谁    
		d.add(0,-1,'系统菜单树');
		//第3个参数：点击的时候跳到哪里去  第4个参数跳转之后 在哪里回显jsp内容
		d.add(2,0,'员工管理','${basePath}/login/welcome.jsp','','mainFrame');
		d.add(1,0,'薪资管理','${basePath}/login/welcome.jsp','','mainFrame');
		//子目录添加
		d.add(3,2,'用户管理','${basePath}/user/user_list','','mainFrame');
		d.add(4,1,'用户管理111','${basePath}/user/list.jsp','','mainFrame');

		
		document.write(d);
		//-->
	</script>
</div>	</td>

  </tr>
</table>
</body>
</html>
