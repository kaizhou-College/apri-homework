<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../comm/comm.jsp"%>
<HTML>
<HEAD>
<TITLE>北京出租房</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

<link href="${basePath}/style/mycss.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/style/texts.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/style/btn.css" rel="stylesheet" type="text/css" />
<script lang="javascript">
	function login(){
		if( document.myForm.uname.value =="" ){
			alert("用户名不能为空");
			return false;
		}else if(document.myForm.upass.value == ""){
			alert("密码不能为空");
			return false;
		} else {
			return true;
		}
	}
</script>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="${basePath}/images/top.jpg" width="780" height="213"></td>
  </tr>
  <tr>
    <td colspan="5"><img src="${basePath}/images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="${basePath}/images/middle2.jpg">&nbsp;</td>
    <td width="172">
	<table align="center">
		<tr>
		  <td><a href="fw_indexquery.action">返回首页</a></td>
		</tr>
		<tr>
		  <td><a href="${basePath}/page/reg.jsp">用户注册</a></td>
		</tr>
	</table>
	</td>
    <td width="35" background="${basePath}/images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<form action="user_login.action" method="post" name="myForm" onsubmit="return login()">
		<table align="center">
			<tr>
				<td colspan="2" align="center">
								
				</td>
			</tr>
			<tr>
				<td>用户登陆：</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="user.uname"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="user.upass"></td>
			</tr>
			<tr>
				<td>
				<input type="hidden" name="sign" value="login"/>
				<input type="submit" value="登陆" class="btn">
				</td>
			</tr>
		</table>
	</form>
	</td>
    <td width="40" background="${basePath}/images/middle4.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5"><img src="${basePath}/images/bottom.jpg" width="780" height="82"></td>
  </tr>
</table>
<P align="center">2007 Beijing Aptech Beida Jade Bird Information Technology Co.,Ltd 版权所有</P>
<br/>
</BODY>
</HTML>